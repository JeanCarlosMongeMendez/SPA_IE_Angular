package cr.ac.ucr.controller;


import cr.ac.ucr.DTO.StudentDTO;
import cr.ac.ucr.service.ScheduleService;
import cr.ac.ucr.spa.Canton;
import cr.ac.ucr.spa.Schedule;
import cr.ac.ucr.spa.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public List<Schedule> getScheduleByProfessor(@PathVariable Integer id) {
        return scheduleService.getScheduleByProfessor(id);
    }


    @RequestMapping(path="/", method = RequestMethod.GET)
    public List<Schedule> listAll(){
        ArrayList<Schedule> schedules = new ArrayList<Schedule>();
        for (Schedule schedule: scheduleService.listAll() ) {

                schedules.add(schedule);
        }
        return schedules;
    }

}
