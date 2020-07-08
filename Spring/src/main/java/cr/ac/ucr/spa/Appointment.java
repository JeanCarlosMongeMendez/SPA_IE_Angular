package cr.ac.ucr.spa;

import javax.persistence.*;

@Entity
@Table(name="Appointment",  schema = "BS_ISem_2020")
public class Appointment {

    @Column(name="Id_Appointment")
    private int idAppoitment;
    @Column(name="Id_Professor")
    private int idProfessor;
    @Column(name="Id_Student")
    private int idStudent;
    @Column(name="Id_Course")
    private int idCourse;
    @Column(name="Id_Schedule")
    private int idSchedule;
    @Column(name="Status_Approved_Disapproved")
    private boolean statusApprovedDisapproved;
    @Column(name="Virtual_On_Site")
    private boolean virtualOnSite;
    @Column(name="Reason_For_Appointment")
    private String reasonForAppointment;
    @Column(name="Professor_Response")
    private String professorResponse;

    public Appointment() {
    }

    public Appointment(int idAppoitment, int idProfessor, int idStudent, int idCourse, int idSchedule, boolean statusApprovedDisapproved, boolean virtualOnSite, String reasonForAppointment, String professorResponse) {
        this.idAppoitment = idAppoitment;
        this.idProfessor = idProfessor;
        this.idStudent = idStudent;
        this.idCourse = idCourse;
        this.idSchedule = idSchedule;
        this.statusApprovedDisapproved = statusApprovedDisapproved;
        this.virtualOnSite = virtualOnSite;
        this.reasonForAppointment = reasonForAppointment;
        this.professorResponse = professorResponse;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdAppoitment() { return idAppoitment; }

    public void setIdAppoitment(int idAppoitment) { this.idAppoitment = idAppoitment; }

    public int getIdProfessor() { return idProfessor; }

    public void setIdProfessor(int idProfessor) { this.idProfessor = idProfessor; }

    public int getIdStudent() { return idStudent; }

    public void setIdStudent(int idStudent) { this.idStudent = idStudent; }

    public int getIdCourse() { return idCourse; }

    public void setIdCourse(int idCourse) { this.idCourse = idCourse; }

    public int getIdSchedule() { return idSchedule; }

    public void setIdSchedule(int idSchedule) { this.idSchedule = idSchedule; }

    public boolean isStatusApprovedDisapproved() { return statusApprovedDisapproved; }

    public void setStatusApprovedDisapproved(boolean statusApprovedDisapproved) { this.statusApprovedDisapproved = statusApprovedDisapproved; }

    public boolean isVirtualOnSite() { return virtualOnSite; }

    public void setVirtualOnSite(boolean virtualOnSite) { this.virtualOnSite = virtualOnSite; }

    public String getReasonForAppointment() { return reasonForAppointment; }

    public void setReasonForAppointment(String reasonForAppointment) { this.reasonForAppointment = reasonForAppointment; }

    public String getProfessorResponse() { return professorResponse; }

    public void setProfessorResponse(String professorResponse) { this.professorResponse = professorResponse; }

}
