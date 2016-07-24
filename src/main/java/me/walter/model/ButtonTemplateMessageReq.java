package me.walter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chenshuwang on 2016/7/24.
 */
public class ButtonTemplateMessageReq {

    @JsonProperty("attachment")
    private TemplateAttachment attachment;

    public ButtonTemplateMessageReq(TemplateAttachment attachment) {
        this.attachment = attachment;
    }

    public void setAttachment(TemplateAttachment attachment) {
        this.attachment = attachment;
    }

    public TemplateAttachment getAttachment() {
        return attachment;
    }
}
