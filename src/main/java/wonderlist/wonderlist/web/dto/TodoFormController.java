package wonderlist.wonderlist.web.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wonderlist.wonderlist.model.Todo;
import wonderlist.wonderlist.repository.TodoRepository;

@Controller
public class TodoFormController {

    // private final Logger logger = LoggerFactory.get(TodoFormController.class);

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/create-todo")
    public String showCreateForm(Todo todo) {
        return "add-todo";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Todo todo = todoRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Todo id: " + id + " not found"));

        model.addAttribute("todo", todo);
        return "update-todo";
    }
}
