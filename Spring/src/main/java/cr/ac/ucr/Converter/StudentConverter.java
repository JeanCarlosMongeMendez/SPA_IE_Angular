package cr.ac.ucr.Converter;

import cr.ac.ucr.DTO.StudentDTO;
import cr.ac.ucr.spa.Student;
import cr.ac.ucr.service.StudentService;
import cr.ac.ucr.spa.Canton;
import cr.ac.ucr.spa.District;
import cr.ac.ucr.spa.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentConverter {
    /*

    @Autowired
    private StudentService studentService;

    public Student toEntity (StudentDTO dto){
        Student entity = new Student();
        Province province = new Province();
        Canton canton = new Canton();
        District district = new District();

        canton.setIdCanton(dto.getIdCanton());
        canton.setName(dto.getNameCanton());
        canton.setIdProvince(dto.getIdProvince());
        province.setIdProvince(dto.getIdProvince());
        province.setName(dto.getNameProvince());
        district.setIdDistrict(dto.getIdDistrict());
        district.setName(dto.getNameDistrict());
        district.setIdCanton(dto.getIdCanton());
        entity.setIdUserProfile(dto.getIdUserProfile());
        entity.setIdentificationCard(dto.getIdentificationCard());
        entity.setCreationDate(dto.getCreationDate());
        entity.setActive(dto.isActive());
        entity.setAsip(dto.isAsip());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setUsername(dto.getUsername());
        entity.setUserPhoto(dto.getUserPhoto());
        entity.setAdmin(dto.isAdmin());
        entity.setEnable(dto.isEnable());
        entity.setInterests(dto.getInterests());
        entity.setCanton(canton);
        entity.setDistrict(district);
        entity.setProvince(province);
        return entity;
    }

    public StudentDTO toDTO(Student entity){
        StudentDTO dto = new StudentDTO();
        dto.setActive(entity.isActive());
        dto.setCreationDate(entity.getCreationDate());
        dto.setEmail(entity.getEmail());
        dto.setIdCanton(entity.getCanton().getIdCanton());
        dto.setIdDistrict(entity.getDistrict().getIdDistrict());
        dto.setIdentificationCard(entity.getIdentificationCard());
        dto.setIdProvince(entity.getProvince().getIdProvince());
        dto.setIdUserProfile(entity.getIdUserProfile());
        dto.setPassword(entity.getPassword());
        dto.setUsername(entity.getUsername());
        dto.setUserPhoto(entity.getUserPhoto());
        dto.setAdmin(entity.isAdmin());
        dto.setAsip(entity.isAsip());
        dto.setEnable(entity.isEnable());
        dto.setInterests(entity.getInterests());
        dto.setNameCanton(entity.getCanton().getName());
        dto.setNameDistrict(entity.getDistrict().getName());
        dto.setNameProvince(entity.getProvince().getName());
        return dto;
    }*/
}
