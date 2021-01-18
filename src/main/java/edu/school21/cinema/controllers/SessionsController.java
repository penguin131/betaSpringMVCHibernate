package edu.school21.cinema.controllers;

import edu.school21.cinema.models.Film;
import edu.school21.cinema.models.Hall;
import edu.school21.cinema.models.Session;
import edu.school21.cinema.repositories.FilmRepository;
import edu.school21.cinema.repositories.HallRepository;
import edu.school21.cinema.repositories.SessionRepository;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Controller
@RequestMapping("/admin/panel/sessions")
public class SessionsController {
    @Resource
    private SessionRepository repository;
    @Resource
    private HallRepository hallRepository;
    @Resource
    private FilmRepository filmRepository;
    private List<Hall> halls;
    private List<Film> films;

    @GetMapping
    public String init(@ModelAttribute("model") ModelMap model) {
        List<Session> list = repository.findAll();
        halls = hallRepository.findAll();
        films = filmRepository.findAll();
        model.addAttribute("sessionsList", list);
        model.addAttribute("hallsList", hallRepository.findAll());
        model.addAttribute("filmsList", filmRepository.findAll());
        return "sessions";
    }

    @PostMapping("/new")
    public void add(@RequestParam("sessionDate") Date sessionDate,
                    @RequestParam("sessionTime") String sessionTime,
                    @RequestParam("hall") int hallId,
                    @RequestParam("film") int filmId,
                    HttpServletResponse resp) throws IOException {
        try {
            Session session = new Session();
            String[] time = sessionTime.split(":");
            long finalTime = sessionDate.getTime() +
                    Integer.parseInt(time[0]) * 60 * 60 * 1000 +
                    Integer.parseInt(time[1]) * 60 * 1000;
            session.setTime(finalTime);
            session.setHall(halls.stream().filter(hall -> hall.getHallId() == hallId).findFirst().orElse(null));
            session.setFilm(films.stream().filter(film -> film.getFilmId() == filmId).findFirst().orElse(null));
            repository.save(session);
            resp.sendRedirect("/admin/panel/sessions");
        } catch (NumberFormatException e) {
            resp.sendError(400, e.getMessage());
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        sdf.setLenient(true);
        sdf.setTimeZone(TimeZone.getTimeZone("CET"));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,true));
    }
}
