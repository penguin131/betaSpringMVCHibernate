package edu.school21.cinema.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/panel/halls")
public class HallsController {
    @RequestMapping(method = RequestMethod.GET)
    public String getAllHalls() {
        return "all halls";
    }
}
