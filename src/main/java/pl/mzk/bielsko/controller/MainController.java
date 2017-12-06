package pl.mzk.bielsko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Klasa warstwy prezentacji - prosty kontroler strony powitalnej aplikacji.
 * @author Michal Stawarski
 */
@Controller
public class MainController {

    /**
     * Metoda wyswietlajaca strone powitalna aplikacji.
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainView(){
        return "main";
    }

    /**
     * Metoda wyświetlajaca strone o aplikacji.
     * @return
     */
    @RequestMapping(value = "/description", method = RequestMethod.GET)
    public String descriptionView(){
        return "description";
    }
}
