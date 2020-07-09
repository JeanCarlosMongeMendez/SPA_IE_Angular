package cr.ac.ucr.spa;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Schedule",  schema = "BS_ISem_2020")
public class Schedule {

    @Column(name="id_Schedule")
    private int idSchedule;

    @Column(name="Id_Course")
    private int idCourse;

    @Column(name="Id_Professor")
    private int idProfessor;

    @Column(name="Day")
    private Date day;

    @Column(name="Start_Time")
    private Date startTime;

    @Column(name="Final_Time")
    private Date finalTime;

    public Schedule() {
    }

    public Schedule(int idSchedule, int idCourse, int idProfessor, Date day, Date startTime, Date finalTime) {
        this.idSchedule = idSchedule;
        this.idCourse = idCourse;
        this.idProfessor = idProfessor;
        this.day = day;
        this.startTime = startTime;
        this.finalTime = finalTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(Date finalTime) {
        this.finalTime = finalTime;
    }
}
