package journal.workout.repositories;

import journal.workout.models.MeasureUnit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MeasureUnitsRepository extends CrudRepository<MeasureUnit, Long> {
    List<MeasureUnit> findAll();
}
