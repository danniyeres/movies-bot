package org.example.storageservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class MovieDTO {
    private Long id;

//    @JsonProperty("Title")
    private String title;

//    @JsonProperty("Genre")
    private String genre;

//    @JsonProperty("Director")
    private String director;

//    @JsonProperty("Year")
    private int year;

//    @JsonProperty("Plot")
    private String plot;

//    @JsonProperty("Poster")
    private String poster;

//    @JsonProperty("imdbID")
    private String imdbId;

//    @JsonProperty("imdbRating")
    private String imdbRating;

//    @JsonProperty("fileId")
    private String fileId;
}

