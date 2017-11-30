import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import pl.mzk.bielsko.controller.StopController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class StopControllerTest {

    @Test
    public void testStopsView() throws Exception {
        StopController stopController = new StopController();
        MockMvc mockMvc = standaloneSetup(stopController).setSingleView(new InternalResourceView("/WEB-INF/views/stops.jsp")).build();
        mockMvc.perform(get("/stops")).andExpect(view().name("stops"));
    }
}
