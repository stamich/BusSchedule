package pl.mzk.bielsko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mzk.bielsko.model.Line;
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

    @RequestMapping(value = "/editLine/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int lineId, Map<String,Object> map){
        Line line = lineService.findLine(lineId);
        map.put("line", line);
        return "editLine";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Line line, Map<String,Object> map){
        lineService.updateLine(line);
        return "redirect:lineDetails" + line.getLineId(); //zabezpiecza przed podwojnym kliknieciem
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int lineId, Map<String,Object> map){
        lineService.deleteLine(lineId);
        return "redirect:lines";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Map<String,Object> map){
        map.put("line", new Line());
        return "createLine";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Line line, Map<String,Object> map){
        lineService.createLine(line);
        return "redirect:lineDetails" + line.getLineId(); //zabezpiecza przed podwojnym kliknieciem
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable("id") int lineId, Map<String,Object> map){
        Line line = lineService.findLine(lineId);
        map.put("lineId", line.getLineId());
        map.put("lineNumber", line.getLineNumber());
        map.put("relation", line.getRelation());
        map.put("direction", line.getDirection());
        map.put("validFrom", line.getValidFrom());
        map.put("validTo", line.getValidTo());
        return "lineDetails";
    }
}
