package org.example.storageservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.storageservice.dto.MovieDTO;
import org.example.storageservice.mapper.MovieMapper;
import org.example.storageservice.model.Movie;
import org.example.storageservice.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public void addMovie(MovieDTO movieDTO) {
        var movie = movieMapper.toEntity(movieDTO);
        log.info("Adding movie: {}", movie.toString());
        movieRepository.save(movie);
    }

    public MovieDTO getMovieById(Long id) {
        var movie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
        return movieMapper.toDTO(movie);
    }

    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }

    public MovieDTO getMovieByTitle(String title) {
        var movie = movieRepository.findMovieByTitleIgnoreCase(title);
        if (movie == null)
            throw new RuntimeException("Movie not found");
        log.info("Found movie: {}", movie.getTitle());
        return movieMapper.toDTO(movie);
    }

    public List<Movie> getMoviesByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        log.info("Found {} movies", movies.size());
        return movies;
    }

    public MovieDTO randomMovie() {
        List<Movie> movies = movieRepository.findAll();
        if (movies.isEmpty())
            throw new RuntimeException("No movies found");
        int randomIndex = (int) (Math.random() * movies.size());
        return movieMapper.toDTO(movies.get(randomIndex));
    }

}
