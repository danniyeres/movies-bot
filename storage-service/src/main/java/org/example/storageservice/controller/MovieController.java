package org.example.storageservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.storageservice.dto.MovieDTO;
import org.example.storageservice.model.Movie;
import org.example.storageservice.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
//    private final OmdbService omdbService;

    @PostMapping("/add")
    public void addMovie(@RequestBody MovieDTO movie) {
        movieService.addMovie(movie);
    }

    @GetMapping("/getById/{id}")
    public MovieDTO getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovieById(id);
    }

    @GetMapping("/get")
    public MovieDTO getMovieByTitle(@RequestParam String title) {
        return movieService.getMovieByTitle(title);
    }

    @GetMapping("/get/list")
    public List<Movie> getMoviesByTitle(@RequestParam String title) {
        return movieService.getMoviesByTitle(title);
    }

    @GetMapping("/getAll")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/random")
    public MovieDTO randomMovie() {
        return movieService.randomMovie();
    }

//    @GetMapping("/fetchAndSave/{title}")
//    public MovieDTO fetchAndSave(@PathVariable String title) {
//        return omdbService.fetchAndSave(title);
//    }
}
