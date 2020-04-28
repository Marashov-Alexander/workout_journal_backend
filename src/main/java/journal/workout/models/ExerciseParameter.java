package journal.workout.models;

import javax.persistence.*;

@Entity
@Table(name = "exercises_parameters", schema = "WJDB")
public class ExerciseParameter {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "parameter_id")
    private Parameter parameter;

    public Long findId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exercise findExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Parameter findParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }
}
