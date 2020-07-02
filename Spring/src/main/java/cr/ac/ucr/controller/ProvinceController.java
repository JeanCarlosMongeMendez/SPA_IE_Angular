package cr.ac.ucr.controller;

import cr.ac.ucr.service.CourseService;
import cr.ac.ucr.service.ProvinceService;
import cr.ac.ucr.spa.Course;
import cr.ac.ucr.spa.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

//@CrossOrigin
@RestController
//@RequestMapping(path = "/api/course")

public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/provinces")
    public List<Province> list() {
        //¿reglas de negocio?
        //if...es admin
        return provinceService.listAll();
    }

    @GetMapping("/provinces/{id}")
    public ResponseEntity<Province> get(@PathVariable Integer id) {
        try {
            Province province = provinceService.get(id);
            return new ResponseEntity<Province>(province, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Province>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public void add(Province province) {
        Province existingProvince=new Province();
        existingProvince.setIdProvince(0);
        existingProvince = provinceService.get(province.getIdProvince());

        if(existingProvince.getIdProvince()!=0){
            provinceService.save(province);
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Province> update(@RequestBody Province province, @PathVariable Integer id) {
        try {
            Province existingProvince = provinceService.get(id);
            provinceService.save(existingProvince);
            return new ResponseEntity<Province>(province, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Province>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        provinceService.delete(id);
    }


}
