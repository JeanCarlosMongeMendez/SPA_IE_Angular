package cr.ac.ucr.Converter;

import cr.ac.ucr.DTO.UserProfileDTO;
import cr.ac.ucr.service.CantonService;
import cr.ac.ucr.service.DistrictService;
import cr.ac.ucr.service.ProvinceService;
import cr.ac.ucr.spa.Course;
import cr.ac.ucr.spa.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
@org.springframework.stereotype.Service
public class UserProfileConverter implements ConverterInterfaceUser <UserProfile,UserProfileDTO> {

    @Autowired
    ProvinceService provinceService;
    @Autowired
    CantonService cantonService;
    @Autowired
    DistrictService districtService;

    @Override
    public UserProfile toEntity(UserProfileDTO dto) {
        UserProfile entity = new UserProfile();
        entity.setIdUserProfile(dto.getIdUserProfile());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setUserPhoto(dto.getUserPhoto());
        entity.setInterests(dto.getInterest());
        entity.setEmail(dto.getEmail());
        entity.setAdmin(dto.isAdmin());
        entity.setEnable(dto.isEnable());
        entity.setCanton(dto.getCanton());
        entity.setProvince(dto.getProvince());
        entity.setDistrict(dto.getDistrict());
        entity.setCreationDate(dto.getCreationDate());
        return entity;
    }

    @Override
    public UserProfileDTO toDto(UserProfile entity) {
        UserProfileDTO dto = new UserProfileDTO();
        dto.setIdUserProfile(entity.getIdUserProfile());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setUserPhoto(entity.getUserPhoto());
        dto.setInterest(entity.getInterests());
        dto.setEmail(entity.getEmail());
        dto.setAdmin(entity.isAdmin());
        dto.setEnable(entity.isEnable());
        dto.setCanton(entity.getCanton());
        dto.setProvince(entity.getProvince());
        dto.setDistrict(entity.getDistrict());
        dto.setCreationDate(entity.getCreationDate());

        return dto;
    }


}
