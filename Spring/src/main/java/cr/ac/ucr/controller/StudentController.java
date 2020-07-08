package cr.ac.ucr.controller;

import cr.ac.ucr.Converter.StudentConverter;
import cr.ac.ucr.DTO.StudentDTO;
import cr.ac.ucr.Exception.LyExceptions;
import cr.ac.ucr.spa.Student;
import cr.ac.ucr.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        entity.setActive(false);
        entity.setEnable(true);
        studentService.save(entity);
        return studentConverter.toDTO(entity);
    }

    @RequestMapping(path="/", method = RequestMethod.GET)
    public List<StudentDTO> listAll(){
        ArrayList<Student> students = new ArrayList<Student>();
        for (Student student: studentService.listAll() ) {
            if(student.isEnable()==true){
                students.add(student);
            }
        }
        return students.stream().map(it -> studentConverter.toDTO(it))
                .collect(Collectors.toList());
    }

    @RequestMapping(path="/approved", method = RequestMethod.GET)
    public List<StudentDTO> listApproved(){
        ArrayList<Student> students = new ArrayList<Student>();
        for (Student student: studentService.listAll() ) {
            if(student.isEnable()==true && student.isActive() == true){
                students.add(student);
            }
        }
        return students.stream().map(it -> studentConverter.toDTO(it))
                .collect(Collectors.toList());
    }

    @RequestMapping(path="/disapproved", method = RequestMethod.GET)
    public List<StudentDTO> listDisapproved(){
        ArrayList<Student> students = new ArrayList<Student>();
        for (Student student: studentService.listAll() ) {
            if(student.isEnable()==true && student.isActive() == false){
                students.add(student);
            }
        }
        return students.stream().map(it -> studentConverter.toDTO(it))
                .collect(Collectors.toList());
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

    @RequestMapping(path = "/approve/{id}", method = RequestMethod.PUT)
    public StudentDTO approve(@PathVariable("id") int id,
            @RequestBody StudentDTO dto) {
        Student entity = studentService.get(id);
        entity.setActive(true);
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
        StudentDTO dto = new StudentDTO();
        dto= studentConverter.toDTO(studentService.get(id));
        try {
            Student entity =  studentConverter.toEntity(dto);
            entity.setEnable(false);
            dto = studentConverter.toDTO(studentService.update(entity));
        } catch (LyExceptions.RecordNotFoundException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/reject/{id}", method = RequestMethod.DELETE)
    public void reject(@PathVariable("id") int id) {
        studentService.delete(id);
    }
}