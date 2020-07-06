package cr.ac.ucr.service;

import cr.ac.ucr.Exception.LyExceptions;
import cr.ac.ucr.repository.CourseRepository;
import cr.ac.ucr.spa.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course save(Course entity) throws LyExceptions.NameExistException {
        if(courseRepository.existsByName(entity.getName())) throw new LyExceptions.NameExistException();
       // entity.setPass(encoder.encode(entity.getPass()));
        return courseRepository.save(entity);
    }

    public List<Course> listAll(){return courseRepository.findAll();}

    public Course get(int id){return courseRepository.findById(id).get();}

    public Course update(Course entity) throws LyExceptions.RecordNotFoundException {
        Course entityToUpdate = courseRepository.findById(entity.getCourseId()).get();
        if(entityToUpdate != null) {
         //   entity.setPass(entityToUpdate.getPass());
            return courseRepository.save(entity);
        } else throw new LyExceptions.RecordNotFoundException(Course.class.getName());
    }

    public void delete(int id){courseRepository.deleteById(id);}

}
