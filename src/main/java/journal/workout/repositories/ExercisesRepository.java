package journal.workout.repositories;

import journal.workout.models.Exercise;
import journal.workout.models.ExerciseType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ExercisesRepository extends CrudRepository<Exercise, Long> {
    List<Exercise> findAll();
    Optional<List<Exercise>> findAllByExerciseType(ExerciseType exerciseType);
}
