package cr.ac.ucr.spa;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="[BS_ISem_2020].[Course]")
public class Course {

    private int courseId;
    private String name;
    private int state;
    private String semester;
    private String description;
    private String image;
    private int createBy;
    private Date creationDate;

    public Course() { }

    public Course(int courseId, String name, int state, String semester, String description, String image, int createdBy, Date creationDate) {
        this.courseId = courseId;
        this.name = name;
        this.state = state;
        this.semester = semester;
        this.description = description;
        this.image = image;
        this.createBy = createdBy;
        this.creationDate = creationDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCourseId() {return courseId;}

    public void setCourseId(int courseId) {this.courseId = courseId;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getState() {return state;}

    public void setState(int state) {this.state = state;}

    public String getSemester() {return semester;}

    public void setSemester(String semester) {this.semester = semester; }

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public String getImage() {return image;}

    public void setImage(String image) {this.image = image;}

    public int getCreatedBy() {return createBy;}

    public void setCreatedBy(int createdBy) {this.createBy = createdBy;}

    public Date getCreationDate() {return creationDate;}

    public void setCreationDate(Date creationDate) {this.creationDate = creationDate;}
}
