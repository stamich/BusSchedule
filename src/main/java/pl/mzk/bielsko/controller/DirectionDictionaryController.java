package pl.mzk.bielsko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mzk.bielsko.model.DirectionDictionary;
import pl.mzk.bielsko.service.DirectionDictionaryService;

@Controller
@RequestMapping(value = "/direction")
public class DirectionDictionaryController {

    @Autowired
    public DirectionDictionaryService dictionaryService;

    @RequestMapping(value = "/new", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String addCity(ModelMap modelMap){
        DirectionDictionary dictionary = new DirectionDictionary();
        modelMap.addAttribute("direction", dictionary);
        return "addDirection.html";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public String saveAddedCity(@RequestParam("id") Integer stopId, DirectionDictionary dictionary, ModelMap modelMap){
        dictionaryService.saveDirection(stopId, dictionary);
        return "success.html";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String deleteCity(@RequestParam("id") Integer id){
        dictionaryService.deleteDirection(id);
        return "success.html";
    }
}
