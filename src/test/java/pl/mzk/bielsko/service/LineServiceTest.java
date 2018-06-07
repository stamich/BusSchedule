package pl.mzk.bielsko.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import pl.mzk.bielsko.dao.LineDao;
import pl.mzk.bielsko.model.Line;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class LineServiceTest {

    @Mock
    private LineDao lineDao;

    @InjectMocks
    private LineServiceImpl lineService;

    @Spy
    List<Line> lines = new ArrayList<Line>();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        lines = getLinesList();
    }

    public List<Line> getLinesList(){

        LocalDate date = LocalDate.now();

        Line l1 = new Line();
        l1.setLineId(1);
        l1.setLineNumber("10");
        l1.setRelationFrom("Place A");
        l1.setRelationTo("Place B");
        l1.setValidFrom(date);
        l1.setValidTo(date);
        l1.setActive(true);
        l1.setComments("All ok.");

        Line l2 = new Line();
        l2.setLineId(2);
        l2.setLineNumber("20");
        l2.setRelationFrom("Place C");
        l2.setRelationTo("Place D");
        l2.setValidFrom(date);
        l2.setValidTo(date);
        l2.setActive(true);
        l2.setComments("Good");

        lines.add(l1);
        lines.add(l2);
        return lines;
    }

    @Test
    public void saveLine(){
        doNothing().when(lineDao).saveLine(any(Line.class));
        lineService.saveLine(getLinesList().get(0));
        verify(lineDao, atLeastOnce()).saveLine(getLinesList().get(0));
    }

    @Test
    public void deleteLine(){
        doNothing().when(lineDao).deleteLine(anyInt());
        lineService.deleteLine(anyInt());
        verify(lineDao, atLeastOnce()).deleteLine(anyInt());
    }

    @Test
    public void editLine(){
        Line line = lines.get(0);
        when(lineDao.findLineById(anyInt())).thenReturn(line);
        lineService.editLine(line);
        verify(lineDao, atLeastOnce()).editLine(line);
    }

    @Test
    public void findLineById(){
        Line line = lines.get(0);
        when(lineDao.findLineById(anyInt())).thenReturn(line);
        Assert.assertEquals(lineService.findLineById(line.getLineId()), line);
    }

    @Test
    public void findAllLines(){
        when(lineDao.findAllLines()).thenReturn(lines);
        Assert.assertEquals(lineService.findAllLines(), lines);
    }

    @After
    public void tearDown(){
        lines.remove(lines);
    }
}
