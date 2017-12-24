package or.ashish.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseAPIApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
			 * Create the server to run the spring application
			 * Takes 2 arg 1st is the class name and 2nd is the argument passed to the main method
		 */
		SpringApplication.run(CourseAPIApp.class, args);

	}

}
