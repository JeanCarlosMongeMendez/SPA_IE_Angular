package cr.ac.ucr.Converter;

import cr.ac.ucr.DTO.ProfessorDTO;
import cr.ac.ucr.DTO.UserProfileDTO;
import cr.ac.ucr.service.CantonService;
import cr.ac.ucr.service.DistrictService;
import cr.ac.ucr.service.ProvinceService;
import cr.ac.ucr.spa.Professor;
import cr.ac.ucr.spa.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
/*
public class ProfessorConverter implements  ConvertInterfaceProfessor<Professor,Integer>{

   @Autowired
    ProvinceService provinceService;
    @Autowired
    CantonService cantonService;
    @Autowired
    DistrictService districtService;

    @Override
    public Professor toEntity(ProfessorDTO dto) {
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


    }

    @Override
    public ProfessorDTO toDto(Professor entity) {



        dto.setIssuesById(entity.getIssues().stream()
                .filter(issue -> issue != null)
                .map(Issue::getReportNumber)
                .collect(Collectors.toList()));
        dto.setServicesById(
                entity.getServices().stream()
                        .filter(service -> service != null)
                        .map(Service::getId)
                        .collect(Collectors.toList()));
    }
}
*/