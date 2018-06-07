package pl.mzk.bielsko.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import pl.mzk.bielsko.dao.CityDictionaryDao;
import pl.mzk.bielsko.model.CityDictionary;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class CityDictionaryServiceTest {

    @Mock
    private CityDictionaryDao dictionaryDao;

    @InjectMocks
    private CityDictionaryServiceImpl dictionaryService;

    @Spy
    List<CityDictionary> cityDictionaries = new ArrayList<CityDictionary>();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        cityDictionaries = getCityDictionariesList();
    }


    public List<CityDictionary> getCityDictionariesList(){

        CityDictionary c1 = new CityDictionary();
        c1.setId(1);
        c1.setCityName("Bielsko-Biała");

        CityDictionary c2 = new CityDictionary();
        c2.setId(2);
        c2.setCityName("Czechowice");

        cityDictionaries.add(c1);
        cityDictionaries.add(c2);
        return cityDictionaries;
    }

    @Test
    public void saveCity(){
        doNothing().when(dictionaryDao).saveCity(anyInt(), any(CityDictionary.class));
        dictionaryService.saveCity(anyInt(), getCityDictionariesList().get(0));
        verify(dictionaryDao, atLeastOnce()).saveCity(anyInt(), getCityDictionariesList().get(0));
    }

    @Test
    public void editCity(){
        CityDictionary dictionary = cityDictionaries.get(0);
        when(dictionaryDao.findCityById(anyInt())).thenReturn(dictionary);
        dictionaryService.editCity(dictionary);
        verify(dictionaryDao, atLeastOnce()).editCity(dictionary);
    }

    @Test
    public void deleteCity(){
        doNothing().when(dictionaryDao).deleteCity(anyInt());
        dictionaryService.deleteCity(anyInt());
        verify(dictionaryDao, atLeastOnce()).deleteCity(anyInt());
    }

    @Test
    public void findCityById(){
        CityDictionary dictionary = cityDictionaries.get(1);
        when(dictionaryDao.findCityById(anyInt())).thenReturn(dictionary);
        Assert.assertEquals(dictionaryService.findCityById(dictionary.getId()), dictionary);
    }

    @Test
    public void findAllCities(){
        when(dictionaryDao.findAllCities()).thenReturn(cityDictionaries);
        Assert.assertEquals(dictionaryService.findAllCities(), cityDictionaries);
    }

    @After
    public void tearDown(){
        cityDictionaries.remove(cityDictionaries);
    }
}
