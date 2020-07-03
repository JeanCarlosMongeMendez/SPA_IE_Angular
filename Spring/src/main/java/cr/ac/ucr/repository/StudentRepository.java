package cr.ac.ucr.repository;

import cr.ac.ucr.spa.Student;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
