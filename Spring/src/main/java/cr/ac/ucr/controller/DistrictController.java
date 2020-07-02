package cr.ac.ucr.controller;

import cr.ac.ucr.service.DistrictService;
import cr.ac.ucr.spa.Canton;
import cr.ac.ucr.spa.District;
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
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @GetMapping("/districts")
    public List<District> list() {
        return districtService.listAll();
    }

    @GetMapping("/districts/{id}")
    public ResponseEntity<District> get(@PathVariable Integer id) {
        try {
            District district = districtService.get(id);
            return new ResponseEntity<District>(district, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<District>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/districtsByCanton/{id}")
    public List<District> getByProvince(@PathVariable Integer id) {
        return districtService.getDistrictsByCanton(id);
    }
}
