package me.walter.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by chenshuwang on 2016/7/24.
 */
@Accessors(chain=true)
public class TemplateButton {

    @Getter
    @Setter
    @SerializedName("type")
    private String type;

    @Getter
    @Setter
    @SerializedName("url")
    private String url;

    @Getter
    @Setter
    @SerializedName("title")
    private String title;

    @Override
    public String toString() {
        return new StringBuffer()
            .append("type: " + getType())
            .append("url: " + getUrl())
            .append("title: " + getTitle()).toString();
    }
}
