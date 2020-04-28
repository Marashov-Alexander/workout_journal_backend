package journal.workout.models;

import javax.persistence.*;

@Entity
@Table(name = "userworkouts_parametervalues", schema = "WJDB")
public class UserWorkoutParameterValue {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userWorkout_id")
    private UserWorkout userWorkout;

    @ManyToOne
    @JoinColumn(name = "parameter_id")
    private Parameter parameter;

    @Column(name = "value")
    private Integer value;

    public Long findId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserWorkout findUserWorkout() {
        return userWorkout;
    }

    public void setUserWorkout(UserWorkout userWorkout) {
        this.userWorkout = userWorkout;
    }

    public Parameter findParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public Integer findValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
