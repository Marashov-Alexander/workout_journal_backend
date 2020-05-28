package journal.workout.models.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserWorkoutBody {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private Long user_id;

    @NotNull
    private Long workout_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getWorkout_id() {
        return workout_id;
    }

    public void setWorkout_id(Long workout_id) {
        this.workout_id = workout_id;
    }
}
