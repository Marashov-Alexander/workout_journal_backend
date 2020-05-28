package journal.workout.models.requests;

import javax.validation.constraints.NotNull;

public class ExerciseParameterBody {

    @NotNull
    private Long exercise_id;

    @NotNull
    private Long parameter_id;

    public Long getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Long exercise_id) {
        this.exercise_id = exercise_id;
    }

    public Long getParameter_id() {
        return parameter_id;
    }

    public void setParameter_id(Long parameter_id) {
        this.parameter_id = parameter_id;
    }
}
