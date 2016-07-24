package me.walter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by chenshuwang on 2016/7/24.
 */
@Accessors(chain=true)
public class TemplatePayload {

    @SerializedName("template_type")
    private String templateType;

    @JsonProperty("text")
    private String text;

    @JsonProperty("buttons")
    private List<TemplateButton> buttons;

    public String getTemplateType() {
        return templateType;
    }

    public String getText() {
        return text;
    }

    public List<TemplateButton> getButtons() {
        return buttons;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setButtons(List<TemplateButton> buttons) {
        this.buttons = buttons;
    }

    @Override
    public String toString() {
        return String.format("templateType: %s, text: %s, buttons: %s", getTemplateType(), getText(), getButtons());
    }
}
