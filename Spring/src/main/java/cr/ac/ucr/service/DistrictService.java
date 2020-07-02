package cr.ac.ucr.service;

import cr.ac.ucr.repository.CourseRepository;
import cr.ac.ucr.repository.DistrictRepository;
import cr.ac.ucr.spa.Course;
import cr.ac.ucr.spa.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;
    public List<District> listAll(){return districtRepository.findAll();}

    public void save(District district){districtRepository.save(district);}

    public District get(int id){return districtRepository.findById(id).get();}

    public void delete(int id){districtRepository.deleteById(id);}
}
