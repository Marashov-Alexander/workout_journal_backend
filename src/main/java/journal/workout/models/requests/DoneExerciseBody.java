package journal.workout.models.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class DoneExerciseBody {

    @NotNull
    @NotEmpty
    private Long exercise_id;

    @NotNull
    @NotEmpty
    private Long user_id;

    @NotNull
    @NotEmpty
    private Date date;

    public Long getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Long exercise_id) {
        this.exercise_id = exercise_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
