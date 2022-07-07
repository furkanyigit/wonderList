package wonderlist.wonderlist.repository;

import wonderlist.wonderlist.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
