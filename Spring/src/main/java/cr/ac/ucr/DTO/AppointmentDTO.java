package cr.ac.ucr.DTO;

import javax.persistence.Column;
import java.util.Date;

public class AppointmentDTO {

    private int idAppoitment;
    private int idProfessor;
    private String Degree;
    private int idStudent;

    private String identificationCard;
    private boolean isAsip;
    private boolean isActive;

    private int idCourse;
    private String name;
    private String semester;
    private String description;
    private String image;
    private boolean state;
    private Date creationDate;

    private int idSchedule;
    private int idCourseSchedule;
    private int getIdProfessorSchedule;
    private Date day;
    private Date startTime;
    private Date finalTime;

    private boolean statusApprovedDisapproved;
    private boolean virtualOnSite;
    private String reasonForAppointment;
    private String professorResponse;

    public int getIdAppoitment() { return idAppoitment; }
    public void setIdAppoitment(int idAppoitment) { this.idAppoitment = idAppoitment; }
    public int getIdProfessor() { return idProfessor; }
    public void setIdProfessor(int idProfessor) { this.idProfessor = idProfessor; }
    public String getDegree() { return Degree; }
    public void setDegree(String degree) { Degree = degree; }
    public int getIdStudent() { return idStudent; }
    public void setIdStudent(int idStudent) { this.idStudent = idStudent; }
    public String getIdentificationCard() { return identificationCard; }
    public void setIdentificationCard(String identificationCard) { this.identificationCard = identificationCard; }
    public boolean isAsip() { return isAsip; }
    public void setAsip(boolean asip) { isAsip = asip; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    public int getIdCourse() { return idCourse; }
    public void setIdCourse(int idCourse) { this.idCourse = idCourse; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public boolean isState() { return state; }
    public void setState(boolean state) { this.state = state; }
    public Date getCreationDate() { return creationDate; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }
    public int getIdSchedule() { return idSchedule; }
    public void setIdSchedule(int idSchedule) { this.idSchedule = idSchedule; }
    public int getIdCourseSchedule() { return idCourseSchedule; }
    public void setIdCourseSchedule(int idCourseSchedule) { this.idCourseSchedule = idCourseSchedule; }
    public int getGetIdProfessorSchedule() { return getIdProfessorSchedule; }
    public void setGetIdProfessorSchedule(int getIdProfessorSchedule) { this.getIdProfessorSchedule = getIdProfessorSchedule; }
    public Date getDay() { return day; }
    public void setDay(Date day) { this.day = day; }
    public Date getStartTime() { return startTime; }
    public void setStartTime(Date startTime) { this.startTime = startTime; }
    public Date getFinalTime() { return finalTime; }
    public void setFinalTime(Date finalTime) { this.finalTime = finalTime; }
    public boolean isStatusApprovedDisapproved() { return statusApprovedDisapproved; }
    public void setStatusApprovedDisapproved(boolean statusApprovedDisapproved) { this.statusApprovedDisapproved = statusApprovedDisapproved; }
    public boolean isVirtualOnSite() { return virtualOnSite; }
    public void setVirtualOnSite(boolean virtualOnSite) { this.virtualOnSite = virtualOnSite; }
    public String getReasonForAppointment() { return reasonForAppointment; }
    public void setReasonForAppointment(String reasonForAppointment) { this.reasonForAppointment = reasonForAppointment; }
    public String getProfessorResponse() { return professorResponse; }
    public void setProfessorResponse(String professorResponse) { this.professorResponse = professorResponse; }
}
