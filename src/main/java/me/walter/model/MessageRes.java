package me.walter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by chenshuwang on 2016/7/22.
 */
@Accessors(chain=true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageRes {

    @Getter
    @Setter
    @SerializedName("mid")
    private String mid;

    @Getter
    @Setter
    @SerializedName("seq")
    private Integer seq;

    @Getter
    @Setter
    @SerializedName("text")
    private String text;

    @Getter
    @Setter
    @SerializedName("sticker_id")
    private Long stickerId;

    @Getter
    @Setter
    @SerializedName("attachments")
    private List<Attachment> attachments;

    @Override
    public String toString() {
        return new StringBuffer()
            .append("mid: " + getMid())
            .append("seq: " + getSeq())
            .append("text: " + getText())
            .append("stickerId: " + getStickerId())
            .append("attachments: " + getAttachments()).toString();
    }
}

