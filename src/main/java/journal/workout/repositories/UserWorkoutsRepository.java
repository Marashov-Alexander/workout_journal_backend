package journal.workout.repositories;

import journal.workout.models.UserWorkout;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserWorkoutsRepository extends CrudRepository<UserWorkout, Long> {
    List<UserWorkout> findAll();
}
