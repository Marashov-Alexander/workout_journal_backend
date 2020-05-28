package journal.workout.models.requests;

public class ParameterResultBody {

    private Long done_exercise_id;

    private Long parameter_id;

    private Float value;

    public Long getDone_exercise_id() {
        return done_exercise_id;
    }

    public void setDone_exercise_id(Long done_exercise_id) {
        this.done_exercise_id = done_exercise_id;
    }

    public Long getParameter_id() {
        return parameter_id;
    }

    public void setParameter_id(Long parameter_id) {
        this.parameter_id = parameter_id;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
