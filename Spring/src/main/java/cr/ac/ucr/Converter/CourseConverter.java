package cr.ac.ucr.Converter;

import cr.ac.ucr.DTO.CourseDTO;
import cr.ac.ucr.spa.Course;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.DatatypeConverterInterface;
import javax.xml.ws.Service;

@org.springframework.stereotype.Service
public class CourseConverter implements ConverterInterface<Course, CourseDTO> {
  /*
    @Autowired
    IssueService issueService;
    @Autowired
    ServiceService serviceService;
*/
    @Override
    public Course toEntity(CourseDTO dto){
        Course entity = new Course();
        entity.setCourseId(dto.getCourseId());
        entity.setName(dto.getName());
        entity.setState(dto.getState());
        entity.setSemester(dto.getSemester());
        entity.setDescription(dto.getDescription());
        entity.setImage(dto.getImage());
        entity.setCreationDate(dto.getCreationDate());
        return entity;
    }

    @Override
    public CourseDTO toDto(Course entity){
        CourseDTO dto = new CourseDTO();
        dto.setCourseId(entity.getCourseId());
        dto.setName(entity.getName());
        dto.setState(entity.getState());
        dto.setSemester(entity.getSemester());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        dto.setCreationDate(entity.getCreationDate());
        return dto;
    }
}
