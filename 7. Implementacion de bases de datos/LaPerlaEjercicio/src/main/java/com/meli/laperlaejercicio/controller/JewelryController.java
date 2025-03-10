package com.meli.laperlaejercicio.controller;

import com.meli.laperlaejercicio.entity.Jewelry;
import com.meli.laperlaejercicio.service.JewelryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JewelryController {
    private final JewelryService jewelryService;

    public JewelryController(JewelryService jewelryService) {
        this.jewelryService = jewelryService;
    }

    @PostMapping("/jewerly/new")
    public String saveJoya (@RequestBody Jewelry joya) {
        return jewelryService.saveJewelry(joya);
    }

    @GetMapping("/jewerly")
    public List<Jewelry> getJewelrys () {

        return jewelryService.findJewelrys();
    }

    @PutMapping("/jewerly/delete/{id}")
    public String deleteJewelry (@PathVariable Long id) {

        return jewelryService.deleteJewelry(id);
    }

    @PutMapping ("/jewerly/update/{id_modificar}")
    public String editJewelry (@PathVariable Long id_modificar,
                            @RequestBody Jewelry joya) {

        return jewelryService.editJewelry(id_modificar, joya);
    }
}
