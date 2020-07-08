package cr.ac.ucr.Converter;


import cr.ac.ucr.DTO.CourseDTO;
import cr.ac.ucr.DTO.UserProfileDTO;
import cr.ac.ucr.spa.Course;
import cr.ac.ucr.spa.UserProfile;
import org.apache.catalina.User;

public interface ConverterInterface<T, T1> {
    public Course toEntity(CourseDTO dto);
    public CourseDTO toDto(Course entity);
}
