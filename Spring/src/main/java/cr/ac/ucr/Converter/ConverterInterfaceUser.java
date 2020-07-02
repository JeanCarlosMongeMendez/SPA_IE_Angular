package cr.ac.ucr.Converter;

import cr.ac.ucr.DTO.CourseDTO;
import cr.ac.ucr.DTO.UserProfileDTO;
import cr.ac.ucr.spa.Course;
import cr.ac.ucr.spa.UserProfile;

public interface ConverterInterfaceUser <T, T1>{
    public UserProfile toEntity(UserProfileDTO dto);
    public UserProfileDTO toDto(UserProfile entity);
}

