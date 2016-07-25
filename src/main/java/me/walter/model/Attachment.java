package me.walter.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by chenshuwang on 2016/7/24.
 */
@Accessors(chain=true)
public class Attachment {

    @Getter
    @Setter
    @SerializedName("type")
    private String type;

    @Getter
    @Setter
    @SerializedName("payload")
    private Payload payload;

    @Override
    public String toString() {
        return new StringBuffer()
            .append("type: " + getType())
            .append("payload: " + getPayload()).toString();
    }
}
