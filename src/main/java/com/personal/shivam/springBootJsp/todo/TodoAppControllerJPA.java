package com.personal.shivam.springBootJsp.todo;

import com.personal.shivam.springBootJsp.todo.model.Todo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoAppControllerJPA {
    TodoService todoService;
    TodoRepository todoRepository;

    public TodoAppControllerJPA(TodoService todoService, TodoRepository todoRepository) {
        super();
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    private static String getLoggedInUsername(ModelMap modelMap) {
        return (String) modelMap.get("name");
    }

    @RequestMapping("list-todos")
    public String listTodos(ModelMap modelMap) {
        String username = getLoggedInUsername(modelMap);
        List<Todo> todos = todoRepository.findByUserName(username);
        modelMap.put("todos", todos);
        return "todo/listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String addNewTodo(ModelMap modelMap) {
        String username = getLoggedInUsername(modelMap);
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        modelMap.put("todo", todo);
        return "todo/newTodo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String submitNewTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
        String username = getLoggedInUsername(modelMap);
        if (result.hasErrors()) {
            return "todo/newTodo";
        }
        todo.setUserName(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id, ModelMap modelMap) {
        String username = getLoggedInUsername(modelMap);
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap modelMap) {
        String username = getLoggedInUsername(modelMap);
        Todo todo = todoRepository.findById(id).get();
        modelMap.put("todo", todo);
        return "todo/newTodo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
        String username = getLoggedInUsername(modelMap);
        todo.setUserName(username);
        if (result.hasErrors()) {
            return "todo/newTodo";
        }
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

}
