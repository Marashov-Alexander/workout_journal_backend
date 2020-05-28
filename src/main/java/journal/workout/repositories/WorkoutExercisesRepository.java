package journal.workout.repositories;

import journal.workout.models.Workout;
import journal.workout.models.WorkoutExercise;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface WorkoutExercisesRepository extends CrudRepository<WorkoutExercise, Long> {
    List<WorkoutExercise> findAll();

    Optional<List<WorkoutExercise>> findAllByWorkout(Workout workout);
    List<WorkoutExercise> getAllByWorkout(Workout workout);
}
