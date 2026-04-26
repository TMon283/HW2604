package com.example.btvn_2504.controller;

import com.example.btvn_2504.model.Todo;
import com.example.btvn_2504.service.ITodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class TodoController {

    private final ITodoService todoService;

    @GetMapping("/")
    public String listTodos(Model model) {
        model.addAttribute("todos", todoService.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "form";
    }

    @PostMapping("/add")
    public String saveOrUpdate(@Valid @ModelAttribute("todo") Todo todo,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        todoService.save(todo);
        redirectAttributes.addFlashAttribute("message", "Thao tác thành công!");
        return "redirect:/";
    }

    @GetMapping("/todos/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        return todoService.findById(id)
                .map(todo -> {
                    model.addAttribute("todo", todo);
                    return "form";
                })
                .orElse("redirect:/");
    }

    @GetMapping("/todos/delete/{id}")
    public String deleteTodo(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            todoService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Không tìm thấy bản ghi để xóa!");
        }
        return "redirect:/";
    }
}
