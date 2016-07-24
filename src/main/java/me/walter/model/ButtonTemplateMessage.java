package me.walter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chenshuwang on 2016/7/24.
 */
public class ButtonTemplateMessage {
    @JsonProperty("sender")
    private Recipient recipient;

    @JsonProperty("message")
    private ButtonTemplateMessageReq message;

    public ButtonTemplateMessage(Recipient recipient, ButtonTemplateMessageReq message) {
        this.recipient = recipient;
        this.message = message;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public ButtonTemplateMessageReq getMessage() {
        return message;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public void setMessage(ButtonTemplateMessageReq message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("recipient: %s, message: %s", getRecipient(), getMessage());
    }
}
