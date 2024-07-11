import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieRecommendationSystem mrs = new MovieRecommendationSystem();

        while (true) {
            System.out.println("\nWelcome to the Movie Recommendation System!");
            System.out.println("Please select an option:");
            System.out.println("1. Add a Movie");
            System.out.println("2. Rate a Movie");
            System.out.println("3. Search for a Movie");
            System.out.println("4. Display All Movies");
            System.out.println("5. Display Top Rated Movies");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter movie title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter director: ");
                    String director = scanner.nextLine();
                    System.out.print("Enter release year: ");
                    int releaseYear = scanner.nextInt();
                    mrs.addMovie(title, director, releaseYear);
                    break;
                case 2:
                    System.out.print("Enter movie title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter your rating (0-5): ");
                    double rating = scanner.nextDouble();
                    mrs.rateMovie(title, rating);
                    break;
                case 3:
                    System.out.print("Enter movie title: ");
                    title = scanner.nextLine();
                    Movie movie = mrs.searchMovie(title);
                    if (movie != null) {
                        System.out.println("Movie found:");
                        System.out.println(movie);
                    } else {
                        System.out.println("Movie not found!");
                    }
                    break;
                case 4:
                    mrs.displayMovies();
                    break;
                case 5:
                    mrs.displayTopRatedMovies();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}



