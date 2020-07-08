package cr.ac.ucr.service;

import cr.ac.ucr.repository.ProvinceRepository;
import cr.ac.ucr.spa.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    public List<Province> listAll(){return provinceRepository.findAll();}

    public void save(Province province){provinceRepository.save(province);}

    public Province get(int id){return provinceRepository.findById(id).get();}

    public void delete(int id){provinceRepository.deleteById(id);}


}
