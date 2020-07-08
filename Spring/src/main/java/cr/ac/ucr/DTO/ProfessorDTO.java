package cr.ac.ucr.DTO;

import cr.ac.ucr.spa.UserProfile;
import org.apache.tomcat.jni.User;

import javax.persistence.Column;

public class ProfessorDTO  {

    private String degree;
    private UserProfile userProfile;

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
