package pl.mzk.bielsko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mzk.bielsko.service.StopService;

import java.util.Map;

@Controller
public class StopController {

    @Autowired
    private StopService stopService;

    @RequestMapping(value = "/stops", method = RequestMethod.GET)
    public String stopsList(Map<String,Object> map){
        map.put("stopList", stopService.getAllStops());
        return "stops";
    }
}
