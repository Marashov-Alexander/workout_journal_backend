package journal.workout.models;

import javax.persistence.*;

@Entity
@Table(name = "exercises", schema = "WJDB")
public class Exercise {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ExerciseType exerciseType;

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

    public ExerciseType findExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }
}
