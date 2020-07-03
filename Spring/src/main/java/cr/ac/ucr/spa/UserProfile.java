package cr.ac.ucr.spa;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="User_Profile",  schema = "BS_ISem_2020")
@Inheritance (strategy = InheritanceType.JOINED)
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_User_Profile")
    private int idUserProfile;

    @Column(name="Username")
    @NotNull
    private String username;

    @Column(name="Password")
    @NotNull
    private String password;

    @Column(name="User_Photo")
    @NotNull
    private String userPhoto;

    @Column(name="Interests")
    @NotNull
    private String interests;

    @Column(name="Email")
    @NotNull
    private String email;

    @Column(name="Is_Admin")
    @NotNull
    private boolean admin;

    @Column(name="Is_Enable")
    @NotNull
    private boolean isEnable;

    @ManyToOne
    @JoinColumn (name="Id_Canton")
    private Canton canton = new Canton();

    @ManyToOne
    @JoinColumn(name="Id_Province")
    private Province province = new Province();

    @ManyToOne
    @JoinColumn(name="Id_District")
    private District district= new District();

    @Column(name="Creation_Date")
    @NotNull
    private Date creationDate;


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

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
