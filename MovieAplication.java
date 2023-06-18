import org.fasttrackit.countries.homeworkcurs20.service.movie.MovieService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class MovieApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MovieApplication.class, args);

        MovieService movieService = context.getBean(MovieService.class);

        // Pre-populate the database with sample data
        // ...

        // Example usage: retrieve all movies
        List<Movie> movies = movieService.getAllMovies();
        System.out.println("All movies:");
        for (Movie movie : movies) {
            System.out.println(movie.getId() + ": " + movie.getName() + " (" + movie.getYear() + ")");
        }
    }
}

