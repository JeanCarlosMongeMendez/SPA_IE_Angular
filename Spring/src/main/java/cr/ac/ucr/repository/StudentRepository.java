package cr.ac.ucr.repository;

import cr.ac.ucr.spa.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@org.springframework.stereotype.Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
