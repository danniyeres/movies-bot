package org.example.storageservice.mapper;

import org.example.storageservice.dto.MovieDTO;
import org.example.storageservice.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieDTO toDTO(Movie movie) {
        return MovieDTO.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .director(movie.getDirector())
                .year(movie.getYear())
                .plot(movie.getPlot())
                .poster(movie.getPoster())
                .imdbId(movie.getImdbId())
                .imdbRating(movie.getImdbRating())
                .fileId(movie.getFileId())
                .build();
    }

    public Movie toEntity(MovieDTO movieDTO) {
        return Movie.builder()
                .id(movieDTO.getId())
                .title(movieDTO.getTitle())
                .genre(movieDTO.getGenre())
                .director(movieDTO.getDirector())
                .year(movieDTO.getYear())
                .plot(movieDTO.getPlot())
                .poster(movieDTO.getPoster())
                .imdbId(movieDTO.getImdbId())
                .imdbRating(movieDTO.getImdbRating())
                .fileId(movieDTO.getFileId())
                .build();
    }
}
