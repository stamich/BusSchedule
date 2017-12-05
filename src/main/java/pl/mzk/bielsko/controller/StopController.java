package pl.mzk.bielsko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mzk.bielsko.model.Stop;
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

    @RequestMapping(value = "/editStop/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int stopId, Map<String,Object> map){
        Stop stop = stopService.findStop(stopId);
        map.put("stop", stop);
        return "editStop";
    }

    @RequestMapping(value = "/updateStop", method = RequestMethod.POST)
    public String update(Stop stop, Map<String,Object> map){
        stopService.updateStop(stop);
        return "redirect:stopDetails" + stop.getStopId(); //zabezpiecza przed podwójnym kliknięciem
    }

    @RequestMapping(value = "/deleteStop/{stopId}", method = RequestMethod.GET)
    public String delete(@PathVariable("stopId") int stopId, Map<String,Object> map){
        stopService.deleteStop(stopId);
        return "redirect:stops";
    }

    @RequestMapping(value = "/createStop", method = RequestMethod.GET)
    public String register(Map<String,Object> map){
        map.put("stop", new Stop());
        return "createStop";
    }

    @RequestMapping(value = "/createStop", method = RequestMethod.POST)
    public String create(Stop stop, Map<String,Object> map){
        stopService.createStop(stop);
        return "redirect:stopDetails" + stop.getStopId(); //zabezpiecza przed podwójnym kliknięciem
    }

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
