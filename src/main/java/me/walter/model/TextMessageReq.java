package me.walter.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by chenshuwang on 2016/7/23.
 */
public class TextMessageReq {

    @Getter
    @Setter
    @SerializedName("text")
    private String text;

    public TextMessageReq(String text) {
        this.text = text;
    }
}
