package edu.school21.cinema.controllers;

import edu.school21.cinema.models.Hall;
import edu.school21.cinema.repositories.HallRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/panel/halls")
public class HallsController {
    @Resource
    private HallRepository repository;

    @GetMapping
    public String init(@ModelAttribute("model") ModelMap model) {
        List<Hall> list = new ArrayList<>(repository.findAll());
        model.addAttribute("hallsList", list);
        return "halls";
    }

    @PostMapping("/new")
    public void add(@RequestParam("number") String number,
                    @RequestParam("seatsCount") String seatsCount,
                    HttpServletResponse resp) throws IOException {
        try {
            Hall hall = new Hall();
            hall.setNumber(Integer.parseInt(number));
            hall.setSeatsCount(Integer.parseInt(seatsCount));
            repository.save(hall);
            resp.sendRedirect("/admin/panel/halls");
        } catch (NumberFormatException e) {
            resp.sendError(400, e.getMessage());
        }
    }
}
