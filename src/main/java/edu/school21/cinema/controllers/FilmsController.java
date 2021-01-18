package edu.school21.cinema.controllers;

import edu.school21.cinema.models.Film;
import edu.school21.cinema.repositories.FilmRepository;
import edu.school21.cinema.services.ImageFileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/panel/films")
public class FilmsController {
    @Resource
    private FilmRepository repository;
    @Resource
    private ImageFileService imageFileService;

    @GetMapping
    public String init(@ModelAttribute("model") ModelMap model) {
        List<Film> list = repository.findAll();
        list.forEach(f->{
            if (imageFileService.getImageFile(String.valueOf(f.getFilmId())) != null) {
                f.setImageLink("/admin/panel/films/get/" + f.getFilmId());
            } else {
                f.setImageLink("/none");
            }
        });
        model.addAttribute("filmList", list);
        return "films";
    }

    @GetMapping("/get/{id}")
    public void getImage(@PathVariable String id,
                         HttpServletResponse resp) throws IOException {
        try {
            Film film = repository.findForId(Integer.parseInt(id));
            File image = imageFileService.getImageFile(id);
            if (film == null || image == null) {
                resp.sendError(404);
            } else {
                resp.setContentType(film.getPosterMime());
                resp.setContentLength((int) image.length());
                try (FileInputStream in = new FileInputStream(image);
                     OutputStream out = resp.getOutputStream()) {
                    byte[] buf = new byte[1024];
                    int count;
                    while ((count = in.read(buf)) >= 0) {
                        out.write(buf, 0, count);
                    }
                }
            }
        } catch (IOException e) {
            resp.sendError(400, e.getMessage());
        }
    }

    @PostMapping("/save")
    public void savePoster(HttpServletResponse resp,
                           @RequestParam("uploadFile") MultipartFile file,
                           @RequestParam("name") String name,
                           @RequestParam("year") String year,
                           @RequestParam("minAge") String minAge,
                           @RequestParam("description") String description) throws IOException {
        try {
            Film newFilm = new Film();
            newFilm.setName(name);
            newFilm.setYear(Integer.parseInt(year));
            newFilm.setMinAge(Integer.parseInt(minAge));
            newFilm.setDescription(description);
            if (file != null){
                newFilm.setPosterMime(file.getContentType());
            }
            repository.save(newFilm);
            if (file != null && !file.isEmpty()) {
                imageFileService.saveImage(newFilm.getFilmId(), file.getBytes());
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            resp.sendError(400, e.getMessage());
            return;
        }
        resp.sendRedirect("/admin/panel/films");
    }
}
