package journal.workout.models.requests;

import javax.validation.constraints.NotNull;

public class ExerciseParameterBody {

    @NotNull
    private Long exerciseId;

    @NotNull
    private Long parameterId;

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Long getParameterId() {
        return parameterId;
    }

    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
    }
}
