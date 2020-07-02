package cr.ac.ucr.Converter;


import cr.ac.ucr.DTO.CourseDTO;
import cr.ac.ucr.spa.Course;

public interface ConverterInterface<T, T1> {
    public Course toEntity(CourseDTO dto);
    public CourseDTO toDto(Course entity);
}
