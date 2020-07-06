package cr.ac.ucr.controller;

import cr.ac.ucr.service.CantonService;
import cr.ac.ucr.spa.Canton;
import cr.ac.ucr.spa.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/canton")
public class CantonController {
    @Autowired
    private CantonService cantonService;

    @RequestMapping(path="/", method = RequestMethod.GET)
    public List<Canton> list() {
        return cantonService.listAll();
    }

    /*@GetMapping("/cantons/{id}")
    public ResponseEntity<Canton> get(@PathVariable Integer id) {
        try {
            Canton canton = cantonService.get(id);
            return new ResponseEntity<Canton>(canton, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Canton>(HttpStatus.NOT_FOUND);
        }
    }*/

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public List<Canton> getByProvince(@PathVariable Integer id) {
        return cantonService.getCantonsByProvince(id);
    }
}
