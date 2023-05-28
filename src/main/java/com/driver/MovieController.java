package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("movies")
public class MovieController {

    MovieService ms = new MovieService();

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        ms.addMovie(movie);
        return new ResponseEntity<>("New Movie " + movie.getName() + " Added Successfully", HttpStatus.ACCEPTED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        ms.addDirector(director);
        return new ResponseEntity<>("New Director " + director.getName() + " Added Successfully", HttpStatus.ACCEPTED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie, @RequestParam String director) {
        ms.addMovieDirectorPair(movie, director);
        return new ResponseEntity<>("New Director-Movie Added Successfully", HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name) {
        Movie movie = ms.getMovieByName(name);
        return new ResponseEntity<>(movie, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name) {
        Director director = ms.getDirectorByName(name);
        return new ResponseEntity<>(director, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director) {
        List<String> movies = ms.getMoviesByDirectorName(director);
        return new ResponseEntity<>(movies, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies() {
        List<String> allMovies = ms.findAllMovies();
        return new ResponseEntity<>(allMovies, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director) {
        ms.deleteDirectorByName(director);
        return new ResponseEntity<>(director + " removed successfully", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() {
        ms.deleteAllDirectors();
        return new ResponseEntity<>("All Directors data removed", HttpStatus.ACCEPTED);
    }
}