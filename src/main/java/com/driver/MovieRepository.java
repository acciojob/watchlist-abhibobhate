package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MovieRepository {
    private Map<String, Movie> moviesData = new HashMap<>();
    private Map<String, Director> directorsData = new HashMap<>();
    private Map<String, List<String>> moviesWithDirectorMap = new HashMap<>();

    public void addMovie(Movie movie) {
        moviesData.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        directorsData.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movie, String director) {
        List<String> temp = moviesWithDirectorMap.getOrDefault(director, new ArrayList<>());
        temp.add(movie);
        moviesWithDirectorMap.put(director, temp);
    }

    public Movie getMovieByName(String name) {
        return moviesData.getOrDefault(name, new Movie());
    }

    public Director getDirectorByName(String name) {
        return directorsData.getOrDefault(name, new Director());
    }

    public List<String> getMoviesByDirectorName(String director) {
        return moviesWithDirectorMap.getOrDefault(director, new ArrayList<>());
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(moviesData.keySet());
    }

    public void deleteDirectorByName(String director) {
        for (String movie : moviesWithDirectorMap.getOrDefault(director, new ArrayList<>())) {
            moviesData.remove(movie);
        }
        moviesWithDirectorMap.remove(director);
        directorsData.remove(director);
    }

    public void deleteAllDirectors() {
        Set<String> directors = directorsData.keySet();
        for (String director : directors) {
            deleteDirectorByName(director);
        }
        directors.clear();;
        moviesWithDirectorMap.clear();
    }
}