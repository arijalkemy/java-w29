package controller;

import model.Joya;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.IJoyaService;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/create")
    public String createJoya(@RequestBody Joya joya) {
        joyaService.saveJoya(joya);
        return "La joya ha sido creada.";
    }

    @GetMapping("/joyas")
    public List<Joya> getJoyas() {
        return joyaService.getAllJoya();
    }

    @PostMapping("edit/{id}")
    public Joya editJoya(@PathVariable long id, @RequestBody Joya joya) {
        return joyaService.updateJoya(id, joya);
    }

    @PostMapping("delete/{id}")
    public String deleteJoya(@PathVariable long id) {
        joyaService.deleteJoya(id);
        return "La joya ha sido eliminada correctamente.";
    }

}
