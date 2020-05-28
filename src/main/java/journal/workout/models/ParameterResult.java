package journal.workout.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parameterresult", schema = "WJDB")
public class ParameterResult {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "done_exercise_id")
    private DoneExercise doneExercise;

    @ManyToOne
    @JoinColumn(name = "parameter_id")
    private Parameter parameter;

    @JoinColumn(name = "value")
    private Float value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DoneExercise getDoneExercise() {
        return doneExercise;
    }

    public void setDoneExercise(DoneExercise doneExercise) {
        this.doneExercise = doneExercise;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
