package cr.ac.ucr.repository;

import cr.ac.ucr.spa.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@org.springframework.stereotype.Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
