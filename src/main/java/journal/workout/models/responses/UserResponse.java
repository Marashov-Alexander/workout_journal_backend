package journal.workout.models.responses;

import journal.workout.models.User;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserResponse {

    public UserResponse(User user) {
        this.id = user.getId();
        this.uid = user.getUid();
        this.first_name = user.getFirst_name();
        this.last_name = user.getLast_name();
        this.email = user.getEmail();
        this.birthday = user.getBirthday();
        this.gender = user.getGender();
        this.avatarUrl = user.getAvatarUrl();
    }

    private Long id;

    @NotNull
    @NotEmpty
    private String uid;

    @NotNull
    @NotEmpty
    private String first_name;

    private String last_name;

    @NotNull
    @NotEmpty
    private String email;

    private Date birthday;

    private String gender;

    private String avatarUrl;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
