package journal.workout.repositories;

import journal.workout.models.Exercise;
import journal.workout.models.ExerciseParameter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExercisesParametersRepository extends CrudRepository<ExerciseParameter, Long> {
        List<ExerciseParameter> findAll();
        List<ExerciseParameter> getAllByExercise(Exercise exercise);
}
