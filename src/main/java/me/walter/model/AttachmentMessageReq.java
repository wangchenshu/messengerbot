package me.walter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chenshuwang on 2016/7/24.
 */
public class AttachmentMessageReq {

    @JsonProperty("attachment")
    private Attachment attachment;

    public AttachmentMessageReq(Attachment attachment) {
        this.attachment = attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public Attachment getAttachment() {
        return attachment;
    }
}
