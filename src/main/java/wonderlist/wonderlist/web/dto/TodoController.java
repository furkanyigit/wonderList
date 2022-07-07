package wonderlist.wonderlist.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import wonderlist.wonderlist.model.Todo;
import wonderlist.wonderlist.repository.TodoRepository;

import javax.validation.Valid;
import java.time.Instant;
import java.time.ZoneId;

@Controller
public class TodoController {

    private final Logger logger = LoggerFactory.getLogger(TodoController.class);
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/")
    public ModelAndView index() {
        logger.info("request to GET index");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todos", todoRepository.findAll());
        modelAndView.addObject("today", Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek());
        return modelAndView;
    }

    @PostMapping("/todo")
    public String createTodo (@Valid Todo todo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-todo";
        }

        todo.setCreatedDate(Instant.now());
        todo.setModifiedDate(Instant.now());
        todoRepository.save(todo);
        return "redirect:/";
    }

    @PostMapping("/todo/{id}")
    public String updateTodo(@PathVariable("id") long id, @Valid Todo todo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            todo.setId(id);
            return "update-todo";
        }

        todo.setModifiedDate(Instant.now());
        todoRepository.save(todo);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") long id, Model model) {
        Todo todo = todoRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Todo id: " + id + " not found"));

        todoRepository.delete(todo);
        return "redirect:/";
    }
}

