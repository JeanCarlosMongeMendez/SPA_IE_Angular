package cr.ac.ucr.spa;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Student", schema = "BS_ISem_2020")
public class Student {

    private int idStudent;
    private String identificationCard;
    private int idUserProfile;
    //private boolean isAsip;
    private boolean isActive;
    private int createBy;
    private Date creationDate;

    public Student(int idStudent, String identificationCard, int idUserProfile, /*boolean isAsip,*/ boolean isActive, int createBy, Date creationDate) {
        this.idStudent = idStudent;
        this.identificationCard = identificationCard;
        //this.isAsip = isAsip;
        this.isActive = isActive;
        this.createBy = createBy;
    }

    public Student(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }

    public int getIdUserProfile() {
        return idUserProfile;
    }

    public void setIdUserProfile(int idUserProfile) {
        this.idUserProfile = idUserProfile;
    }

    /*public boolean isIsASIP() {
        return isAsip;
    }

    public void setIsASIP(boolean asip) {
        this.isAsip = asip;
    }*/

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        this.isActive = active;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createdBy) {
        this.createBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
