package cr.ac.ucr.spa;

import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "Student", schema = "BS_ISem_2020")
@PrimaryKeyJoinColumn(referencedColumnName = "Id_User_Profile")
public class Student extends UserProfile{

    @Column(name="Id_User_Profile")
    private int idUserProfile;
    @Column(name="Identification_Card")
    @NotNull
    private String identificationCard;
    @Column(name="Is_ASIP")
    @NotNull
    private boolean isAsip;
    @Column(name="Is_Active")
    @NotNull
    private boolean isActive;

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }

    public boolean isAsip() {
        return isAsip;
    }

    public void setAsip(boolean asip) {
        isAsip = asip;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getIdUserProfile() {
        return idUserProfile;
    }

    public void setIdUserProfile(int idUserProfile) {
        this.idUserProfile = idUserProfile;
    }
}
