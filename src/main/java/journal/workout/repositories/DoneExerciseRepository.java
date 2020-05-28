package journal.workout.repositories;

import journal.workout.models.Parameter;
import journal.workout.models.User;
import journal.workout.models.UserWorkout;
import journal.workout.models.DoneExercise;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DoneExerciseRepository extends CrudRepository<DoneExercise, Long> {
    List<DoneExercise> findAll();
    List<DoneExercise> findAllByUser(User user);
}
