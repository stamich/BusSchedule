package pl.mzk.bielsko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mzk.bielsko.model.CityDictionary;
import pl.mzk.bielsko.service.CityDictionaryService;

@Controller
@RequestMapping(value = "/city")
public class CityDictionaryController {

    @Autowired
    private CityDictionaryService dictionaryService;

    @RequestMapping(value = "/new", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String addCity(ModelMap modelMap){
        CityDictionary dictionary = new CityDictionary();
        modelMap.addAttribute("city", dictionary);
        return "addCity.html";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public String saveAddedCity(@RequestParam("id") Integer stopId, CityDictionary dictionary, ModelMap modelMap){
        dictionaryService.saveCity(stopId, dictionary);
        return "success.html";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String deleteCity(@RequestParam("id") Integer id){
        dictionaryService.deleteCity(id);
        return "success.html";
    }
}
