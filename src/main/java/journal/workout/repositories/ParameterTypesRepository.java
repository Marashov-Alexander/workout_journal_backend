package journal.workout.repositories;

import journal.workout.models.ParameterType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParameterTypesRepository extends CrudRepository<ParameterType, Long> {
    List<ParameterType> findAll();
}
