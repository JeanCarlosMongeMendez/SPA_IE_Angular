package cr.ac.ucr.repository;

import cr.ac.ucr.spa.Canton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CantonRepository extends JpaRepository<Canton, Integer> {

    @Query(value = "SELECT * FROM BS_ISem_2020.Canton WHERE Id_Province = :idProvince", nativeQuery = true)
    List<Canton> getCantonByProvince(@Param("idProvince") Integer idProvince);
}
