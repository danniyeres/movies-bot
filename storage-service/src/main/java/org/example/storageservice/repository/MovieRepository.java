package org.example.storageservice.repository;

import org.example.storageservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByTitle(String title);

    Movie findMovieByTitleIgnoreCase(String title);
    List<Movie> findByTitleContainingIgnoreCase(String title);

    List<Movie> findByYear(int year);
    List<Movie> findByGenre(String genre);
    List<Movie> findByDirector(String director);
}
