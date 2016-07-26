package me.walter.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by chenshuwang on 2016/7/23.
 */
public class SendMessage {

    @Getter
    @Setter
    @SerializedName("text")
    private String text;

    @Getter
    @Setter
    @SerializedName("quick_replies")
    private List<QuickReplies> quickReplies;

    public SendMessage(String text) {
        this.text = text;
    }

    public SendMessage(String text, List<QuickReplies> quickReplies) {
        this.text = text;
        this.quickReplies = quickReplies;
    }
}
