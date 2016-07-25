package me.walter.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by chenshuwang on 2016/7/22.
 */
@Accessors(chain=true)
public class Sender {

    @Getter
    @Setter
    @SerializedName("id")
    private Long id;

    @Override
    public String toString() {
        return new StringBuffer().append("id: " + getId()).toString();
    }
}
