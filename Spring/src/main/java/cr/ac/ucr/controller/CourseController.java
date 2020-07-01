package cr.ac.ucr.controller;

import cr.ac.ucr.repository.CourseRepository;
import cr.ac.ucr.service.CourseService;
import cr.ac.ucr.spa.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> list() {
        //¿reglas de negocio?
        //if...es admin
        return courseService.listAll();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> get(@PathVariable Integer id) {
        try {
            Course course = courseService.get(id);
            return new ResponseEntity<Course>(course, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public void add(Course course) {
        Course existingCourse=new Course();
        existingCourse.setCourseId(0);
        existingCourse = courseService.get(course.getCourseId());

        if(existingCourse.getCourseId()!=0){
            courseService.save(course);
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Course> update(@RequestBody Course course, @PathVariable Integer id) {
        try {
            Course existingCourse = courseService.get(id);
            courseService.save(existingCourse);
            return new ResponseEntity<Course>(course, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        courseService.delete(id);
    }

}
