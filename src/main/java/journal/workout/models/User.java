package journal.workout.models;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "WJDB")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "is_male")
    private Character isMale;

    @Column(name = "age")
    private Integer age;

    public Long findId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String findFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String findLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String findEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String findPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Character findIsMale() {
        return isMale;
    }

    public void setIsMale(Character isMale) {
        this.isMale = isMale;
    }

    public Integer findAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
