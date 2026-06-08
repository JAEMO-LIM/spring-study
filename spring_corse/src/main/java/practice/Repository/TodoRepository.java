package practice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.Entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
