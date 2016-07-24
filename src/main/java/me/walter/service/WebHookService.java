package me.walter.service;

import me.walter.model.AttachmentMessage;
import me.walter.model.TextMessage;
import me.walter.model.UserProfile;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by chenshuwang on 2016/7/22.
 */
public interface WebHookService {
    @POST("me/messages/")
    Observable<Void> sendTextMessage(
        @Query("access_token") String accessToken,
        @Body TextMessage textMessage
    );

    @POST("me/messages/")
    Observable<Void> sendAttachmentMessage(
        @Query("access_token") String accessToken,
        @Body AttachmentMessage attachmentMessage
    );

    @GET("{userId}")
    Observable<UserProfile> getUserProfile(
        @Path("userId") Long userId,
        @Query("fields") String fields,
        @Query("access_token") String accessToken
    );
}
