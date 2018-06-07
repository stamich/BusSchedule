package pl.mzk.bielsko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String mainView(){
        return "index.html";
    }

    @RequestMapping(value = "/description", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String descriptionView(){
        return "description.html";
    }
}
