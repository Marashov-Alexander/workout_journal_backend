package journal.workout.repositories;

import journal.workout.models.Workout;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkoutsRepository extends CrudRepository<Workout, Long> {
    List<Workout> findAll();
}
