package uk.co.jimmythompson.robocleaner;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import uk.co.jimmythompson.robocleaner.geometry.Coordinate;
import uk.co.jimmythompson.robocleaner.web.SpillTrackingRequest;
import uk.co.jimmythompson.robocleaner.web.SpillTrackingResult;

import javax.ws.rs.core.MediaType;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RobocleanerApplicationTests {

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturnSpillStatus() throws Exception {
        SpillTrackingRequest request = new SpillTrackingRequest();

        request.setAreaSize(asList(5, 5));
        request.setStartingPosition(asList(1, 2));
        request.setOilPatches(asList(
                asList(1, 0),
                asList(2, 2),
                asList(2, 3)
        ));
        request.setNavigationInstructions("NNESEESWNWW");

        SpillTrackingResult result = new SpillTrackingResult(
                new Coordinate(1, 3),
                1
        );

        mvc.perform(
                MockMvcRequestBuilders
                        .post("/")
                        .content(asJsonString(request))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(result)));
    }

}
