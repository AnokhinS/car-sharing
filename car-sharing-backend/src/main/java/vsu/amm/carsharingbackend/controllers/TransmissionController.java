package vsu.amm.carsharingbackend.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vsu.amm.carsharingbackend.model.carinfo.Transmission;
import vsu.amm.carsharingbackend.services.TransmissionService;

import javax.validation.Valid;


@Controller
@RequestMapping("/admin/transmissions")
@PreAuthorize("hasAuthority('ADMIN')")
public class TransmissionController {
    private final TransmissionService service;

    public TransmissionController(TransmissionService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", service.getAllOrdered());
        return "transmissions/list";
    }

    @GetMapping(value = "/new")
    public String addType(Model model) {
        model.addAttribute("object", new Transmission());
        return "transmissions/new";
    }


    @PostMapping
    public String addType(@Valid @ModelAttribute("object") Transmission object, BindingResult br, Model model) {
        if (br.hasErrors()) {
            return "transmissions/new";
        }
        try {
            String str = object.getName();  //делаем первую букву заглавной
            String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
            object.setName(cap);
            service.create(object);
        } catch (Exception e) {
            br.rejectValue("name", "error.object", e.getMessage());
            return "transmissions/new";
        }
        model.addAttribute("success", "Тип '" + object.getName() + "' успешно добавлен");
        return "redirect:/admin/transmissions";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("object", service.get(id));
        return "transmissions/edit";
    }

    @PutMapping
    public String edit(@Valid @ModelAttribute("object") Transmission object, BindingResult br) {
        if (br.hasErrors()) {
            return "transmissions/edit";
        }
        try {
            service.update(object);
        } catch (Exception e) {
            br.rejectValue("name", "error.name", e.getMessage());
            return "transmissions/edit";
        }
        return "redirect:/admin/transmissions";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        model.addAttribute("object", service.get(id));
        return "transmissions/delete";
    }

    @DeleteMapping
    public String delete(Transmission object) {
        service.delete(object);
        return "redirect:/admin/transmissions";
    }

}
