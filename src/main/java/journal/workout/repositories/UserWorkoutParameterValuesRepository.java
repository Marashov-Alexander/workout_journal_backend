package journal.workout.repositories;

import journal.workout.models.Parameter;
import journal.workout.models.UserWorkout;
import journal.workout.models.UserWorkoutParameterValue;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserWorkoutParameterValuesRepository extends CrudRepository<UserWorkoutParameterValue, Long> {
    List<UserWorkoutParameterValue> findAll();

    List<UserWorkoutParameterValue> findAllByUserWorkout(UserWorkout userWorkout);

    Long findValueByUserWorkoutAndParameter(UserWorkout userWorkout, Parameter parameter);
}
