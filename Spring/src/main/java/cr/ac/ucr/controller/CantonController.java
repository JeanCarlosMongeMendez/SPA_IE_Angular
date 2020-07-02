package cr.ac.ucr.controller;

import cr.ac.ucr.service.CantonService;
import cr.ac.ucr.service.ProvinceService;
import cr.ac.ucr.spa.Canton;
import cr.ac.ucr.spa.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/canton")
public class CantonController {
    @Autowired
    private CantonService cantonService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Canton> list() {
        return cantonService.listAll().stream().collect(Collectors.toList());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Canton get(@PathVariable Integer id) {
        return cantonService.get(id);
    }

    @RequestMapping(path = "/ByProvince/{id}", method = RequestMethod.GET)
    public List<Canton> getCantonsByProvince(@PathVariable Integer id) {
        return cantonService.getCantonsByProvince(id).stream().collect(Collectors.toList());
    }


}
