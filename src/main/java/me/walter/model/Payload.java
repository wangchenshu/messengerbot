package me.walter.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by chenshuwang on 2016/7/24.
 */
@Accessors(chain=true)
public class Payload {

    @Getter
    @Setter
    @SerializedName("url")
    private String url;

    @Override
    public String toString() {
        return new StringBuffer().append("url: " + getUrl()).toString();
    }
}
