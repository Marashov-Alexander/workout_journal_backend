package journal.workout.models.requests;

import javax.validation.constraints.NotNull;

public class UserBody {

    @NotNull
    private String first_name;

    private String last_name;

    @NotNull
    private String email;

    private String password;

    private Character isMale;

    @NotNull
    private Integer age;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Character getIsMale() {
        return isMale;
    }

    public void setIsMale(Character isMale) {
        this.isMale = isMale;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
