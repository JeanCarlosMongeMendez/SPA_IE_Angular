package cr.ac.ucr.controller;

import cr.ac.ucr.service.CantonService;
import cr.ac.ucr.spa.Canton;
import cr.ac.ucr.spa.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CantonController {
    @Autowired
    private CantonService cantonService;

    @GetMapping("/cantons")
    public List<Canton> list() {
        return cantonService.listAll();
    }

    @GetMapping("/cantons/{id}")
    public ResponseEntity<Canton> get(@PathVariable Integer id) {
        try {
            Canton canton = cantonService.get(id);
            return new ResponseEntity<Canton>(canton, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Canton>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/cantonsByProvince/{id}")
    public List<Canton> getByProvince(@PathVariable Integer id) {
        return cantonService.getCantonsByProvince(id);
    }
}
