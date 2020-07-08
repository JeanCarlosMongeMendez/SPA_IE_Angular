package cr.ac.ucr.controller;

import cr.ac.ucr.Converter.UserProfileConverter;
import cr.ac.ucr.DTO.UserProfileDTO;
import cr.ac.ucr.Exception.LyExceptions;
import cr.ac.ucr.service.UserProfileService;
import cr.ac.ucr.spa.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/userProfile")
public class UserProfileController {
    @Autowired
    private UserProfileService service;
    @Autowired
    private UserProfileConverter converter;

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public UserProfileDTO save(@RequestBody UserProfileDTO dto) {
        UserProfile entity = converter.toEntity(dto);
        return converter.toDto(service.save(entity));
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<UserProfileDTO> findAll() {
        return service.listAll().stream().map(it -> converter.toDto(it))
                .collect(Collectors.toList());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public UserProfileDTO findById(@PathVariable("id") int id) {
        return converter.toDto(service.get(id));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public UserProfileDTO update(@PathVariable("id") int id,
                          @RequestBody UserProfileDTO dto) throws LyExceptions.RecordNotFoundException {
        UserProfile entity = converter.toEntity(dto);
        entity.setIdUserProfile(id);
        return converter.toDto(service.update(converter.toEntity(dto)));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }
}
