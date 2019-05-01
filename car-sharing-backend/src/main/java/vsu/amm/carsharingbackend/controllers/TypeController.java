package vsu.amm.carsharingbackend.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vsu.amm.carsharingbackend.model.carinfo.Type;
import vsu.amm.carsharingbackend.services.TypeService;

import javax.validation.Valid;


@Controller
@RequestMapping("/admin/types")
@PreAuthorize("hasAuthority('ADMIN')")

public class TypeController {
    private final TypeService service;

    public TypeController(TypeService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", service.getAllOrdered());
        return "types/list";
    }

    @GetMapping(value = "/new")
    public String addType(Model model) {
        model.addAttribute("object", new Type());
        return "types/new";
    }


    @PostMapping
    public String addType(@Valid @ModelAttribute("object") Type object, BindingResult br, Model model) {
        if (br.hasErrors()) {
            return "types/new";
        }
        try {
            service.create(object);
        } catch (Exception e) {
            br.rejectValue("name", "error.name", e.getMessage());
            return "types/new";
        }
        model.addAttribute("success", "Тип '" + object.getName() + "' успешно добавлен");
        return "redirect:/admin/types";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("object", service.get(id));
        return "types/edit";
    }

    @PutMapping
    public String edit(@Valid @ModelAttribute("object") Type object, BindingResult br) {
        if (br.hasErrors()) {
            return "types/edit";
        }
        try {
            service.update(object);
        } catch (Exception e) {
            br.rejectValue("name", "error.name", e.getMessage());
            return "types/edit";
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        model.addAttribute("object", service.get(id));
        return "types/delete";
    }

    @DeleteMapping
    public String delete(Type object) {
        service.delete(object);
        return "redirect:/admin/types";
    }

}
