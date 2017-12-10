import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.ModelMap;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import pl.mzk.bielsko.controller.LineController;
import pl.mzk.bielsko.model.Line;
import pl.mzk.bielsko.service.LineService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LineControllerTest {

    @Mock
    LineService lineService;

    @InjectMocks
    LineController lineController;

    @Spy
    List<Line> lines = new ArrayList<Line>();

    @Spy
    Map<String, Object> model = new HashMap<>();

    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        lines = getLinesList();
    }

    @Test
    public void linesList(){
        //Map<String, Object> model = new HashMap<>();
        String linesList = lineController.linesList(model);
        assertEquals(linesList, "linesList");
        assertEquals(model.get("lineList"), lineService.getAllLines());
        assertEquals(model.size(), 1);
    }

    @Test
    public void edit(){
        //Map<String, Object> model = new HashMap<>();
        Line line = lines.get(0);
        when(lineService.findLine(anyInt())).thenReturn(line);
        assertEquals(model.get("editLine"), lineService.editLine(anyInt()));
        assertEquals(model.size(), 1);
    }

    public List<Line> getLinesList(){

        Line l1 = new Line();
        LocalDate date = LocalDate.now();

        l1.setLineId(1);
        l1.setLineNumber("50");
        l1.setRelation("Beskidzkie - Cyganski Las");
        l1.setDirection("Beskidzkie");
        l1.setValidFrom(date);
        l1.setValidTo(date);

        Line l2 = new Line();

        l1.setLineId(2);
        l1.setLineNumber("16");
        l1.setRelation("Zapora - Dworzec");
        l1.setDirection("Dworzec");
        l1.setValidFrom(date);
        l1.setValidTo(date);

        lines.add(l1);
        lines.add(l2);

        return lines;
    }
}
