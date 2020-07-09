package cr.ac.ucr.service;

import cr.ac.ucr.Exception.LyExceptions;
import cr.ac.ucr.repository.AppointmentRepository;
import cr.ac.ucr.spa.Appointment;
import cr.ac.ucr.spa.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> listAll(){return appointmentRepository.findAll();}

    public Appointment save(Appointment appointment){return appointmentRepository.save(appointment);}

    public Appointment get(int id){return appointmentRepository.findById(id).get();}

    public void delete(int id)throws LyExceptions.NotPosibleDeleteException{
        Appointment entityToDelete = appointmentRepository.findById(id).get();
        if(entityToDelete != null){
            appointmentRepository.deleteById(id);
        }else throw new LyExceptions.NotPosibleDeleteException(Appointment.class.getName());
    }

    public Appointment update(Appointment entity) throws LyExceptions.RecordNotFoundException {
        Appointment entityToUpdate = appointmentRepository.findById(entity.getIdAppoitment()).get();
        if(entityToUpdate != null) {
            return appointmentRepository.save(entity);
        } else throw new LyExceptions.RecordNotFoundException(Appointment.class.getName());
    }

}
