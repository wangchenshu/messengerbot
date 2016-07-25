package me.walter.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by chenshuwang on 2016/7/24.
 */
public class ButtonTemplateMessage {

    @Getter
    @Setter
    @SerializedName("recipient")
    private Recipient recipient;

    @Getter
    @Setter
    @SerializedName("message")
    private ButtonTemplateMessageReq message;

    public ButtonTemplateMessage(Recipient recipient, ButtonTemplateMessageReq message) {
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public String toString() {
        return new StringBuffer()
            .append("recipient: " + getRecipient())
            .append("message: " + getMessage()).toString();
    }
}
