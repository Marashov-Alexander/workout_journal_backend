package journal.workout.repositories;

import journal.workout.models.Parameter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParametersRepository extends CrudRepository<Parameter, Long> {
    List<Parameter> findAll();
}
