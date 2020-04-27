package journal.workout.repositories;

import journal.workout.models.UserWorkout;
import org.springframework.data.repository.CrudRepository;

public interface UserWorkoutsRepository extends CrudRepository<UserWorkout, Long> {

}
