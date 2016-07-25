package me.walter.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by chenshuwang on 2016/7/22.
 */
@Accessors(chain=true)
public class Messaging {

    @Getter
    @Setter
    @SerializedName("sender")
    private Sender sender;

    @Getter
    @Setter
    @SerializedName("recipient")
    private Recipient recipient;

    @Getter
    @Setter
    @SerializedName("timestamp")
    private Long timestamp;

    @Getter
    @Setter
    @SerializedName("message")
    private MessageRes message;

    @Override
    public String toString() {
        return new StringBuffer()
            .append("sender: " + getSender())
            .append("recipient: " + getRecipient())
            .append("timestamp: " + getTimestamp())
            .append("message: " + getMessage()).toString();
    }
}
