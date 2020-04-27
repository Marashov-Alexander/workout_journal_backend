package journal.workout.repositories;

import journal.workout.models.Workout;
import org.springframework.data.repository.CrudRepository;

public interface WorkoutsRepository extends CrudRepository<Workout, Long> {

}
