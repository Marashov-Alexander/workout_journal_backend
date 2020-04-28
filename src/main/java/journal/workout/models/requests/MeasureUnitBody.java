package journal.workout.models.requests;

import javax.validation.constraints.NotNull;

public class MeasureUnitBody {

    @NotNull
    private String name;

    @NotNull
    private String acronym;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
}
