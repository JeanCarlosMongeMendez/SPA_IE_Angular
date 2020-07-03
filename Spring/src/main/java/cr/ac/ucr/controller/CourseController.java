package cr.ac.ucr.controller;

import cr.ac.ucr.Converter.CourseConverter;
import cr.ac.ucr.DTO.CourseDTO;
import cr.ac.ucr.Exception.LyExceptions;
import cr.ac.ucr.repository.CourseRepository;
import cr.ac.ucr.service.CourseService;
import cr.ac.ucr.spa.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
/*
@CrossOrigin
@RestController
@RequestMapping(path = "/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseConverter converter;

    /*
    @RequestMapping(path="/", method = RequestMethod.POST)
    public Course save(@RequestBody Course entity) throws LyExceptions.NameExistException {
        return courseService.save(entity);
    }

    @RequestMapping(path="/", method = RequestMethod.GET)
    public List<Course> findAll(){
        return courseService.listAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Course findById(@PathVariable("id") int id) {
        return  courseService.get(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Course update(@PathVariable("id") int id,
                            @RequestBody Course entity) {
        entity.setCourseId(id);
        try {
            courseService.update(entity);
            return entity;
        } catch (LyExceptions.RecordNotFoundException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        courseService.delete(id);
    }
*/

    //CON DTO

    @RequestMapping(path="/", method = RequestMethod.POST)
    public CourseDTO save(@RequestBody CourseDTO dto) throws LyExceptions.NameExistException {
        Course entity = converter.toEntity(dto);
        return converter.toDto(courseService.save(entity));
    }

    @RequestMapping(path="/", method = RequestMethod.GET)
    public List<CourseDTO> findAll(){
        return courseService.listAll().stream().map(it -> converter.toDto(it))
                .collect(Collectors.toList());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CourseDTO findById(@PathVariable("id") int id) {
        Course course = courseService.get(id);
        return  converter.toDto(course);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public CourseDTO update(@PathVariable("id") int id,
                            @RequestBody CourseDTO dto) {
        CourseDTO courseDTO=new CourseDTO();
        Course entity = converter.toEntity(dto);
        entity.setCourseId(id);
        try {
            courseDTO=converter.toDto(courseService.update(converter.toEntity(dto)));
            return courseDTO;
        } catch (LyExceptions.RecordNotFoundException e) {
            e.printStackTrace();
        }
        return courseDTO;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        courseService.delete(id);
    }

    //SIN ANGULAR
    /*
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
*/
//}