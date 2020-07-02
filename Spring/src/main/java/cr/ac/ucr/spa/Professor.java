package cr.ac.ucr.spa;

import org.apache.tomcat.jni.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="Professor",  schema = "BS_ISem_2020")
public class Professor{

    @Id
    @Column(name="Id_Professor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idProfessor;

    @Column(name="Degree")
    @NotNull
    private String degree;

    @Column(name="Id_User_Profile")
    @NotNull
    private int idUserProfile;


    public Professor() {
    }

    public Professor(int idProfessor, String degree, int idUserProfile) {
        this.idProfessor = idProfessor;
        this.degree = degree;
        this.idUserProfile = idUserProfile;
    }

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

    public int getIdUserProfile() {
        return idUserProfile;
    }

    public void setIdUserProfile(int idUserProfile) {
        this.idUserProfile = idUserProfile;
    }

}
