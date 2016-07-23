package me.walter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.experimental.Accessors;

/**
 * Created by chenshuwang on 2016/7/23.
 */
@Accessors(chain=true)
public class UserProfile {

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("profile_pic")
    private String profilePic;

    @JsonProperty("locale")
    private String locale;

    @JsonProperty("timezone")
    private Integer timezone;

    @JsonProperty("gender")
    private String gender;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public String getLocale() {
        return locale;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("firstName: %s, lastName: %s, profilePic: %s, locale: %s, timezone: %d, gender: %s",
                getFirstName(), getLastName(), getProfilePic(), getLocale(), getTimezone(), getGender());
    }
}
