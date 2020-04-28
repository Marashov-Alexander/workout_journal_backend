package journal.workout.repositories;

import journal.workout.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    List<User> findAll();
}
