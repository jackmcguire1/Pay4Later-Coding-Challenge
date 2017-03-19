package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by jackm on 10/11/2016.
 */
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)

public class User {
    @JsonProperty("user_id")
    @XmlElement(name = "userid")
    private int userId;
    @JsonProperty("username")
    private String username;
    @JsonProperty("first_name")
    @XmlElement(name = "firstname")
    private String firstName;
    @JsonProperty("last_name")
    @XmlElement(name = "surname")
    private String lastName;
    @JsonProperty("user_type")
    @XmlElement(name = "type")
    private String UserType;
    @JsonProperty("last_login_time")
    @XmlElement(name = "lastlogintime")
    private String lastLoginTime;

    @JsonProperty("user_id")
    public int getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("user_type")
    public String getUserType() {
        return UserType;
    }

    @JsonProperty("user_type")
    public void setUserType(String userType) {
        UserType = userType;
    }

    @JsonProperty("last_login_time")
    public String getLastLoginTime() {
        return lastLoginTime;
    }

    @JsonProperty("last_login_time")
    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
