package pl.mzk.bielsko.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import pl.mzk.bielsko.dao.StopNameDictionaryDao;
import pl.mzk.bielsko.model.StopNameDictionary;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class StopNameDictionaryServiceTest {

    @Mock
    private StopNameDictionaryDao dictionaryDao;

    @InjectMocks
    private StopNameDictionaryServiceImpl dictionaryService;

    @Spy
    List<StopNameDictionary> nameDictionaries = new ArrayList<StopNameDictionary>();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        nameDictionaries = getNameDictionaries();
    }

    public List<StopNameDictionary> getNameDictionaries(){
        StopNameDictionary n1 = new StopNameDictionary();
        n1.setId(1);
        n1.setStopName("Przystanek A");

        StopNameDictionary n2 = new StopNameDictionary();
        n2.setId(2);
        n2.setStopName("Przystanek B");

        nameDictionaries.add(n1);
        nameDictionaries.add(n2);
        return nameDictionaries;
    }

    @Test
    public void saveStopName(){
        doNothing().when(dictionaryDao).saveStopName(anyInt(), any(StopNameDictionary.class));
        dictionaryService.saveStopName(anyInt(), getNameDictionaries().get(0));
        verify(dictionaryDao, atLeastOnce()).saveStopName(anyInt(), getNameDictionaries().get(0));
    }

    @Test
    public void deleteStopName(){
        doNothing().when(dictionaryDao).deleteStopName(anyInt());
        dictionaryService.deleteStopName(anyInt());
        verify(dictionaryDao, atLeastOnce()).deleteStopName(anyInt());
    }

    @Test
    public void findStopNameById(){
        StopNameDictionary dictionary = nameDictionaries.get(1);
        when(dictionaryDao.findStopNameById(anyInt())).thenReturn(dictionary);
        Assert.assertEquals(dictionaryService.findStopNameById(anyInt()), dictionary);
    }

    @Test
    public void findAllStopNames(){
        when(dictionaryDao.findAllStopNames()).thenReturn(nameDictionaries);
        Assert.assertEquals(dictionaryService.findAllStopNames(), nameDictionaries);
    }

    @After
    public void tearDown(){
        nameDictionaries.remove(nameDictionaries);
    }
}
