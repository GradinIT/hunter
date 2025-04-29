package se.gradinit.blind;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import se.gradinit.HunterSpringBootApplication;
import se.gradinit.blind.model.Blind;
import se.gradinit.blind.service.BlindService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes= HunterSpringBootApplication.class)
@WithMockUser(roles = "ADMIN")
public class BlindControlTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BlindService blindService;

    @Test
    public void testGetBlinds() throws Exception {
        mockMvc.perform(get("/blinds"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    @Test
    public void testCreateBlind() throws Exception {
        String hunterJson = """
                            {
                              "description": "Gammelkullen",
                              "type": "Torn"
                            }
                            """;
        mockMvc.perform(post("/blind")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(hunterJson))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testDeleteBlind() throws Exception {
        Blind blind = Blind.builder()
                .build();
        blind = blindService.createBlind(blind);
        mockMvc.perform(delete("/blind/" + blind.getId()))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/blind/" + blind.getId()))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateBlind() throws Exception {
        Blind blind = Blind.builder()
                .description("Gammelkullen")
                .areaId(1L)
                .type("Torn")
                .build();
        blind = blindService.createBlind(blind);
        mockMvc.perform(put("/blind/" + blind.getId())
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

}
