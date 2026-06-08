package practice.Controller;

import org.springframework.web.bind.annotation.*;
import practice.Entity.Todo;
import practice.Service.TodoService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> getTodoAll() { // 2. 반환 타입을 객체 리스트로 변경 (Model 제거)
        return todoService.findAll();
    }

    @PostMapping("/save")
    public Todo todoSave(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.update(id, todo);
    }
}
