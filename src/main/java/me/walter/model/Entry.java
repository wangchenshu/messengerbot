package me.walter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * Created by chenshuwang on 2016/7/22.
 */
@Accessors(chain=true)
public class Entry {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("time")
    private Long time;

    @JsonProperty("messaging")
    private List<Messaging> messaging;

    public Long getId() {
        return id;
    }

    public Long getTime() {
        return time;
    }

    public List<Messaging> getMessaging() {
        return messaging;
    }

    @Override
    public String toString() {
        return String.format("id: %s, time: %s, messaging: %s", getId(), getTime(), getMessaging());
    }
}
