package cr.ac.ucr.controller;

import cr.ac.ucr.service.ProvinceService;
import cr.ac.ucr.spa.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/province")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @RequestMapping(path="/", method = RequestMethod.GET)
    public List<Province> list() {
        //¿reglas de negocio?
        //if...es admin
        return provinceService.listAll();
    }
}
