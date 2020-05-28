package journal.workout.models.requests;

import javax.validation.constraints.NotNull;

public class UserWorkoutBody {

    @NotNull
    private Long workout_id;

    public Long getWorkout_id() {
        return workout_id;
    }

    public void setWorkout_id(Long workout_id) {
        this.workout_id = workout_id;
    }
}
