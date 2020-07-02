package cr.ac.ucr.service;

import cr.ac.ucr.repository.CourseRepository;
import cr.ac.ucr.repository.ProfessorRepository;
import cr.ac.ucr.spa.Course;
import cr.ac.ucr.spa.Professor;
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

    public void save(Professor professor){professorRepository.save(professor);}

    public Professor get(int id){return professorRepository.findById(id).get();}

    public void delete(int id){professorRepository.deleteById(id);}
}
