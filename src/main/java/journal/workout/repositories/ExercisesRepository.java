package journal.workout.repositories;

import journal.workout.models.Exercise;
import journal.workout.models.ExerciseType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExercisesRepository extends CrudRepository<Exercise, Long> {
    List<Exercise> findAll();
    List<Exercise> findAllByExerciseType(ExerciseType exerciseType);
}
