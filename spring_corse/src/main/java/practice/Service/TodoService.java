package practice.Service;

import org.springframework.transaction.annotation.Transactional;
import practice.Entity.Todo;
import practice.Repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public void delete(Long Id) {
        todoRepository.deleteById(Id);
    }

    @Transactional
    public Todo update(Long id, Todo requestTodo) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 할 일이 없습니다."));

        todo.changeContent(requestTodo.getContent(), requestTodo.isDone());

        return todo;
    }

}
