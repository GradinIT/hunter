package se.gradinit.hunter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class HunterControlTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetHunters() throws Exception {
        mockMvc.perform(get("/hunters"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreateHunter() throws Exception {
        String hunterJson = "{\"name\":\"John Doe\",\"email\":\"john.doe@example.com\",\"phone\":\"1234567890\"}";
        mockMvc.perform(post("/hunter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(hunterJson))
                .andExpect(status().isOk());
    }

}
