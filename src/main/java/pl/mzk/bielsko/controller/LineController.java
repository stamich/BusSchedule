package pl.mzk.bielsko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mzk.bielsko.service.LineService;

import java.util.Map;

@Controller
public class LineController {

    @Autowired
    private LineService lineService;

    @RequestMapping(value = "/lines", method = RequestMethod.GET)
    public String linesList(Map<String,Object> map){
        map.put("lineList", lineService.getAllLines());
        return "lines";
    }
}
