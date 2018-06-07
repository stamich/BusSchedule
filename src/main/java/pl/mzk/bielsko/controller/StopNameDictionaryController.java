package pl.mzk.bielsko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mzk.bielsko.model.StopNameDictionary;
import pl.mzk.bielsko.service.StopNameDictionaryService;

@Controller
@RequestMapping(value = "/stopName")
public class StopNameDictionaryController {

    @Autowired
    private StopNameDictionaryService dictionaryService;

    @RequestMapping(value = "/new", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String addCity(ModelMap modelMap){
        StopNameDictionary dictionary = new StopNameDictionary();
        modelMap.addAttribute("stopName", dictionary);
        return "addStopName.html";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public String saveAddedCity(@RequestParam("id") Integer stopId, StopNameDictionary dictionary, ModelMap modelMap){
        dictionaryService.saveStopName(stopId, dictionary);
        return "success.html";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String deleteCity(@RequestParam("id") Integer id){
        dictionaryService.deleteStopName(id);
        return "success.html";
    }
}
