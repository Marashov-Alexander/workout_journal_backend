package journal.workout.repositories;

import journal.workout.models.DoneExercise;
import journal.workout.models.ParameterResult;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParameterResultsRepository extends CrudRepository<ParameterResult, Long> {
    List<ParameterResult> findAll();
    List<ParameterResult> findAllByDoneExercise(DoneExercise doneExercise);
}
