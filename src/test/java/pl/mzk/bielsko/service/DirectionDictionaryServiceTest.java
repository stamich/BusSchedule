package pl.mzk.bielsko.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import pl.mzk.bielsko.dao.DirectionDictionaryDao;
import pl.mzk.bielsko.model.DirectionDictionary;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class DirectionDictionaryServiceTest {

    @Mock
    private DirectionDictionaryDao dictionaryDao;

    @InjectMocks
    private DirectionDictionaryServiceImpl dictionaryService;

    @Spy
    List<DirectionDictionary> directionDictionaries = new ArrayList<DirectionDictionary>();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        directionDictionaries = getDirectionDictionaries();
    }


    public List<DirectionDictionary> getDirectionDictionaries(){
        DirectionDictionary d1 = new DirectionDictionary();
        d1.setId(1);
        d1.setDirection("Direction1");

        DirectionDictionary d2 = new DirectionDictionary();
        d2.setId(2);
        d2.setDirection("Direction2");

        directionDictionaries.add(d1);
        directionDictionaries.add(d2);
        return directionDictionaries;
    }

    @Test
    public void saveDirection(){
        doNothing().when(dictionaryDao).saveDirection(anyInt(), any(DirectionDictionary.class));
        dictionaryService.saveDirection(anyInt(), getDirectionDictionaries().get(0));
        verify(dictionaryDao, atLeastOnce()).saveDirection(anyInt(), getDirectionDictionaries().get(0));
    }

    @Test
    public void deleteDirection(){
        doNothing().when(dictionaryDao).deleteDirection(anyInt());
        dictionaryService.deleteDirection(anyInt());
        verify(dictionaryDao, atLeastOnce()).deleteDirection(anyInt());
    }

    @Test
    public void findDirectionById(){
        DirectionDictionary dictionary = directionDictionaries.get(1);
        when(dictionaryDao.findDirectionById(anyInt())).thenReturn(dictionary);
        Assert.assertEquals(dictionaryService.findDirectionById(dictionary.getId()), dictionary);
    }

    @Test
    public void findAllDirections(){
        when(dictionaryDao.findAllDirections()).thenReturn(directionDictionaries);
        Assert.assertEquals(dictionaryService.findAllDirections(), directionDictionaries);
    }

    @After
    public void tearDown(){
        directionDictionaries.remove(directionDictionaries);
    }
}
