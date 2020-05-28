package journal.workout.models.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class WorkoutBody {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String planned_time;

    @NotNull
    @NotEmpty
    private Integer weekdays_mask;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanned_time() {
        return planned_time;
    }

    public void setPlanned_time(String planned_time) {
        this.planned_time = planned_time;
    }

    public Integer getWeekdays_mask() {
        return weekdays_mask;
    }

    public void setWeekdays_mask(Integer weekdays_mask) {
        this.weekdays_mask = weekdays_mask;
    }
}
