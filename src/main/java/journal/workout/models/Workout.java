package journal.workout.models;

import javax.persistence.*;

@Entity
@Table(name = "workouts", schema = "WJDB")
public class Workout {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "planned_time")
    private String planned_time;

    @Column(name = "weekdays_mask")
    private Integer weekdays_mask;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
