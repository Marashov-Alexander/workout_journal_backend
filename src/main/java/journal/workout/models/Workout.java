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

    @Column(name = "description")
    private String description;

    public Long findId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String findName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String findDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
