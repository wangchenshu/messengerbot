package me.walter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by chenshuwang on 2016/7/22.
 */
@Accessors(chain=true)
public class Sender {

    @JsonProperty("id")
    private Long id;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("id: %s", getId());
    }
}
