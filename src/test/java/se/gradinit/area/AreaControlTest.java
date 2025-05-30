package se.gradinit.area;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes= HunterSpringBootApplication.class)
@WithMockUser(roles = "ADMIN")
public class AreaControlTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAreas() throws Exception {
        mockMvc.perform(get("/area"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
    /*
    @Test
    public void testGetHuntersByArea() throws Exception {
        mockMvc.perform(get("/area/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

     */

}
