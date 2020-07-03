package cr.ac.ucr.controller;

import cr.ac.ucr.Converter.StudentConverter;
import cr.ac.ucr.DTO.StudentDTO;
import cr.ac.ucr.spa.Student;
import cr.ac.ucr.service.StudentService;
import cr.ac.ucr.service.UserProfileService;
import cr.ac.ucr.spa.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/student")
public class StudentController {
/*
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentConverter studentConverter;
    @Autowired
    private UserProfileService profileService;

    @RequestMapping(path="/", method = RequestMethod.POST)
    public StudentDTO save(@RequestBody StudentDTO dto) {
        Student entity = studentConverter.getEntity(dto);
        UserProfile userProfileEntity = studentConverter.getUserEntity(dto);
        profileService.save(userProfileEntity);
        entity.setIdUserProfile(profileService.listAll().get(profileService.listAll().size()).getIdUserProfile());
        studentService.save(entity);
        return studentConverter.getDTO(entity, userProfileEntity);
    }

    @RequestMapping(path="/", method = RequestMethod.GET)
    public List<StudentDTO> findAll(){
        return studentService.listAll().stream().map(it -> studentConverter.getDTO(it, profileService.get(it.getIdUserProfile())))
                .collect(Collectors.toList());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public StudentDTO findById(@PathVariable("id") int id) {
        Student student = studentService.get(id);
        return studentConverter.getDTO(student, profileService.get(student.getIdUserProfile()));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public StudentDTO update(@PathVariable("id") int id,
                            @RequestBody StudentDTO dto) {
        Student entity = studentConverter.getEntity(dto);
        entity.setIdStudent(id);
        try {
            Student student = studentService.update(entity);
            return studentConverter.getDTO(student, profileService.get(student.getIdUserProfile()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        studentService.delete(id);
    }
*/
}
