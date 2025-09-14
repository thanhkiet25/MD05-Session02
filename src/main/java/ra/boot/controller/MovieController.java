package ra.boot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.boot.dto.MovieDto;
import ra.boot.model.Movie;
import ra.boot.service.MovieService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public String findAll(Model model, @RequestParam(name="page", defaultValue = "0") int page
    , @RequestParam(name="size", defaultValue = "5") int size,
                          @RequestParam(name = "search", required = false) String search) {
Page<Movie> movies = movieService.findAll(PageRequest.of(page, size));
        List<Integer> pages = new ArrayList<>();
        for(int i = 0; i < movies.getTotalPages(); i++) {
            pages.add(i);
        }
        model.addAttribute("movies", movies.getContent());
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", pages);
        return "movieList";
    }

    @GetMapping("/addMovie")
    public String add(Model model) {
        model.addAttribute("movie", new MovieDto());
        return "addMovie";
    }

    @PostMapping("/addMovie")
    public String handleAddMovie(@Valid @ModelAttribute ("movie")MovieDto movieDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("movie", movieDto);
            return "addMovie";
        }
Movie movie = movieService.addMovie(movieDto);
        if (movie != null) {
            redirectAttributes.addFlashAttribute("message", " add movie success");
            return "redirect:/movies";
        }else{
           model.addAttribute("message", " add movie fail");
           model.addAttribute("movie", movieDto);
           return "addMovie";

        }
    }

    @GetMapping("update")
    public String update(Model model) {
        model.addAttribute("movie", new MovieDto());
        return "updateMovie";
    }

    @PostMapping("updata")
    public String handleUpdata(@Valid @ModelAttribute("movies")MovieDto movieDto,@PathVariable("id") Long id, BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("movie", movieDto);
            return "updateMovie";
        }
        Movie movie = movieService.updateMovie(movieDto,id);
        if (movie != null) {
            redirectAttributes.addFlashAttribute("message", " update movie success");
            return "redirect:/movies";
        }else {
            model.addAttribute("message", " update movie fail");
            model.addAttribute("movie", movieDto);
            return "updateMovie";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes, Model model) {
        boolean result = movieService.deleteMovie(id);
        if (result) {
            redirectAttributes.addFlashAttribute("message", " delete movie success");
            return "redirect:/movies";
        }else{
           redirectAttributes.addFlashAttribute("message", " delete movie fail");
           return "redirect:/movies";

        }
    }
}
