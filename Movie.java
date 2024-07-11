import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// Movie class definition
class Movie {
    private String title;
    private String director;
    private int releaseYear;
    private double rating;
    private int ratingCount;

    public Movie(String title, String director, int releaseYear) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.rating = 0.0;
        this.ratingCount = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return ratingCount == 0 ? 0 : rating / ratingCount;
    }

    public void addRating(double newRating) {
        rating += newRating;
        ratingCount++;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Director: " + director + ", Release Year: " + releaseYear + ", Rating: " + getRating();
    }
}

// MovieRecommendationSystem class definition
class MovieRecommendationSystem {
    private List<Movie> movieList;

    public MovieRecommendationSystem() {
        movieList = new ArrayList<>();
    }

    public void addMovie(String title, String director, int releaseYear) {
        movieList.add(new Movie(title, director, releaseYear));
        System.out.println("Movie added successfully!");
    }

    public void rateMovie(String title, double rating) {
        Movie movie = searchMovie(title);
        if (movie != null) {
            movie.addRating(rating);
            System.out.println("Rating added successfully!");
        } else {
            System.out.println("Movie not found!");
        }
    }

    public Movie searchMovie(String title) {
        for (Movie movie : movieList) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }

    public void displayMovies() {
        if (movieList.isEmpty()) {
            System.out.println("No movies to display!");
        } else {
            for (Movie movie : movieList) {
                System.out.println(movie);
            }
        }
    }

    public void displayTopRatedMovies() {
        if (movieList.isEmpty()) {
            System.out.println("No movies to display!");
        } else {
            List<Movie> sortedMovies = new ArrayList<>(movieList);
            sortedMovies.sort(Comparator.comparingDouble(Movie::getRating).reversed());
            for (int i = 0; i < Math.min(5, sortedMovies.size()); i++) {
                System.out.println(sortedMovies.get(i));
            }
        }
    }
}


