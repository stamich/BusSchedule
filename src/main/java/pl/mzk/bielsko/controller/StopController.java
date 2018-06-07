package pl.mzk.bielsko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mzk.bielsko.dto.StopDTO;
import pl.mzk.bielsko.model.Stop;
import pl.mzk.bielsko.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "/stops")
public class StopController {

    @Autowired
    private StopService stopService;

    @Autowired
    private CityDictionaryService cityService;

    @Autowired
    private DirectionDictionaryService directionService;

    @Autowired
    private StopNameDictionaryService stopNameService;

    @Autowired
    private StreetDictionaryService streetService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String getAllData(ModelMap modelMap){
        List<Stop> stops = stopService.findAllStops();
        List<StopDTO> stopsDTO = new ArrayList<StopDTO>();
        for(Stop stop: stops){
            StopDTO stopDTO = new StopDTO();
            stopDTO.setStopId(stop.getStopId());
            stopDTO.setStopNumber(stop.getStopNumber());
            stopDTO.setDepartWorking(stop.getDepartWorking());
            stopDTO.setDepartSaturdays(stop.getDepartSaturdays());
            stopDTO.setDepartSundays(stop.getDepartSundays());
            stopDTO.setComments(stop.getComments());
            stopDTO.setLine(stop.getLine());
            stopDTO.setCityDictionaries(cityService.findAllCities(stop.getStopId()));
            stopDTO.setDirectionDictionaries(directionService.findAllDirections(stop.getStopId()));
            stopDTO.setStopNameDictionaries(stopNameService.findAllStopNames(stop.getStopId()));
            stopDTO.setStreetDictionaries(streetService.findAllStreets(stop.getStopId()));
            stopsDTO.add(stopDTO);
        }
        modelMap.addAttribute("stops", stopsDTO);
        return "allStops.html";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String newStop(ModelMap modelMap){
        Stop stop = new Stop();
        modelMap.addAttribute("stop", stop);
        return "addStop.html";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public String saveNewStop(@RequestParam("id") Integer lineId, Stop stop, ModelMap modelMap){
        stopService.saveStop(lineId, stop);
        modelMap.addAttribute("stopSaved", messageSource.getMessage("stop.data.saved",
                new Integer[]{stop.getStopId()}, Locale.getDefault()));
        return "success.html";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String deleteStop(@RequestParam ("id") Integer stopId){
        stopService.deleteStop(stopId);
        return "success.html";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String editStop(@RequestParam ("id") Integer stopId, ModelMap modelMap){
        Stop existingStop = stopService.findStop(stopId);
        modelMap.addAttribute("existingStop", existingStop);
        return "editStop.html";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public String saveEditedStop(@RequestParam ("id") Integer stopId, ModelMap modelMap, Stop stop){
        modelMap.addAttribute("existingStop", stop);
        stop.setStopId(stopId);
        stopService.editStop(stop);
        return "success.html";
    }
}
