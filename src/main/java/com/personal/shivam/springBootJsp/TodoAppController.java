package com.personal.shivam.springBootJsp;

import com.personal.shivam.springBootJsp.todo.TodoService;
import com.personal.shivam.springBootJsp.todo.model.Todo;
import jakarta.validation.Valid;
import org.springframework.cglib.core.Local;
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
public class TodoAppController {
    TodoService todoService;

    public TodoAppController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listTodos(ModelMap modelMap) {
        String username = (String) modelMap.get("name");
        List<Todo> todos = todoService.findByUserName(username);
        modelMap.put("todos", todos);
        return "todo/listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String addNewTodo(ModelMap modelMap) {
        String username = (String) modelMap.get("name");
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        modelMap.put("todo", todo);
        return "todo/newTodo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String submitNewTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
        String username = (String) modelMap.get("name");
        if (result.hasErrors()) {
            return "todo/newTodo";
        }
        todoService.addNewTodo(username, todo.getDescription(), todo.getCompletedBy(), false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id, ModelMap modelMap) {
        String username = (String) modelMap.get("name");
        todoService.deleteTodo(username, id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap modelMap) {
        String username = (String) modelMap.get("name");
        Todo todo = todoService.getTodo(username, id);
        modelMap.put("todo", todo);
        return "todo/newTodo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
        String username = (String) modelMap.get("name");
        todo.setUserName(username);
        if (result.hasErrors()) {
            return "todo/newTodo";
        }
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

}
