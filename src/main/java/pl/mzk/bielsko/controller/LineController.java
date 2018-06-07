package pl.mzk.bielsko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mzk.bielsko.dto.LineDTO;
import pl.mzk.bielsko.dto.StopDTO;
import pl.mzk.bielsko.model.Line;
import pl.mzk.bielsko.model.Stop;
import pl.mzk.bielsko.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "/lines")
public class LineController {

    @Autowired
    private LineService lineService;

    @Autowired
    private StopService stopService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String getAllData(ModelMap modelMap){
        List<Line> lines = lineService.findAllLines();
        List<LineDTO> linesDTO = new ArrayList<LineDTO>();
        for(Line line: lines){
            LineDTO lineDTO = new LineDTO();
            lineDTO.setLineId(line.getLineId());
            lineDTO.setLineNumber(line.getLineNumber());
            lineDTO.setRelationFrom(line.getRelationFrom());
            lineDTO.setRelationTo(line.getRelationTo());
            lineDTO.setValidFrom(line.getValidFrom());
            lineDTO.setValidTo(line.getValidTo());
            lineDTO.setActive(line.getActive());
            lineDTO.setComments(line.getComments());
            lineDTO.setStops(stopService.findAllStops(line.getLineId()));
            linesDTO.add(lineDTO);
        }

        /*
        lines.stream().forEach((line) -> {
            LineDTO lineDTO = new LineDTO();
        lineDTO.setLineId(line.getLineId());
        lineDTO.setLineNumber(line.getLineNumber());
        lineDTO.setRelationFrom(line.getRelationFrom());
        lineDTO.setRelationTo(line.getRelationTo());
        lineDTO.setValidFrom(line.getValidFrom());
        lineDTO.setValidTo(line.getValidTo());
        lineDTO.setActive(line.getActive());
        lineDTO.setComments(line.getComments());
        lineDTO.setStops(stopService.findAllStops(line.getLineId()));
        linesDTO.add(lineDTO);
        });*/

        modelMap.addAttribute("lines", linesDTO);
        return "allLines.html";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String newLine(ModelMap modelMap){
        Line line = new Line();
        modelMap.addAttribute("line", line);
        return "addLine.html";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public String saveNewLine(ModelMap modelMap, Line line){

        lineService.saveLine(line);
        modelMap.addAttribute("lineSaved", messageSource.getMessage("line.data.saved",
                new Integer[]{line.getLineId()}, Locale.getDefault()));
        return "success.html";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String deleteLine(@RequestParam ("id") Integer lineId){
        lineService.deleteLine(lineId);
        return "redirect:/lines/all";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String editLine(@RequestParam ("id") Integer lineId, ModelMap modelMap){
        Line existingLine = lineService.findLineById(lineId);
        modelMap.addAttribute("existingLine", existingLine);
        return "editLine.html";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public String saveEditedLine(@RequestParam ("id") Integer lineId, ModelMap modelMap, Line line){
        modelMap.addAttribute("existingLine", line);
        line.setLineId(lineId);
        lineService.editLine(line);
        return "success.html";
    }
}
