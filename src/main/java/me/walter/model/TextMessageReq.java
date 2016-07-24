package me.walter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chenshuwang on 2016/7/23.
 */
public class TextMessageReq {
    @JsonProperty("text")
    private String text;

    public TextMessageReq(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }


}
