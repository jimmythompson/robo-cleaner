package uk.co.jimmythompson.robocleaner.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uk.co.jimmythompson.robocleaner.Cleaner;
import uk.co.jimmythompson.robocleaner.CleanerPilot;
import uk.co.jimmythompson.robocleaner.SpillTracker;

@RestController
public class MainController {

    @RequestMapping(path = "/", method = RequestMethod.POST)
    SpillTrackingResult trackSpill(@RequestBody SpillTrackingRequest request) {
        SpillTrackingRequestParser mapper = new SpillTrackingRequestParser(request);
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
