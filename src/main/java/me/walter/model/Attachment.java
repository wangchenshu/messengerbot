package me.walter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.experimental.Accessors;

/**
 * Created by chenshuwang on 2016/7/24.
 */
@Accessors(chain=true)
public class Attachment {

    @JsonProperty("type")
    private String type;

    @JsonProperty("payload")
    private Payload payload;

    public String getType() {
        return type;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return String.format("type: %s, payload: %s", getType(), getPayload());
    }
}
