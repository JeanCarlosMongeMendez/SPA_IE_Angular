package cr.ac.ucr.service;

import cr.ac.ucr.repository.CourseRepository;
import cr.ac.ucr.spa.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course save(Course entity){
        if(courseRepository.existsByName(entity.getName())) throw new NameExistException();
        entity.setPass(encoder.encode(entity.getPass()));
        return courseRepository.save(entity);
    }

    public List<Course> listAll(){return courseRepository.findAll();}

    public Course get(int id){return courseRepository.findById(id).get();}

    public void delete(int id){courseRepository.deleteById(id);}

}
