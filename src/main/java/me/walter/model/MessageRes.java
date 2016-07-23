package me.walter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by chenshuwang on 2016/7/22.
 */
@Accessors(chain=true)
public class MessageRes {

    @JsonProperty("mid")
    private String mid;

    @JsonProperty("seq")
    private Integer seq;

    @JsonProperty("text")
    private String text;

    public String getMid() {
        return mid;
    }

    public Integer getSeq() {
        return seq;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return String.format("mid: %s, seq: %s, text: %s", getMid(), getSeq(), getText());
    }
}

