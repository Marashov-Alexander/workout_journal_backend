package journal.workout.models;

import javax.persistence.*;

@Entity
@Table(name = "workouts_exercises", schema = "WJDB")
public class WorkoutExercise {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    public Long findId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Workout findWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Exercise findExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
