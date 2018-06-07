package pl.mzk.bielsko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mzk.bielsko.model.StreetDictionary;
import pl.mzk.bielsko.service.StreetDictionaryService;

@Controller
@RequestMapping(value = "/street")
public class StreetDictionaryController {

    @Autowired
    private StreetDictionaryService dictionaryService;

    @RequestMapping(value = "/new", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String addCity(ModelMap modelMap){
        StreetDictionary dictionary = new StreetDictionary();
        modelMap.addAttribute("street", dictionary);
        return "addStreet.html";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public String saveAddedCity(@RequestParam("id") Integer stopId, StreetDictionary dictionary, ModelMap modelMap){
        dictionaryService.saveStreet(stopId, dictionary);
        return "success.html";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String deleteCity(@RequestParam("id") Integer id){
        dictionaryService.deleteStreet(id);
        return "success.html";
    }
}
