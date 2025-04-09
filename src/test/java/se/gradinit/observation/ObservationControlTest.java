package se.gradinit.observation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import se.gradinit.HunterSpringBootApplication;
import se.gradinit.observation.model.Observation;
import se.gradinit.observation.service.ObservationService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes= HunterSpringBootApplication.class)
public class ObservationControlTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObservationService observationService;

    @Test
    public void testGetObservations() throws Exception {
        mockMvc.perform(get("/observations"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    @Test
    public void testCreateObservation() throws Exception {
        String observationJson = """
                {
                  "blindId": 1,
                  "species": "Älg",
                  "count": 3
                }
                """;
        mockMvc.perform(post("/observation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(observationJson))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testDeleteObservation() throws Exception {
        Observation observation = Observation.builder()
                .blindId(1L)
                .animal("Älg")
                .count(4L)
                .build();
        observation = observationService.createObservation(observation);

        mockMvc.perform(delete("/observation/" + observation.getId()))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/observation/" + observation.getId()))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateObservation() throws Exception {
        Observation observation = Observation.builder()
                .blindId(1L)
                .animal("Älg")
                .count(4L)
                .build();
        observation = observationService.createObservation(observation);

        mockMvc.perform(put("/observation/" + observation.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                 {
                                   "count": 2
                                 }
                                 """))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.count").value(2L));
    }
}
