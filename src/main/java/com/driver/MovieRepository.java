package com.driver;

import java.util.*;

public class MovieRepository {
    private Map<String, Movie> movies = new HashMap<>();
    private Map<String, Director> directors = new HashMap<>();
    private Map<String, List<String>> moviesDirectorPair = new HashMap<>();

    public void addMovie(Movie movie) {
        movies.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        directors.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movie, String director) {
        moviesDirectorPair.getOrDefault(director,new ArrayList<>()).add(movie);
    }

    public Movie getMovieByName(String name) {
        return movies.getOrDefault(name, new Movie());
    }

    public Director getDirectorByName(String name) {
        return directors.getOrDefault(name, new Director());
    }

    public List<String> getMoviesByDirectorName(String director) {
        return moviesDirectorPair.getOrDefault(director, new ArrayList<>());
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(movies.keySet());
    }

    public void deleteDirectorByName(String director) {
        for (String movie : moviesDirectorPair.getOrDefault(director, new ArrayList<>())) {
            movies.remove(movie);
        }
        moviesDirectorPair.remove(director);
        directors.remove(director);
    }

    public void deleteAllDirectors() {
        Set<String> directors = this.directors.keySet();
        for (String director : directors) {
            deleteDirectorByName(director);
        }
        directors.clear();;
        moviesDirectorPair.clear();
    }
}