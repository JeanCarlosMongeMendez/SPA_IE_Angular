package cr.ac.ucr.controller;

import cr.ac.ucr.service.DistrictService;
import cr.ac.ucr.service.ProvinceService;
import cr.ac.ucr.spa.Canton;
import cr.ac.ucr.spa.District;
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
@RequestMapping(path = "/api/district")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<District> list() {
        return districtService.listAll().stream().collect(Collectors.toList());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public District get(@PathVariable Integer id) {
        return districtService.get(id);
    }

    @RequestMapping(path = "/ByCanton/{id}", method = RequestMethod.GET)
    public List<District> getCantonsByCantons(@PathVariable Integer id) {
        return districtService.getDistrictsByCanton(id).stream().collect(Collectors.toList());
    }
}
