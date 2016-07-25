package me.walter.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import me.walter.config.PropertiesCache;
import me.walter.model.*;
import me.walter.operation.ImageOperation;
import me.walter.service.WebHookService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import spark.Request;

import java.io.IOException;
import java.util.*;

import static java.lang.System.out;

/**
 * Created by chenshuwang on 2016/7/22.
 */
public class MessageController {
    private UserProfile userProfile_p;
    private static final int OK = 200;

    //@Inject
    //PropertiesCache propertiesCache;

    public MessageController() {
    }

    public Integer process(Request req) {
        ObjectMapper mapper = new ObjectMapper();
        String baseUrl = PropertiesCache.getInstance().getProperty("baseUrl");
        String accessToken = PropertiesCache.getInstance().getProperty("accessToken");

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();
        WebHookService service = retrofit.create(WebHookService.class);

        try {
            JsonNode rootNode = mapper.readTree(req.body());
            JsonNode entryNodes = rootNode.get("entry");

            if (entryNodes.isArray()) {
                for(JsonNode entryNode : entryNodes) {
                    out.println(entryNode);
                    Entry entry = mapper.treeToValue(entryNode, Entry.class);
                    List<Messaging> messagings = entry.getMessaging();

                    for (Messaging messaging : messagings) {
                        Long senderId = messaging.getSender().getId();
                        Recipient recipient = new Recipient();
                        recipient.setId(senderId);
                        userProfile_p = new UserProfile();

                        if (messaging.getMessage().getAttachments() != null) {
                            MessageRes messageRes = messaging.getMessage();
                            List<Attachment> attachments = messageRes.getAttachments();

                            for (Attachment attachment : attachments) {
                                if (attachment.getType().equals("image")) {
                                    sendAttachmentMessage(attachment.getType(), attachment.getPayload(), recipient, accessToken, service);
                                } else if (attachment.getType().equals("button")) {
                                    out.println(attachment.getType());
                                } else if (attachment.getType().equals("generic")) {
                                    out.println(attachment.getType());
                                } else if (attachment.getType().equals("receipt")) {
                                    out.println(attachment.getType());
                                }
                            }
                        } else {
                            String text = messaging.getMessage().getText();
                            MessageMatch messageMatch = new MessageMatch();

                            getUserProfile(senderId, accessToken, service).subscribe(userProfile -> userProfile_p = userProfile);
                            String userName = userProfile_p.getFirstName() + " " + userProfile_p.getLastName();

                            if (messageMatch.findContact(text)) {
                                sendTextMessage(MessageData.sendText.get("contact-us"), recipient, accessToken, service);
                            }

                            if (messageMatch.findGo(text)) {
                                sendTextMessage(MessageData.sendText.get("h4-place"), recipient, accessToken, service);
                            }

                            if (messageMatch.findDo(text)) {
                                sendTextMessage(MessageData.sendText.get("h4-people-do"), recipient, accessToken, service);
                            }

                            if (messageMatch.findBegin(text)) {
                                sendTextMessage(MessageData.sendText.get("h4-beginning"), recipient, accessToken, service);
                            }

                            if (messageMatch.findWhat(text)) {
                                sendTextMessage(MessageData.sendText.get("h4-helper"), recipient, accessToken, service);
                            }

                            if (messageMatch.findFb(text)) {
                                sendTextMessage(MessageData.h4Fb, recipient, accessToken, service);
                            }

                            if (messageMatch.findMeetup(text)) {
                                sendTextMessage(MessageData.h4Meetup, recipient, accessToken, service);
                            }

                            if (messageMatch.findWeb(text)) {
                                sendTextMessage(MessageData.h4Web, recipient, accessToken, service);
                            }

                            if (messageMatch.findThanks(text)) {
                                sendTextMessage(MessageData.urwelcome, recipient, accessToken, service);
                            }

                            if (messageMatch.findBao(text)) {
                                Attachment attachment = new ImageOperation().createAttachment(MessageData.imageLink.get("baobao"));
                                sendAttachmentMessage(attachment.getType(), attachment.getPayload(), recipient, accessToken, service);
                            }

                            if (messageMatch.findBmw(text)) {
                                Observable<Attachment> attachmentObservable = new ImageOperation()
                                    .getAttachmentByImageUrls(MessageData.sellImageLink.get("bmw-1"));
                                sendAttachmentsMessage(attachmentObservable, recipient, accessToken, service);
                            }

                            if (messageMatch.findReg(text)) {
                                sendTextMessage(
                                    userName + " " + MessageData.sendText.get("register"),
                                    recipient,
                                    accessToken,
                                    service
                                );
                            }

                            TemplatePayload templatePayload = new TemplatePayload();
                            List<TemplateButton> templateButtons = createTemplateButton();

                            templatePayload.setTemplateType("button");
                            templatePayload.setText("What do you want to do next?");
                            templatePayload.setButtons(templateButtons);

                            sendButtonTemplateMessage("template", templatePayload, recipient, accessToken, service);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return OK;
    }

    private void sendTextMessage(String sendText, Recipient recipient, String accessToken, WebHookService service) {
        TextMessageReq textMessageReq = new TextMessageReq(sendText);
        TextMessage textMessage = new TextMessage(recipient, textMessageReq);

        service.sendTextMessage(accessToken, textMessage).subscribe();
    }

    private void sendAttachmentMessage(String type, Payload payload, Recipient recipient, String accessToken, WebHookService service) {
        Attachment attachment = new Attachment();
        attachment.setType(type);
        attachment.setPayload(payload);

        AttachmentMessageReq attachmentMessageReq = new AttachmentMessageReq(attachment);
        AttachmentMessage attachmentMessage = new AttachmentMessage(recipient, attachmentMessageReq);

        service.sendAttachmentMessage(accessToken, attachmentMessage).subscribe();
    }

    private void sendAttachmentsMessage(Observable<Attachment> attachmentObservable, Recipient recipient, String accessToken, WebHookService service) {
        attachmentObservable.subscribe(attachment -> {
            AttachmentMessageReq attachmentMessageReq = new AttachmentMessageReq(attachment);
            AttachmentMessage attachmentMessage = new AttachmentMessage(recipient, attachmentMessageReq);

            service.sendAttachmentMessage(accessToken, attachmentMessage).subscribe();
        });

    }

    private void sendButtonTemplateMessage(String type, TemplatePayload payload, Recipient recipient, String accessToken, WebHookService service) {
        TemplateAttachment attachment = new TemplateAttachment();
        attachment.setType(type);
        attachment.setPayload(payload);

        ButtonTemplateMessageReq buttonTemplateMessageReq = new ButtonTemplateMessageReq(attachment);
        ButtonTemplateMessage buttonTemplateMessage = new ButtonTemplateMessage(recipient, buttonTemplateMessageReq);

        service.sendButtonTemplateMessage(accessToken, buttonTemplateMessage).subscribe(
                it -> out.println(),
                error -> out.println("on error: " + error)
        );
    }

    private Observable<UserProfile> getUserProfile(Long userId, String accessToken, WebHookService service) {
        return service.getUserProfile(userId, MessageData.fields, accessToken);
    }

    private List<TemplateButton> createTemplateButton() {
        List<TemplateButton> templateButtons = new ArrayList<>(3);

        try {
            TemplateButton templateButton1 = new TemplateButton();
            templateButton1.setType("web_url");
            templateButton1.setUrl(MessageData.h4Web);
            templateButton1.setTitle("Website");

            TemplateButton templateButton2 = new TemplateButton();
            templateButton2.setType("web_url");
            templateButton2.setUrl(MessageData.h4Fb);
            templateButton2.setTitle("FB");

            TemplateButton templateButton3 = new TemplateButton();
            templateButton3.setType("web_url");
            templateButton3.setUrl(MessageData.h4Meetup);
            templateButton3.setTitle("Meetup");

            templateButtons.add(templateButton1);
            templateButtons.add(templateButton2);
            templateButtons.add(templateButton3);

        } catch (Exception e) {
            out.println("ex: " + e);
        }

        return templateButtons;
    }
}
