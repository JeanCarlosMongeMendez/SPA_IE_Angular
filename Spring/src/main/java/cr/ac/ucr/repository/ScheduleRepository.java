package cr.ac.ucr.repository;

import cr.ac.ucr.spa.Canton;
import cr.ac.ucr.spa.District;
import cr.ac.ucr.spa.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {

    @Query(value = "SELECT * FROM BS_ISem_2020.Schedule WHERE Id_Professor = :idProfessor", nativeQuery = true)
    List<Schedule> getScheduleByProfessor(@Param("idProfessor") Integer id);

}
