package cr.ac.ucr.service;

import cr.ac.ucr.repository.CantonRepository;
import cr.ac.ucr.repository.CourseRepository;
import cr.ac.ucr.spa.Canton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
;

@Service
@Transactional
public class CantonService {
    @Autowired
    private CantonRepository cantonRepository;

    public List<Canton> listAll(){return cantonRepository.findAll();}

    public void save(Canton canton){cantonRepository.save(canton);}

    public Canton get(int id){return cantonRepository.findById(id).get();}

    public void delete(int id){cantonRepository.deleteById(id);}
}
