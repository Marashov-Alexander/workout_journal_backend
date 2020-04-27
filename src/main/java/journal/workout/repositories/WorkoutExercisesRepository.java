package journal.workout.repositories;

import journal.workout.models.WorkoutExercise;
import org.springframework.data.repository.CrudRepository;

public interface WorkoutExercisesRepository extends CrudRepository<WorkoutExercise, Long> {

}
