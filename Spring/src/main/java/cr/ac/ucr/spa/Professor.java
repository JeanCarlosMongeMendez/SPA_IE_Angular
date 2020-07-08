package cr.ac.ucr.spa;

import org.apache.tomcat.jni.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="Professor",  schema = "BS_ISem_2020")
@PrimaryKeyJoinColumn(referencedColumnName = "Id_User_Profile")
public class Professor extends UserProfile{

    @Column(name="Degree")
    @NotNull
    private String degree;

    @Column(name="Id_User_Profile")
    private int idUserProfile;

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
