package me.walter.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by chenshuwang on 2016/7/23.
 */
@Accessors(chain=true)
public class UserProfile {

    @Getter
    @Setter
    @SerializedName("first_name")
    private String firstName;

    @Getter
    @Setter
    @SerializedName("last_name")
    private String lastName;

    @Getter
    @Setter
    @SerializedName("profile_pic")
    private String profilePic;

    @Getter
    @Setter
    @SerializedName("locale")
    private String locale;

    @Getter
    @Setter
    @SerializedName("timezone")
    private Integer timezone;

    @Getter
    @Setter
    @SerializedName("gender")
    private String gender;

    @Override
    public String toString() {
        return new StringBuffer()
            .append("firstName: " + getFirstName())
            .append("lastName: " + getLastName())
            .append("profilePic: " + getProfilePic())
            .append("locale: " + getLocale())
            .append("timezone: " + getTimezone())
            .append("gender: " + getGender()).toString();
    }
}
