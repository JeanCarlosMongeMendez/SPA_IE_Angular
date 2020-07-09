package cr.ac.ucr.controller;

import cr.ac.ucr.Converter.AppointmentConverter;
import cr.ac.ucr.DTO.AppointmentDTO;
import cr.ac.ucr.DTO.UserProfileDTO;
import cr.ac.ucr.Exception.LyExceptions;
import cr.ac.ucr.service.AppointmentService;
import cr.ac.ucr.spa.Appointment;
import cr.ac.ucr.spa.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    AppointmentConverter appointmentConverter;

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public AppointmentDTO update(@PathVariable("id") int id,
                                 @RequestBody AppointmentDTO dto) throws LyExceptions.RecordNotFoundException {
        Appointment entity = appointmentConverter.toEntity(dto);
        entity.setIdAppoitment(id);
        return appointmentConverter.toDTO(appointmentService.update(appointmentConverter.toEntity(dto)));
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public AppointmentDTO save(@RequestBody AppointmentDTO dto) {
        Appointment entity = appointmentConverter.toEntity(dto);
        return appointmentConverter.toDTO(appointmentService.save(entity));
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<AppointmentDTO> findAll() {
        return appointmentService.listAll().stream().map(it -> appointmentConverter.toDTO(it))
                .collect(Collectors.toList());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public AppointmentDTO findById(@PathVariable("id") int id) {
        return appointmentConverter.toDTO(appointmentService.get(id));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) throws LyExceptions.NotPosibleDeleteException {
        appointmentService.delete(id);
    }

}
