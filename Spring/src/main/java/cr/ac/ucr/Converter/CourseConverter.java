package cr.ac.ucr.Converter;

import cr.ac.ucr.DTO.CourseDTO;
import cr.ac.ucr.service.CourseService;
import cr.ac.ucr.spa.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CourseConverter {
  /*
    @Autowired
    IssueService issueService;
    @Autowired
    ServiceService serviceService;
*/
    @Autowired
    private CourseService courseService;

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
