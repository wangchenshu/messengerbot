package me.walter.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.walter.model.*;
import me.walter.service.WebHookService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import spark.Request;

import java.io.IOException;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by chenshuwang on 2016/7/22.
 */
public class MessageController {
    private UserProfile userProfile_p;
    private static final int OK = 200;

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
            //String object = rootNode.get("object").textValue();

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
                        //out.println(messaging);

                        if (messaging.geMessage().getAttachments() != null) {
                            MessageRes messageRes = messaging.geMessage();
                            List<Attachment> attachments = messageRes.getAttachments();

                            for (Attachment attachment : attachments) {
                                if (attachment.getType().equals("image")) {
                                    out.println(attachment.getType());
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
                            String text = messaging.geMessage().getText();
                            MessageMatch messageMatch = new MessageMatch();

                            getUserProfile(senderId, accessToken, service)
                                .subscribe(
                                    userProfile -> userProfile_p = userProfile,
                                    error -> out.println("(getUserProfile) on error: " + error),
                                    () -> {
                                        //out.println("(getUserProfile) on complete");
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

                                        if (messageMatch.findReg(text)) {
                                            sendTextMessage(
                                                userName + " " + MessageData.sendText.get("register"),
                                                recipient,
                                                accessToken,
                                                service
                                            );
                                        }
                                    }
                                );
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return OK;
    }

    public void sendTextMessage(String sendText, Recipient recipient, String accessToken, WebHookService service) {
        TextMessageReq textMessageReq = new TextMessageReq(sendText);
        TextMessage textMessage = new TextMessage(recipient, textMessageReq);

        Observable<Void> resText = service.sendTextMessage(accessToken, textMessage);
        resText.subscribe(
            (it) -> out.println()
            //error -> out.println("(sendTextMessage) on error: " + error),
            //() -> out.println("(sendTextMessage) on complete")
        );
    }

    public void sendAttachmentMessage(String type, Payload payload, Recipient recipient, String accessToken, WebHookService service) {
        Attachment attachment = new Attachment();
        attachment.setType(type);
        attachment.setPayload(payload);

        AttachmentMessageReq attachmentMessageReq = new AttachmentMessageReq(attachment);
        AttachmentMessage attachmentMessage = new AttachmentMessage(recipient, attachmentMessageReq);

        Observable<Void> resText = service.sendAttachmentMessage(accessToken, attachmentMessage);
        resText.subscribe(
            (it) -> out.println()
            //error -> out.println("(sendTextMessage) on error: " + error),
            //() -> out.println("(sendTextMessage) on complete")
        );
    }

    public Observable<UserProfile> getUserProfile(Long userId, String accessToken, WebHookService service) {
        return service.getUserProfile(userId, MessageData.fields, accessToken);
    }
}
