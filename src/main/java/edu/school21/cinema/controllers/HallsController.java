package edu.school21.cinema.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/panel/halls")
public class HallsController {
    @GetMapping
    @ResponseBody
    public String getAllHalls() {
        return "all halls";
    }
}
