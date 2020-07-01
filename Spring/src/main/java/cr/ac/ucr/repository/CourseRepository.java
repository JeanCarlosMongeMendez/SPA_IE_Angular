package cr.ac.ucr.repository;

import cr.ac.ucr.spa.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
