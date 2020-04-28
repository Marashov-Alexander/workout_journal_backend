package journal.workout.models.requests;

import javax.validation.constraints.NotNull;

public class ExerciseTypeBody {

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
