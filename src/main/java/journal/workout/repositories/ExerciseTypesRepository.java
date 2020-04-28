package journal.workout.repositories;

import journal.workout.models.ExerciseType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExerciseTypesRepository extends CrudRepository<ExerciseType, Long> {
    List<ExerciseType> findAll();
}
