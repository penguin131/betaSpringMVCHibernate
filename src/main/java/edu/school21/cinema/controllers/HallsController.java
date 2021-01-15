package edu.school21.cinema.controllers;

import edu.school21.cinema.models.Hall;
import edu.school21.cinema.repositories.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/panel/halls")
public class HallsController {
    @Autowired
    private HallRepository repository;

    @GetMapping
    public String init(@ModelAttribute("model") ModelMap model) {
        List<Hall> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        model.addAttribute("superList", list);
        return "asd";
    }
}
