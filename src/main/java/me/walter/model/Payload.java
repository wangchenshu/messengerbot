package me.walter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.experimental.Accessors;

/**
 * Created by chenshuwang on 2016/7/24.
 */
@Accessors(chain=true)
public class Payload {

    @JsonProperty("url")
    private String url;

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    @Override
    public String toString() {
        return String.format("url: %s", getUrl());
    }
}
