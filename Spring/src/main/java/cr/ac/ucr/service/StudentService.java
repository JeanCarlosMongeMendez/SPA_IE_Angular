package cr.ac.ucr.service;

import cr.ac.ucr.repository.StudentRepository;
import cr.ac.ucr.spa.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> listAll(){return studentRepository.findAll();}

    public void save(Student student){studentRepository.save(student);}

    public Student get(int id){return studentRepository.findById(id).get();}

    public void delete(int id){studentRepository.deleteById(id);}

    public Student update(Student entity) throws Exception {
        Student entityToUpdate = studentRepository.findById(entity.getIdUserProfile()).get();
        if(entityToUpdate != null) {
            return studentRepository.save(entity);
        } else throw new Exception("Student not found");
    }
}
