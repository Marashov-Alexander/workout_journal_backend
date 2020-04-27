package journal.workout.repositories;

import journal.workout.models.UserWorkoutParameterValue;
import org.springframework.data.repository.CrudRepository;

public interface UserWorkoutParameterValuesRepository extends CrudRepository<UserWorkoutParameterValue, Long> {

}
