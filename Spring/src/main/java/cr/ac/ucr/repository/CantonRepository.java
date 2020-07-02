package cr.ac.ucr.repository;

import cr.ac.ucr.spa.Canton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CantonRepository extends JpaRepository<Canton, Integer> {
}
