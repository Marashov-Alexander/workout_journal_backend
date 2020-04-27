package journal.workout.repositories;

import journal.workout.models.Exercise;
import org.springframework.data.repository.CrudRepository;

public interface ExercisesRepository extends CrudRepository<Exercise, Long> {

}
