package com.personal.shivam.springBootJsp.todo;

import com.personal.shivam.springBootJsp.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    public static List<Todo> todoList = new ArrayList<>();
    private static int count = 0;

    public List<Todo> findByUserName(String username) {
        return todoList.stream().filter(todo -> todo.getUserName().equals(username)).toList();
    }

    public void addNewTodo(String userName, String description, LocalDate completedBy, boolean done) {
        todoList.add(new Todo(++count, userName, description, completedBy, done));
    }

    public void deleteTodo(String userName, int id) {
        todoList.removeIf(todo -> todo.getUserName().equals(userName) && todo.getId() == id);
    }

    public Todo getTodo(String userName, int id) {
        return todoList.stream().filter(todo -> todo.getUserName().equals(userName) && todo.getId() == id).findFirst().get();
    }

    public void updateTodo(Todo todo) {
        this.deleteTodo(todo.getUserName(), todo.getId());
        todoList.add(todo);
    }
}
