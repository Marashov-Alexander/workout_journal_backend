package journal.workout.models.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ParameterBody {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private String measure_unit;

    @NotNull
    private Integer result_type;

    @NotNull
    private Float value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasure_unit() {
        return measure_unit;
    }

    public void setMeasure_unit(String measure_unit_id) {
        this.measure_unit = measure_unit_id;
    }

    public Integer getResult_type() {
        return result_type;
    }

    public void setResult_type(Integer result_type) {
        this.result_type = result_type;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
