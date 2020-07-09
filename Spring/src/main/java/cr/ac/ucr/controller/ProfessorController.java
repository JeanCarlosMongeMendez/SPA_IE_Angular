package cr.ac.ucr.controller;

import cr.ac.ucr.Converter.ProfessorConverter;
import cr.ac.ucr.Converter.UserProfileConverter;
import cr.ac.ucr.DTO.ProfessorDTO;
import cr.ac.ucr.DTO.UserProfileDTO;
import cr.ac.ucr.Exception.LyExceptions;
import cr.ac.ucr.service.ProfessorService;
import cr.ac.ucr.spa.Professor;
import cr.ac.ucr.spa.Student;
import cr.ac.ucr.spa.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/professor")
public class ProfessorController {
    @Autowired
    private ProfessorService service;
    @Autowired
    private ProfessorConverter converter;

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ProfessorDTO save(@RequestBody ProfessorDTO dto) {
        Professor entity = converter.toEntity(dto);
        entity.setEnable(true);
        return converter.toDto(service.save(entity));
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<ProfessorDTO> findAll() {
        List<Professor> professors= new ArrayList<>();
        for (Professor professor: service.listAll() ) {
        if(professor.isEnable()==true){
            professors.add(professor);
        }
        }
        return professors.stream().map(it -> converter.toDto(it))
                .collect(Collectors.toList());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ProfessorDTO findById(@PathVariable("id") int id) {
        return converter.toDto(service.get(id));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ProfessorDTO update(@PathVariable("id") int id,
                                 @RequestBody ProfessorDTO dto) throws LyExceptions.RecordNotFoundException {
        Professor entity = converter.toEntity(dto);
        entity.setIdUserProfile(id);
        dto.getUserProfile().setEnable(true);
        return converter.toDto(service.update(converter.toEntity(dto)));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        ProfessorDTO dto = new ProfessorDTO();
        dto= converter.toDto(service.get(id));
        try {
            Professor entity =  converter.toEntity(dto);
            entity.setEnable(false);
            dto = converter.toDto(service.update(entity));
        } catch (LyExceptions.RecordNotFoundException e) {
            e.printStackTrace();         }

    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public Object login(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        Professor proffesorLogin = null;
        List<Professor> proffessorsList = service.listAll();
        for (Professor professor: proffessorsList) {
            if(professor.getUsername().equals(username) &&
                    professor.getPassword().equals(password) &&
                    professor.isEnable()){
                proffesorLogin = professor;
            }
        }
        if(proffesorLogin != null)
            return converter.toDto(proffesorLogin);
        else
            return new HttpClientErrorException(HttpStatus.NOT_FOUND, "Proffesor not found");
    }
}
