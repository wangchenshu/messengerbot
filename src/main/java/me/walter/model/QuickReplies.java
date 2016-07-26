package me.walter.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by chenshuwang on 2016/7/26.
 */
public class QuickReplies {

    @Getter
    @Setter
    @SerializedName("content_type")
    private String contentType;

    @Getter
    @Setter
    @SerializedName("title")
    private String title;

    @Getter
    @Setter
    @SerializedName("payload")
    private String payload;

    public QuickReplies(String contentType, String title, String payload) {
        this.contentType = contentType;
        this.title = title;
        this.payload = payload;
    }

    @Override
    public String toString() {
        return new StringBuffer()
            .append("contentType: " + getContentType())
            .append("title: " + getTitle())
            .append("payload: " + getPayload())
            .toString();
    }
}
