package journal.workout.models.requests;

import javax.validation.constraints.NotNull;

public class WorkoutExerciseBody {

    @NotNull
    private Long workout_id;

    @NotNull
    private Long exercise_id;

    public Long getWorkout_id() {
        return workout_id;
    }

    public void setWorkout_id(Long workout_id) {
        this.workout_id = workout_id;
    }

    public Long getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Long exercise_id) {
        this.exercise_id = exercise_id;
    }
}
