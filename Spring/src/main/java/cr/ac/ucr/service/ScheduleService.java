package cr.ac.ucr.service;

import cr.ac.ucr.repository.ScheduleRepository;
import cr.ac.ucr.spa.Schedule;
import cr.ac.ucr.spa.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getScheduleByProfessor(Integer id){return scheduleRepository.getScheduleByProfessor(id);}

    public List<Schedule> listAll(){return scheduleRepository.findAll();}
}
