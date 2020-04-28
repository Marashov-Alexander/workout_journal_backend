package journal.workout.models.requests;

import javax.validation.constraints.NotNull;

public class WorkoutExerciseBody {

    @NotNull
    private Long workoutId;

    @NotNull
    private Long exerciseId;

    public Long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Long workoutId) {
        this.workoutId = workoutId;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }
}
