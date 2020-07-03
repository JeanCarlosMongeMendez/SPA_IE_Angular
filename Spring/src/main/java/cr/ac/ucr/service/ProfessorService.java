package cr.ac.ucr.service;

import cr.ac.ucr.Exception.LyExceptions;
import cr.ac.ucr.repository.CourseRepository;
import cr.ac.ucr.repository.ProfessorRepository;
import cr.ac.ucr.spa.Course;
import cr.ac.ucr.spa.Professor;
import cr.ac.ucr.spa.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> listAll(){return professorRepository.findAll();}

    public Professor save(Professor professor){return professorRepository.save(professor);}

    public Professor get(int id){return professorRepository.findById(id).get();}

    public Professor update(Professor entity) throws LyExceptions.RecordNotFoundException {
        Professor entityToUpdate = professorRepository.findById(entity.getIdUserProfile()).get();

        if(entityToUpdate != null) {
            return professorRepository.save(entity);
        } else throw new LyExceptions.RecordNotFoundException(UserProfile.class.getName());
    }

    public void delete(int id){professorRepository.deleteById(id);}
}
