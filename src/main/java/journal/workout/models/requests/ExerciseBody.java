package journal.workout.models.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ExerciseBody {

    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    private Long exercise_type_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getExercise_type_id() {
        return exercise_type_id;
    }

    public void setExercise_type_id(Long exercise_type_id) {
        this.exercise_type_id = exercise_type_id;
    }
}
