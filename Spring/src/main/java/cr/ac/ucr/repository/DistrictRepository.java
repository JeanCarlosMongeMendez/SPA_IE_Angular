package cr.ac.ucr.repository;

import cr.ac.ucr.spa.Canton;
import cr.ac.ucr.spa.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District,Integer> {

    @Query(value = "SELECT * FROM BS_ISem_2020.District WHERE Id_Canton = :idCanton", nativeQuery = true)
    List<District> getDistrictsByCanton(@Param("idCanton") Integer id);
}
