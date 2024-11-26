package sv.library.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import javafx.application.Application;
import sv.library.LibraryFrontend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sv.library.backend.entity.User;
import sv.library.backend.repository.UserRepository;


@SpringBootApplication
@EnableJpaRepositories("sv.library.backend.repository")  // Specify repository package
public class LibraryApplication {
	public static void main(String[] args) {
		// Start the backend
		SpringApplication.run(LibraryApplication.class, args);

		// Start the frontend (JavaFX)
		Application.launch(LibraryFrontend.class, args);
	}
}



