package journal.workout.models.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ParameterBody {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private Long measureUnitId;

    @NotNull
    private Long parameterTypeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMeasureUnitId() {
        return measureUnitId;
    }

    public void setMeasureUnitId(Long measureUnitId) {
        this.measureUnitId = measureUnitId;
    }

    public Long getParameterTypeId() {
        return parameterTypeId;
    }

    public void setParameterTypeId(Long parameterTypeId) {
        this.parameterTypeId = parameterTypeId;
    }
}
