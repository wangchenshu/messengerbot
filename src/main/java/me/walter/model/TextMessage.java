package me.walter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chenshuwang on 2016/7/23.
 */
public class TextMessage {
    @JsonProperty("sender")
    private Recipient recipient;

    @JsonProperty("message")
    private TextMessageReq message;

    public TextMessage(Recipient recipient, TextMessageReq message) {
        this.recipient = recipient;
        this.message = message;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public TextMessageReq getMessage() {
        return message;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public void setMessage(TextMessageReq message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("recipient: %s, message: %s", getRecipient(), getMessage());
    }
}
