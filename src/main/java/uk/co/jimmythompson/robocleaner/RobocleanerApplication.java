package uk.co.jimmythompson.robocleaner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

//@SpringBootApplication
public class RobocleanerApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(RobocleanerApplication.class, args);
//	}

	public static void main(String[] args) {
		Area area = new Area(new Coordinate(5, 5));
		Coordinate startingLocation = new Coordinate(1, 2);
		Cleaner cleaner = Cleaner.deploy(startingLocation);
		CleanerPilot pilot = new CleanerPilot(cleaner);
		List<Direction> route = RouteParser.parseRoute("NNESEESWNWW");
		pilot.navigate(route);


		System.out.println(
			String.format("Location: %s", cleaner.getLocation().toString())
		);
	}

}
