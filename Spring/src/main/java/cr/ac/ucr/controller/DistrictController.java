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

    @RequestMapping(path="/", method = RequestMethod.GET)
    public List<District> list() {
        return districtService.listAll().stream().collect(Collectors.toList());
    }

    /*@GetMapping("/districts/{id}")
    public ResponseEntity<District> get(@PathVariable Integer id) {
        try {
            District district = districtService.get(id);
            return new ResponseEntity<District>(district, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<District>(HttpStatus.NOT_FOUND);
        }
    }*/

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public List<District> getByProvince(@PathVariable Integer id) {
        return districtService.getDistrictsByCanton(id);
    }
}
