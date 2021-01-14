package edu.school21.cinema.controllers;

import edu.school21.cinema.models.Hall;
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

    @GetMapping
    public String init(@ModelAttribute("model") ModelMap model) {
        List<Hall> list = new ArrayList<>();
        list.add(createHall(1, 100));
        list.add(createHall(2, 120));
        list.add(createHall(3, 90));
        list.add(createHall(4, 200));
        list.add(createHall(5, 300));
        list.add(createHall(6, 99));
        model.addAttribute("superList", list);
        return "asd";
    }

    private Hall createHall(int i1, int i2) {
        Hall result = new Hall();
        result.setNumber(i1);
        result.setSeatsCount(i2);
        return result;
    }
}
