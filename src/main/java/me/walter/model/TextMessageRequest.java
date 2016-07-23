package me.walter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chenshuwang on 2016/7/23.
 */
public class TextMessageRequest {
    @JsonProperty("sender")
    private Recipient recipient;

    @JsonProperty("message")
    private MessageReq message;

    public TextMessageRequest(Recipient recipient, MessageReq message) {
        this.recipient = recipient;
        this.message = message;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public MessageReq getMessage() {
        return message;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public void setMessage(MessageReq message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("recipient: %s, message: %s", getRecipient(), getMessage());
    }
}
