package cr.ac.ucr.spa;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="User_Profile",  schema = "BS_ISem_2020")
public class UserProfile {

    @Column(name="Id_User_Profile")
    private int idUserProfile;

    @Column(name="Username")
    private String username;

    @Column(name="Password")
    private String password;

    @Column(name="User_Photo")
    private String userPhoto;

    //@Column(name="Interests")
    //private String interests;

    @Column(name="Email")
    private String email;

    /*@Column(name="Is_Admin")
    private boolean admin;*/

    /*@Column(name="Is_Enable")
    private boolean isEnable;*/

    @Column(name="Id_Canton")
    private int idCanton;

    @Column(name="Id_Province")
    private int idProvince;

    @Column(name="Id_District")
    private int idDistrict;

    @Column(name="Creation_Date")
    private Date creationDate;

    public UserProfile() {
    }

    public UserProfile(int idUserProfile, String username, String password, String userPhoto, String interest, String email, boolean admin, boolean isEnable, int idCanton, int idProvince, int idDistrict, Date creationDate) {
        this.idUserProfile = idUserProfile;
        this.username = username;
        this.password = password;
        this.userPhoto = userPhoto;
        //this.interests = interest;
        this.email = email;
        //this.admin = admin;
        //this.isEnable = isEnable;
        this.idCanton = idCanton;
        this.idProvince = idProvince;
        this.idDistrict = idDistrict;
        this.creationDate = creationDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdUserProfile() {
        return idUserProfile;
    }

    public void setIdUserProfile(int idUserProfile) {
        this.idUserProfile = idUserProfile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    /*public String getInterest() {
        return interests;
    }

    public void setInterest(String interest) {
        this.interests = interest;
    }*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }*/

    /*public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }*/

    public int getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(int idCanton) {
        this.idCanton = idCanton;
    }

    public int getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(int idProvince) {
        this.idProvince = idProvince;
    }

    public int getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(int idDistrict) {
        this.idDistrict = idDistrict;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
