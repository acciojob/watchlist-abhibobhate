package com.driver;

import java.util.List;


public class MovieService {
    MovieRepository mr = new MovieRepository();

    public void addMovie(Movie movie) {
        mr.addMovie(movie);
    }

    public void addDirector(Director director) {
        mr.addDirector(director);
    }

    public void addMovieDirectorPair(String movie, String director) {
        mr.addMovieDirectorPair(movie, director);
    }

    public Movie getMovieByName(String name) {
        return mr.getMovieByName(name);
    }

    public Director getDirectorByName(String name) {
        return mr.getDirectorByName(name);
    }

    public List<String> getMoviesByDirectorName(String director) {
        return mr.getMoviesByDirectorName(director);
    }

    public List<String> findAllMovies() {
        return mr.findAllMovies();
    }

    public void deleteDirectorByName(String director) {
        mr.deleteDirectorByName(director);
    }

    public void deleteAllDirectors() {
        mr.deleteAllDirectors();
    }
}