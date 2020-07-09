package cr.ac.ucr.controller;

import cr.ac.ucr.Converter.StudentConverter;
import cr.ac.ucr.DTO.StudentDTO;
import cr.ac.ucr.spa.Student;
import cr.ac.ucr.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentConverter studentConverter;

    @RequestMapping(path="/", method = RequestMethod.POST)
    public StudentDTO save(@RequestBody StudentDTO dto) {
        Student entity = studentConverter.toEntity(dto);
        studentService.save(entity);
        return studentConverter.toDTO(entity);
    }

    @RequestMapping(path="/", method = RequestMethod.GET)
    public List<StudentDTO> findAll(){
        return studentService.listAll().stream().map(it ->
                studentConverter.toDTO(it)).collect(Collectors.toList());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public StudentDTO findById(@PathVariable("id") int id) {
        Student student = studentService.get(id);
        return studentConverter.toDTO(student);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public StudentDTO update(@PathVariable("id") int id,
                            @RequestBody StudentDTO dto) {
        Student entity = studentConverter.toEntity(dto);
        entity.setActive(true);
        entity.setEnable(true);
        try {
            Student student = studentService.update(entity);
            return studentConverter.toDTO(student);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        studentService.delete(id);
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public Object login(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        Student studentLogin = null;
        List<Student> students = studentService.listAll();
        for (Student student: students) {
            if(student.getUsername().equals(username) &&
                    student.getPassword().equals(password) && student.isActive() &&
                    student.isEnable()){
                studentLogin = student;
            }
        }
        if(studentLogin != null)
            return studentConverter.toDTO(studentLogin);
        else
            return new HttpClientErrorException(HttpStatus.NOT_FOUND, "Student not found");
    }
}