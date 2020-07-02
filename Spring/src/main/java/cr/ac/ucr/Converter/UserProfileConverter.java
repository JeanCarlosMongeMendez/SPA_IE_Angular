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
        entity.setInterest(dto.getInterest());
        entity.setEmail(dto.getEmail());
        entity.setAdmin(dto.isAdmin());
        entity.setEnable(dto.isEnable());
        entity.setIdCanton(dto.getCanton().getIdCanton());
        entity.setIdProvince(dto.getProvince().getIdProvince());
        entity.setIdDistrict(dto.getDistrict().getIdDistrict());
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
        dto.setInterest(entity.getInterest());
        dto.setEmail(entity.getEmail());
        dto.setAdmin(entity.isAdmin());
        dto.setEnable(entity.isEnable());
        dto.setCanton(cantonService.get(entity.getIdCanton()));
        dto.setProvince(provinceService.get(entity.getIdProvince()));
        dto.setDistrict(districtService.get(entity.getIdDistrict()));
        dto.setCreationDate(entity.getCreationDate());

        return dto;
    }


}
