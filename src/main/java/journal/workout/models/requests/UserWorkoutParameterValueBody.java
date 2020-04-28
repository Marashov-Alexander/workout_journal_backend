package journal.workout.models.requests;

import javax.validation.constraints.NotNull;

public class UserWorkoutParameterValueBody {

    @NotNull
    private Long userWorkoutId;

    @NotNull
    private Long parameterId;

    @NotNull
    private Integer value;

    public Long getUserWorkoutId() {
        return userWorkoutId;
    }

    public void setUserWorkoutId(Long userWorkoutId) {
        this.userWorkoutId = userWorkoutId;
    }

    public Long getParameterId() {
        return parameterId;
    }

    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
