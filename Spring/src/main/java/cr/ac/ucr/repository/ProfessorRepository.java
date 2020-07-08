package cr.ac.ucr.repository;

import cr.ac.ucr.spa.Canton;
import cr.ac.ucr.spa.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Integer> {

}
