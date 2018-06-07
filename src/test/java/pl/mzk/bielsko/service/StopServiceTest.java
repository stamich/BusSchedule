package pl.mzk.bielsko.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import pl.mzk.bielsko.dao.StopDao;
import pl.mzk.bielsko.model.Stop;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class StopServiceTest {

    @Mock
    private StopDao stopDao;

    @InjectMocks
    private StopServiceImpl stopService;

    @Spy
    List<Stop> stops = new ArrayList<Stop>();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        stops = getStops();
    }

    public List<Stop> getStops(){

        LocalTime time = LocalTime.now();

        Stop s1 = new Stop();
        s1.setStopId(1);
        s1.setDepartWorking(time);
        s1.setDepartSaturdays(time);
        s1.setDepartSundays(time);
        s1.setComments("Bez kometarza");

        Stop s2 = new Stop();
        s2.setStopId(2);
        s2.setDepartWorking(time);
        s2.setDepartSaturdays(time);
        s2.setDepartSundays(time);
        s2.setComments("Nie ma");

        stops.add(s1);
        stops.add(s2);
        return stops;
    }

    @Test
    public void saveStop(){
        doNothing().when(stopDao).saveStop(anyInt(), any(Stop.class));
        stopService.saveStop(anyInt(), getStops().get(0));
        verify(stopDao, atLeastOnce()).saveStop(anyInt(), getStops().get(0));
    }

    @Test
    public void editStop(){
        Stop stop = stops.get(1);
        when(stopDao.findStop(anyInt())).thenReturn(stop);
        stopService.editStop(stop);
        verify(stopDao, atLeastOnce()).editStop(stop);
    }

    @Test
    public void deleteStop(){
        doNothing().when(stopDao).deleteStop(anyInt());
        stopService.deleteStop(anyInt());
        verify(stopDao, atLeastOnce()).deleteStop(anyInt());
    }

    @Test
    public void findStop(){
        Stop stop = stops.get(1);
        when(stopDao.findStop(anyInt())).thenReturn(stop);
        Assert.assertEquals(stopService.findStop(stop.getStopId()), stop);
    }

    @Test
    public void findAllStops(){
        when(stopDao.findAllStops()).thenReturn(stops);
        Assert.assertEquals(stopService.findAllStops(), stops);
    }

    @After
    public void tearDown(){
        stops.remove(stops);
    }
}
