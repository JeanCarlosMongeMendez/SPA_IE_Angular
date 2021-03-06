package cr.ac.ucr.repository;

import cr.ac.ucr.spa.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findByName(String name);
    boolean existsByName(String name);
}