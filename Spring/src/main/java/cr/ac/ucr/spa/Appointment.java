package cr.ac.ucr.spa;

import javax.persistence.*;

@Entity
@Table(name="Appointment",  schema = "BS_ISem_2020")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_Appointment")
    private int idAppoitment;

    @ManyToOne
    @JoinColumn(name="Id_Professor")
    private Professor Professor=new Professor();

    @ManyToOne
    @JoinColumn(name="Id_Student")
    private Student student= new Student();

    @ManyToOne
    @JoinColumn(name="Id_Course")
    private Course course= new Course();

    @OneToOne
    @JoinColumn(name="Id_Schedule")
    private Schedule schedule= new Schedule();

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

    public Appointment(int idAppoitment, cr.ac.ucr.spa.Professor professor, Student student, Course course, Schedule schedule, boolean statusApprovedDisapproved, boolean virtualOnSite, String reasonForAppointment, String professorResponse) {
        this.idAppoitment = idAppoitment;
        Professor = professor;
        this.student = student;
        this.course = course;
        this.schedule = schedule;
        this.statusApprovedDisapproved = statusApprovedDisapproved;
        this.virtualOnSite = virtualOnSite;
        this.reasonForAppointment = reasonForAppointment;
        this.professorResponse = professorResponse;
    }

    public int getIdAppoitment() {
        return idAppoitment;
    }

    public void setIdAppoitment(int idAppoitment) {
        this.idAppoitment = idAppoitment;
    }

    public cr.ac.ucr.spa.Professor getProfessor() {
        return Professor;
    }

    public void setProfessor(cr.ac.ucr.spa.Professor professor) {
        Professor = professor;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public boolean isStatusApprovedDisapproved() {
        return statusApprovedDisapproved;
    }

    public void setStatusApprovedDisapproved(boolean statusApprovedDisapproved) {
        this.statusApprovedDisapproved = statusApprovedDisapproved;
    }

    public boolean isVirtualOnSite() {
        return virtualOnSite;
    }

    public void setVirtualOnSite(boolean virtualOnSite) {
        this.virtualOnSite = virtualOnSite;
    }

    public String getReasonForAppointment() {
        return reasonForAppointment;
    }

    public void setReasonForAppointment(String reasonForAppointment) {
        this.reasonForAppointment = reasonForAppointment;
    }

    public String getProfessorResponse() {
        return professorResponse;
    }

    public void setProfessorResponse(String professorResponse) {
        this.professorResponse = professorResponse;
    }
}
