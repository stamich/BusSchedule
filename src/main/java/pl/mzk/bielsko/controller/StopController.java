package pl.mzk.bielsko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mzk.bielsko.model.Stop;
import pl.mzk.bielsko.service.StopService;

import java.util.Map;

/**
 * Klasa warstwy prezentacji - kontroler widoku przystankow autobusowych.
 * @author Michal Stawarski
 */
@Controller
public class StopController {

    @Autowired
    private StopService stopService;

    /**
     * Metoda listujaca przystanki autobusowe wraz z godzinami odjazdu.
     * @param map
     * @return
     */
    @RequestMapping(value = "/stops", method = RequestMethod.GET)
    public String stopsList(Map<String,Object> map){
        map.put("stopList", stopService.getAllStops());
        return "stops";
    }

    /**
     * Metoda pozwalajaca na edycje danych konkretnego przystanku.
     * @param stopId
     * @param map
     * @return
     */
    @RequestMapping(value = "/editStop/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int stopId, Map<String,Object> map){
        Stop stop = stopService.findStop(stopId);
        map.put("stop", stop);
        return "editStop";
    }

    /**
     * Metoda pozwalajaca dokonac uaktualnienia danych konkretnego przystanku.
     * @param stop
     * @param map
     * @return
     */
    @RequestMapping(value = "/updateStop", method = RequestMethod.POST)
    public String update(Stop stop, Map<String,Object> map){
        stopService.updateStop(stop);
        return "redirect:stopDetails" + stop.getStopId(); //zabezpiecza przed podwójnym kliknięciem
    }

    /**
     * Metoda pozwalajaca usunac konkretny przystanek.
     * @param stopId
     * @param map
     * @return
     */
    @RequestMapping(value = "/deleteStop/{stopId}", method = RequestMethod.GET)
    public String delete(@PathVariable("stopId") int stopId, Map<String,Object> map){
        stopService.deleteStop(stopId);
        return "redirect:stops";
    }

    /**
     * Metoda umozliwiajaca tworzenie nowych przystankow autobusowych (REST - GET).
     * @param map
     * @return
     */
    @RequestMapping(value = "/createStop", method = RequestMethod.GET)
    public String register(Map<String,Object> map){
        map.put("stop", new Stop());
        return "createStop";
    }

    /**
     * Metoda umozliwiajaca tworzenie nowych przystankow autobusowych (REST - POST).
     * @param stop
     * @param map
     * @return
     */
    @RequestMapping(value = "/createStop", method = RequestMethod.POST)
    public String create(Stop stop, Map<String,Object> map){
        stopService.createStop(stop);
        return "redirect:stopDetails" + stop.getStopId(); //zabezpiecza przed podwójnym kliknięciem
    }

    /**
     * Metoda wyswietlajaca szczegoly przystankow autobusowych.
     * @param stopId
     * @param map
     * @return
     */
    @RequestMapping(value = "/details/{stopId}", method = RequestMethod.GET)
    public String details(@PathVariable("stopId") int stopId, Map<String,Object> map){
        Stop stop = stopService.findStop(stopId);
        map.put("stopId", stop.getStopId());
        map.put("street", stop.getStreet());
        map.put("stopName", stop.getStopName());
        map.put("lineNumber", stop.getLineNumber());
        map.put("direction", stop.getDirection());
        map.put("departTime", stop.getDepartTime());
        return "stopDetails";
    }

}
