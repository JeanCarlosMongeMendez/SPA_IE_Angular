package cr.ac.ucr.Converter;

import cr.ac.ucr.DTO.StudentDTO;
import cr.ac.ucr.spa.Student;
import cr.ac.ucr.service.StudentService;
import cr.ac.ucr.spa.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;

@Service
@Transactional
public class StudentConverter {
    /*

    @Autowired
    private StudentService studentService;

   // public Student getEntity (StudentDTO dto){
        Student entity = new Student();
        entity.setIdStudent(dto.getIdStudent());
        entity.setIsActive(dto.isActive());
        //entity.setIsASIP(dto.isASIP());
        entity.setCreateBy(dto.getCreatedBy());
        entity.setCreationDate(dto.getCreationDate());
        entity.setIdentificationCard(dto.getIdentificationCard());
        entity.setIdUserProfile(dto.getIdUserProfile());
        return entity;
    }

    public UserProfile getUserEntity (StudentDTO dto){
        UserProfile entity = new UserProfile();
        //entity.setAdmin(dto.isAdmin());
        entity.setCreationDate(dto.getCreationDate());
        entity.setEmail(dto.getEmail());
        //entity.setEnable(dto.isEnable());
        entity.set(dto.getIdCanton());
        entity.setIdDistrict(dto.getIdDistrict());
        entity.setIdProvince(dto.getIdProvince());
        entity.setIdUserProfile(dto.getIdUserProfile());
        //entity.setInterest(dto.getInterest());
        entity.setPassword(dto.getPassword());
        entity.setUsername(dto.getUsername());
        entity.setUserPhoto(dto.getUserPhoto());
        return entity;
    }

    public StudentDTO getDTO(Student entity, UserProfile profile){
        StudentDTO dto = new StudentDTO();
        //dto.setAdmin(profile.isAdmin());
        dto.setActive(entity.isIsActive());
        //dto.setASIP(entity.isASIP());
        dto.setCreatedBy(entity.getCreateBy());
        dto.setCreationDate((Date) entity.getCreationDate());
        dto.setEmail(profile.getEmail());
        //dto.setEnable(profile.isEnable());
        dto.setIdCanton(profile.getIdCanton());
        dto.setIdDistrict(profile.getIdDistrict());
        dto.setIdentificationCard(entity.getIdentificationCard());
        dto.setIdProvince(profile.getIdProvince());
        dto.setIdStudent(entity.getIdStudent());
        dto.setIdUserProfile(entity.getIdUserProfile());
        //dto.setInterest(profile.getInterest());
        dto.setPassword(profile.getPassword());
        dto.setUsername(profile.getUsername());
        dto.setUserPhoto(profile.getUserPhoto());
        return dto;
    }*/
}
