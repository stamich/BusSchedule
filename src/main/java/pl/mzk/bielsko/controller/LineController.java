package pl.mzk.bielsko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mzk.bielsko.model.Line;
import pl.mzk.bielsko.service.LineService;

import java.util.Map;

/**
 * Klasa warstwy prezentacji - kontroler widoku linii autobusowych.
 * @author Michal Stawarski
 */
@Controller
public class LineController {

    @Autowired
    private LineService lineService;

    /**
     * Metoda listujaca linie autobusowe znajdujace sie w bazie danych.
     * @param map
     * @return
     */
    @RequestMapping(value = "/linesList", method = RequestMethod.GET)
    public String linesList(Map<String,Object> map){
        map.put("lineList", lineService.getAllLines());
        return "lines";
    }

    /**
     * Metoda pozwalajaca na edycje danych konkretnej linii autobusowej.
     * @param lineId
     * @param map
     * @return
     */
    @RequestMapping(value = "/editLine/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int lineId, Map<String,Object> map){
        Line line = lineService.findLine(lineId);
        map.put("line", line);
        return "editLine";
    }

    /**
     * Metoda pozwalajaca dokonac uaktualnienia danych konkretnej linii autobusowej.
     * @param line
     * @param map
     * @return
     */
    @RequestMapping(value = "/updateLine", method = RequestMethod.POST)
    public String update(Line line, Map<String,Object> map){
        lineService.updateLine(line);
        return "redirect:lineDetails" + line.getLineId(); //zabezpiecza przed podwojnym kliknieciem
    }

    /**
     * Metoda pozwalajaca usunac konkretna linie autobusowa.
     * @param lineId
     * @param map
     * @return
     */
    @RequestMapping(value = "/deleteLine/{lineId}", method = RequestMethod.GET)
    public String delete(@PathVariable("lineId") int lineId, Map<String,Object> map){
        lineService.deleteLine(lineId);
        return "redirect:lines";
    }

    /**
     * Metoda umozliwiajaca tworzenie nowych linii autobusowych (REST - GET).
     * @param map
     * @return
     */
    @RequestMapping(value = "/createLine", method = RequestMethod.GET)
    public String register(Map<String,Object> map){
        map.put("line", new Line());
        return "createLine";
    }

    /**
     * Metoda umozliwiajaca tworzenie nowych linii autobusowych (REST - POST).
     * @param line
     * @param map
     * @return
     */
    @RequestMapping(value = "/createLine", method = RequestMethod.POST)
    public String create(Line line, Map<String,Object> map){
        lineService.createLine(line);
        return "redirect:lineDetails" + line.getLineId(); //zabezpiecza przed podwojnym kliknieciem
    }

    /**
     * Metoda wyswietlajaca szczegoly linii autobusowych.
     * @param lineId
     * @param map
     * @return
     */
    @RequestMapping(value = "/details/{lineId}", method = RequestMethod.GET)
    public String details(@PathVariable("lineId") int lineId, Map<String,Object> map){
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
