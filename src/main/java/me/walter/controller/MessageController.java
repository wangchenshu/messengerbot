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
import spark.Response;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

import static java.lang.System.out;
import static spark.Spark.*;

/**
 * Created by chenshuwang on 2016/7/22.
 */
public class MessageController implements Callable<Integer> {
    private Request req;
    private String userName;

    public MessageController(Request req) {
        this.req = req;
    }

    public Integer call() {
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
            String object = rootNode.get("object").textValue();
            out.println("object: " + object);

            if (entryNodes.isArray()) {
                for(JsonNode entryNode : entryNodes) {
                    Entry entry = mapper.treeToValue(entryNode, Entry.class);
                    List<Messaging> messagings = entry.getMessaging();

                    for (Messaging messaging : messagings) {
                        String text = messaging.geMessage().getText();
                        MessageMatch messageMatch = new MessageMatch();
                        Long senderId = messaging.getSender().getId();
                        Recipient recipient = new Recipient();
                        recipient.setId(senderId);

                        getUserProfile(senderId, accessToken, service)
                            .subscribe(
                                userProfile -> {
                                    userName = userProfile.getLastName()+" "+userProfile.getFirstName();
                                    sendTextMessage(userName, recipient, accessToken, service);
                                }
                               // error -> out.println("on error: " + error),
                                // () -> out.println("on complete")
                            );

                        sendTextMessage(MessageData.sendText.get("h4"), recipient, accessToken, service);
                        messageMatch.findReg(text)
                            .subscribe(isFind -> sendTextMessage(
                                MessageData.sendText.get("register"), recipient, accessToken, service));
                        messageMatch.findContact(text)
                            .subscribe(isFind -> sendTextMessage(
                                MessageData.sendText.get("contact-us"), recipient, accessToken, service));
                        messageMatch.findBegin(text)
                            .subscribe(isFind -> sendTextMessage(
                                MessageData.sendText.get("h4-beginning"), recipient, accessToken, service));
                        messageMatch.findGo(text)
                            .subscribe(isFind -> sendTextMessage(
                                MessageData.sendText.get("h4-place"), recipient, accessToken, service));
                        messageMatch.findDo(text)
                            .subscribe(isFind -> sendTextMessage(
                                MessageData.sendText.get("h4-people-do"), recipient, accessToken, service));
                        messageMatch.findWhat(text)
                            .subscribe(isFind -> sendTextMessage(
                                MessageData.sendText.get("h4-helper"), recipient, accessToken, service));
                        messageMatch.findFb(text)
                            .subscribe(isFind -> sendTextMessage(MessageData.h4Fb, recipient, accessToken, service));
                        messageMatch.findMeetup(text)
                            .subscribe(isFind -> sendTextMessage(MessageData.h4Meetup, recipient, accessToken, service));
                        messageMatch.findWeb(text)
                            .subscribe(isFind -> sendTextMessage(MessageData.h4Web, recipient, accessToken, service));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public void sendTextMessage(String sendText, Recipient recipient, String accessToken, WebHookService service) {
        MessageReq messageReq = new MessageReq(sendText);
        TextMessageRequest textMessageRequest = new TextMessageRequest(recipient, messageReq);

        Observable<Void> resText = service.sendTextMessage(accessToken, textMessageRequest);
        resText.subscribe(
            (it) -> out.println()
            //error -> out.println("on error: " + error),
            //() -> out.println("on complete")
        );
    }

    public Observable<UserProfile> getUserProfile(Long userId, String accessToken, WebHookService service) {
        return service.getUserProfile(userId, "first_name,last_name,profile_pic,locale,timezone,gender", accessToken);
    }
}
