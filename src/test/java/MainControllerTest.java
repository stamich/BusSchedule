import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import pl.mzk.bielsko.controller.MainController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class MainControllerTest {

    @Test
    public void testMainView() throws Exception{
        MainController mainController = new MainController();
        MockMvc mockMvc = standaloneSetup(mainController).build(); // przekazanie instancji mainController do metody MockMvcBuilders.standaloneSetup
        mockMvc.perform(get("/")).andExpect(view().name("main")); //wywolanie zadania get do zasobu "/" oraz weryfikacja nazwy zwroconego widoku
        //assertEquals("main", mainController.mainView());
    }
}
