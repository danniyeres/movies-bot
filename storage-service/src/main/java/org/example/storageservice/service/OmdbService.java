package org.example.storageservice.service;

import lombok.RequiredArgsConstructor;
import org.example.storageservice.dto.MovieDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@RequiredArgsConstructor
@Service
public class OmdbService {
    private static final String apiKey = "a6ea3e8";
    private static final String OMDB_URL = "http://www.omdbapi.com/?apikey=" + apiKey + "&t=";
    private final MovieService movieService;
//
//    public MovieDTO fetchAndSave(String title) {
//        String url = OMDB_URL + title.replace(" ", "+");
//
//        RestTemplate restTemplate = new RestTemplate();
//        MovieDTO movie = restTemplate.getForObject(url, MovieDTO.class);
//        movieService.addMovie(movie);
//        return movie;
//    }
}
