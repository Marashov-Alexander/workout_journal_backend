package journal.workout.repositories;

import journal.workout.models.ExerciseParameter;
import org.springframework.data.repository.CrudRepository;

public interface ExercisesParametersRepository extends CrudRepository<ExerciseParameter, Long> {

}
