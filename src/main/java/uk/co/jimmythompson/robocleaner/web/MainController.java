package uk.co.jimmythompson.robocleaner.web;

import org.springframework.web.bind.annotation.*;
import uk.co.jimmythompson.robocleaner.Cleaner;
import uk.co.jimmythompson.robocleaner.CleanerPilot;
import uk.co.jimmythompson.robocleaner.SpillTracker;

import static java.util.Arrays.asList;

@RestController
public class MainController {

    @RequestMapping(path = "/", method = RequestMethod.POST)
    SpillTrackingResult trackSpill(@RequestBody SpillTrackingRequest request) {
        SpillTrackingRequestMapper mapper = new SpillTrackingRequestMapper(request);
        Cleaner cleaner = Cleaner.deploy(mapper.getStartingPosition());
        SpillTracker spillTracker = new SpillTracker(mapper.getOilPatches());

        spillTracker.follow(cleaner);

        CleanerPilot pilot = new CleanerPilot(mapper.getArea(), cleaner);

        pilot.navigate(mapper.getRoute());

        return new SpillTrackingResult(
                cleaner.getLocation(),
                spillTracker.getStatus().getCleanedPatches()
        );
    }
}
