package me.walter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by chenshuwang on 2016/7/22.
 */
@Accessors(chain=true)
public class WebHookRequest {

    @JsonProperty("object")
    private String object;

    @JsonProperty("entry")
    private List<Entry> entry;

    public String getObject() {
        return object;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    @Override
    public String toString() {
        return String.format("object: %s, entry: %s", getObject(), getEntry());
    }
}
