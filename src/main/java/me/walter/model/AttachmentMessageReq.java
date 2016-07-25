package me.walter.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by chenshuwang on 2016/7/24.
 */
public class AttachmentMessageReq {

    @Getter
    @Setter
    @SerializedName("attachment")
    private Attachment attachment;

    public AttachmentMessageReq(Attachment attachment) {
        this.attachment = attachment;
    }
}
