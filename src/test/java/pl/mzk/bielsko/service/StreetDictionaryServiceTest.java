package pl.mzk.bielsko.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import pl.mzk.bielsko.dao.StreetDictionaryDao;
import pl.mzk.bielsko.model.StreetDictionary;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class StreetDictionaryServiceTest {

    @Mock
    private StreetDictionaryDao dictionaryDao;

    @InjectMocks
    private StreetDictionaryServiceImpl dictionaryService;

    @Spy
    List<StreetDictionary> streetDictionaries = new ArrayList<StreetDictionary>();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        streetDictionaries = getStreetDictionaries();
    }

    public List<StreetDictionary> getStreetDictionaries(){
        StreetDictionary s1 = new StreetDictionary();
        s1.setId(1);
        s1.setStreet("Piastowska");

        StreetDictionary s2 = new StreetDictionary();
        s2.setId(2);
        s2.setStreet("3 maja");

        streetDictionaries.add(s1);
        streetDictionaries.add(s2);
        return streetDictionaries;
    }

    @Test
    public void saveStreet(){
        doNothing().when(dictionaryDao).saveStreet(anyInt(), any(StreetDictionary.class));
        dictionaryService.saveStreet(anyInt(), getStreetDictionaries().get(0));
        verify(dictionaryDao, atLeastOnce()).saveStreet(anyInt(), getStreetDictionaries().get(0));
    }

    @Test
    public void deleteStreet(){
        doNothing().when(dictionaryDao).deleteStreet(anyInt());
        dictionaryService.deleteStreet(anyInt());
        verify(dictionaryDao, atLeastOnce()).deleteStreet(anyInt());
    }

    @Test
    public void findStreetById(){
        StreetDictionary dictionary = getStreetDictionaries().get(0);
        when(dictionaryDao.findStreetById(anyInt())).thenReturn(dictionary);
        Assert.assertEquals(dictionaryService.findStreetById(anyInt()), dictionary);
    }

    @Test
    public void findAllStreets(){
        when(dictionaryDao.findAllStreets()).thenReturn(streetDictionaries);
        Assert.assertEquals(dictionaryService.findAllStreets(), streetDictionaries);
    }

    @After
    public void tearDown(){
        streetDictionaries.remove(streetDictionaries);
    }
}
