package me.walter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Created by chenshuwang on 2016/7/22.
 */
@Accessors(chain=true)
public class Messaging {

    @JsonProperty("sender")
    private Sender sender;

    @JsonProperty("recipient")
    private Recipient recipient;

    @JsonProperty("timestamp")
    private Long timestamp;

    @JsonProperty("message")
    private MessageRes message;

    public Sender getSender() {
        return sender;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public Long geTimestamp() {
        return timestamp;
    }

    public MessageRes geMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format(
            "sender: %s, recipient: %s, timestamp: %s, message: %s",
                getSender(), getRecipient(), geTimestamp(), geMessage());
    }
}
