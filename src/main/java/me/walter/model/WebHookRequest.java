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
public class WebHookRequest {

    @Getter
    @Setter
    @SerializedName("object")
    private String object;

    @Getter
    @Setter
    @SerializedName("entry")
    private List<Entry> entry;

    @Override
    public String toString() {
        return new StringBuffer()
                .append("object: " + getObject())
                .append("entry: " + getEntry()).toString();
    }
}
