package cr.ac.ucr.Converter;

import com.sun.istack.NotNull;
import cr.ac.ucr.DTO.AppointmentDTO;
import cr.ac.ucr.service.AppointmentService;
import cr.ac.ucr.service.ProfessorService;
import cr.ac.ucr.service.StudentService;
import cr.ac.ucr.spa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Service
public class AppointmentConverter {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private StudentService studentService;

    public Appointment toEntity (AppointmentDTO dto){
        Appointment entity = new Appointment();
        Professor professor= new Professor();
        Student student = new Student();
        Course course = new Course();
        Schedule schedule = new Schedule();
        UserProfile userProfessor = new UserProfile();
        UserProfile userStudent = new UserProfile();

        userProfessor=professorService.get(dto.getIdProfessor());
        userStudent=studentService.get(dto.getIdStudent());

        entity.setIdAppoitment(dto.getIdAppoitment());
        entity.setStatusApprovedDisapproved(dto.isStatusApprovedDisapproved());
        entity.setVirtualOnSite(dto.isVirtualOnSite());
        entity.setReasonForAppointment(dto.getReasonForAppointment());
        entity.setProfessorResponse(dto.getProfessorResponse());


        professor.setIdUserProfile(dto.getIdProfessor());
        professor.setDegree(dto.getDegree());
        professor.setUsername(userProfessor.getUsername());
        professor.setPassword(userProfessor.getPassword());
        professor.setUserPhoto(userProfessor.getUserPhoto());
        professor.setInterests(userProfessor.getInterests());
        professor.setEmail(userProfessor.getEmail());
        professor.setAdmin(userProfessor.isAdmin());
        professor.setEnable(userProfessor.isEnable());
        professor.setCanton(userProfessor.getCanton());
        professor.setProvince(userProfessor.getProvince());
        professor.setDistrict(userProfessor.getDistrict());
        professor.setCreationDate(userProfessor.getCreationDate());


       // professor.setIdUserProfile(dto.getIdUserProfile());

        student.setIdUserProfile(dto.getIdStudent());
        student.setIdentificationCard(dto.getIdentificationCard());
        student.setAsip(dto.isAsip());
        student.setActive(dto.isActive());

       student.setUsername(userStudent.getUsername());
       student.setPassword(userStudent.getPassword());
       student.setUserPhoto(userStudent.getUserPhoto());
       student.setInterests(userStudent.getInterests());
       student.setEmail(userStudent.getEmail());
       student.setAdmin(userStudent.isAdmin());
       student.setEnable(userStudent.isEnable());
       student.setCanton(userStudent.getCanton());
       student.setProvince(userStudent.getProvince());
       student.setDistrict(userStudent.getDistrict());
       student.setCreationDate(userStudent.getCreationDate());


        course.setCourseId(dto.getIdCourse());
        course.setName(dto.getName());
        course.setSemester(dto.getSemester());
        course.setDescription(dto.getDescription());
        course.setImage(dto.getImage());
        Boolean state=true;
        if (dto.isState()==true){
            course.setState(1);
        }else if (dto.isState()==false){
            course.setState(0);
        }
        course.setCreationDate(dto.getCreationDate());

        schedule.setIdSchedule(dto.getIdSchedule());
        schedule.setIdCourse(dto.getIdCourseSchedule());
        schedule.setIdProfessor(dto.getGetIdProfessorSchedule());
        schedule.setDay(dto.getDay());
        schedule.setStartTime(dto.getStartTime());
        schedule.setFinalTime(dto.getFinalTime());

        entity.setProfessor(professor);
        entity.setStudent(student);
        entity.setCourse(course);
        entity.setSchedule(schedule);

        return entity;
    }

    public AppointmentDTO toDTO(Appointment entity){
        AppointmentDTO dto = new AppointmentDTO();

        dto.setIdAppoitment(entity.getIdAppoitment());
        dto.setStatusApprovedDisapproved(entity.isStatusApprovedDisapproved());
        dto.setVirtualOnSite(entity.isVirtualOnSite());
        dto.setReasonForAppointment(entity.getReasonForAppointment());
        dto.setProfessorResponse(entity.getProfessorResponse());

        dto.setIdProfessor(entity.getProfessor().getIdUserProfile());
        dto.setDegree(entity.getProfessor().getDegree());

        dto.setIdStudent(entity.getStudent().getIdUserProfile());
        dto.setIdentificationCard(entity.getStudent().getIdentificationCard());
        dto.setAsip(entity.getStudent().isAsip());
        dto.setActive(entity.getStudent().isActive());

        dto.setIdCourse(entity.getCourse().getCourseId());
        dto.setName(entity.getCourse().getName());
        dto.setSemester(entity.getCourse().getSemester());
        dto.setDescription(entity.getCourse().getDescription());
        dto.setImage(entity.getCourse().getImage());
        int state=0;
        if (entity.getCourse().getState()==0){
            dto.setState(false);
        }else if (entity.getCourse().getState()==1){
            dto.setState(true);
        }
        dto.setCreationDate(entity.getCourse().getCreationDate());

        dto.setIdSchedule(entity.getSchedule().getIdSchedule());
        dto.setIdCourse(entity.getSchedule().getIdCourse());
        dto.setIdProfessor(entity.getSchedule().getIdProfessor());
        dto.setDay(entity.getSchedule().getDay());
        dto.setStartTime(entity.getSchedule().getStartTime());
        dto.setFinalTime(entity.getSchedule().getFinalTime());

        dto.setIdStudent(entity.getStudent().getIdUserProfile());
        dto.setIdCourseSchedule(entity.getSchedule().getIdCourse());
        dto.setGetIdProfessorSchedule(entity.getSchedule().getIdProfessor());

        return dto;
    }


}
