package cr.ac.ucr.spa;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Professor",  schema = "BS_ISem_2020")
public class Professor {

    @Column(name="Id_Professor")
    private int idProfessor;

    @Column(name="Degree")
    private String degree;

    @Column(name="Id_User_Profile")
    private String idUserProfile;


    public Professor() {
    }

    public Professor(int idProfessor, String degree, String idUserProfile) {
        this.idProfessor = idProfessor;
        this.degree = degree;
        this.idUserProfile = idUserProfile;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getIdUserProfile() {
        return idUserProfile;
    }

    public void setIdUserProfile(String idUserProfile) {
        this.idUserProfile = idUserProfile;
    }

}