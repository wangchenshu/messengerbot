package me.walter.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by chenshuwang on 2016/7/24.
 */
@Accessors(chain=true)
public class TemplatePayload {

    @Getter
    @Setter
    @SerializedName("template_type")
    private String templateType;

    @Getter
    @Setter
    @SerializedName("text")
    private String text;

    @Getter
    @Setter
    @SerializedName("buttons")
    private List<TemplateButton> buttons;

    @Override
    public String toString() {
        return new StringBuffer()
            .append("templateType: " + getTemplateType())
            .append("text: " + getText())
            .append("buttons: " + getButtons()).toString();
    }
}
