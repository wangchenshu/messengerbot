package me.walter.service;

import me.walter.model.TextMessageRequest;
import me.walter.model.UserProfile;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

/**
 * Created by chenshuwang on 2016/7/22.
 */
public interface WebHookService {
    @POST("me/messages/")
    Observable<Void> sendTextMessage(
        @Query("access_token") String accessToken,
        @Body TextMessageRequest textMessageRequest
    );

    @GET("{userId}")
    Observable<UserProfile> getUserProfile(
        @Path("userId") Long userId,
        @Query("fields") String fields,
        @Query("access_token") String accessToken
    );
}
