package me.walter.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by chenshuwang on 2016/7/24.
 */
public class ButtonTemplateMessageReq {

    @Getter
    @Setter
    @SerializedName("attachment")
    private TemplateAttachment attachment;

    public ButtonTemplateMessageReq(TemplateAttachment attachment) {
        this.attachment = attachment;
    }
}
