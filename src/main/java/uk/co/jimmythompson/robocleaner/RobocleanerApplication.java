package uk.co.jimmythompson.robocleaner;

import uk.co.jimmythompson.robocleaner.geometry.Area;
import uk.co.jimmythompson.robocleaner.geometry.Coordinate;

import java.util.List;

import static java.util.Arrays.asList;

//@SpringBootApplication
public class RobocleanerApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(RobocleanerApplication.class, args);
//	}

	public static void main(String[] args) {
		Area area = new Area(new Coordinate(5, 5));
		Coordinate startingLocation = new Coordinate(1, 2);
		Cleaner cleaner = Cleaner.deploy(startingLocation);

		OilPatch firstPatch = new OilPatch(new Coordinate(1, 0));
		OilPatch secondPatch = new OilPatch(new Coordinate(2, 2));
		OilPatch thirdPatch = new OilPatch(new Coordinate(2, 3));

		SpillTracker spillTracker = new SpillTracker(asList(firstPatch, secondPatch, thirdPatch));

		spillTracker.follow(cleaner);

		CleanerPilot pilot = new CleanerPilot(area, cleaner);
		List<Direction> route = RouteParser.parseRoute("NNESEESWNWW");
		pilot.navigate(route);

		System.out.println(
			String.format("Location: %s", cleaner.getLocation().toString())
		);

		System.out.println(
			String.format("Patches Cleaned: %s", spillTracker.getStatus().getCleanedPatches())
		);
	}

}
