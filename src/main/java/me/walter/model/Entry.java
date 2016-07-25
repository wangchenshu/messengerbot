package me.walter.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by chenshuwang on 2016/7/22.
 */
@Accessors(chain=true)
public class Entry {

    @Getter
    @Setter
    @SerializedName("id")
    private Long id;

    @Getter
    @Setter
    @SerializedName("time")
    private Long time;

    @Getter
    @Setter
    @SerializedName("messaging")
    private List<Messaging> messaging;

    @Override
    public String toString() {
        return new StringBuffer()
            .append("id: " + getId())
            .append("time: " + getTime())
            .append("messaging: " + getMessaging()).toString();
    }
}
