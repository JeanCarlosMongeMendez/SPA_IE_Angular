package cr.ac.ucr.Converter;

import cr.ac.ucr.DTO.ProfessorDTO;
import cr.ac.ucr.DTO.UserProfileDTO;
import cr.ac.ucr.service.CantonService;
import cr.ac.ucr.service.DistrictService;
import cr.ac.ucr.service.ProvinceService;
import cr.ac.ucr.service.UserProfileService;
import cr.ac.ucr.spa.Professor;
import cr.ac.ucr.spa.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
@org.springframework.stereotype.Service
public class ProfessorConverter implements  ConvertInterfaceProfessor<Professor,Integer>{

   @Autowired
    ProvinceService provinceService;
    @Autowired
    CantonService cantonService;
    @Autowired
    DistrictService districtService;
    @Autowired
    UserProfileService userProfileService;

    @Override
    public Professor toEntity(ProfessorDTO dto) {
        Professor entity = new Professor();
        entity.setIdUserProfile(dto.getUserProfile().getIdUserProfile());
        entity.setUsername(dto.getUserProfile().getUsername());
        entity.setPassword(dto.getUserProfile().getPassword());
        entity.setUserPhoto(dto.getUserProfile().getUserPhoto());
        entity.setInterests(dto.getUserProfile().getInterests());
        entity.setEmail(dto.getUserProfile().getEmail());
        entity.setAdmin(dto.getUserProfile().isAdmin());
        entity.setEnable(dto.getUserProfile().isEnable());
        entity.setCanton(dto.getUserProfile().getCanton());
        entity.setProvince(dto.getUserProfile().getProvince());
        entity.setDistrict(dto.getUserProfile().getDistrict());
        entity.setCreationDate(dto.getUserProfile().getCreationDate());
        entity.setDegree(dto.getDegree());
        return entity;
    }

    @Override
    public ProfessorDTO toDto(Professor entity) {
        ProfessorDTO dto = new ProfessorDTO();
        UserProfile user= new UserProfile();
        user.setIdUserProfile(entity.getIdUserProfile());
        user.setUsername(entity.getUsername());
        user.setPassword(entity.getPassword());
        user.setUserPhoto(entity.getUserPhoto());
        user.setInterests(entity.getInterests());
        user.setEmail(entity.getEmail());
        user.setAdmin(entity.isAdmin());
        user.setEnable(entity.isEnable());
        user.setCanton(entity.getCanton());
        user.setProvince(entity.getProvince());
        user.setDistrict(entity.getDistrict());
        user.setCreationDate(entity.getCreationDate());
        dto.setUserProfile(user);
        dto.setDegree(entity.getDegree());
        return dto;

    }
}
