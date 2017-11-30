import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import pl.mzk.bielsko.controller.LineController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class LineControllerTest {

    @Test
    public void testLinesView() throws Exception{
        LineController lineController = new LineController();
        MockMvc mockMvc = standaloneSetup(lineController).setSingleView(new InternalResourceView("/WEB-INF/views/lines.jsp")).build();
        mockMvc.perform(get("/lines")).andExpect(view().name("lines"));
    }
}
