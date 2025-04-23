package se.gradinit.hunter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import se.gradinit.HunterSpringBootApplication;
import se.gradinit.hunter.model.Hunter;
import se.gradinit.hunter.service.HunterService;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes= HunterSpringBootApplication.class)
public class HunterControlTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HunterService hunterService;

    @Test
    public void testGetHunters() throws Exception {
        mockMvc.perform(get("/hunters"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreateHunter() throws Exception {
        String hunterJson = """
                {
                  "name": "John Doe",
                  "email": "john.doe@example.com",
                  "phone": "1234567890"
                }
                """;
        mockMvc.perform(post("/hunter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(hunterJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteHunter() throws Exception {
        Hunter hunter = Hunter.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .phone("1234567890")
                .build();
        hunter = hunterService.createHunter(hunter);
        mockMvc.perform(delete("/hunter/" + hunter.getId()))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/hunter/" + hunter.getId()))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateHunter() throws Exception {
        Hunter hunter = Hunter.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .phone("1234567890")
                .areaId(1L)
                .build();
        hunter = hunterService.createHunter(hunter);
        mockMvc.perform(put("/hunter/" + hunter.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                 {
                                   "areaId": 4
                                 }
                                 """))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.areaId").value(4L));
    }

    @Test
    public void testGetHuntLeaders() {
        Hunter hunter = Hunter.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .phone("1234567890")
                .areaId(1L)
                .leader(true)
                .build();
        hunter = hunterService.createHunter(hunter);
        var leaders = hunterService.findHuntLeaders();
        Long hunterId = hunter.getId();
        assertTrue(leaders.stream().anyMatch(h -> h.getId().equals(hunterId)));
    }
}
