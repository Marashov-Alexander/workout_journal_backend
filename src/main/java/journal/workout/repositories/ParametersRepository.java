package journal.workout.repositories;

import journal.workout.models.Parameter;
import org.springframework.data.repository.CrudRepository;

public interface ParametersRepository extends CrudRepository<Parameter, Long> {

}
