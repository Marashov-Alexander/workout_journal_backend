package journal.workout.repositories;

import journal.workout.models.ExerciseType;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseTypesRepository extends CrudRepository<ExerciseType, Long> {

}
