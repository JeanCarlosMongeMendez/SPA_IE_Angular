package cr.ac.ucr.spa;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="Course",  schema = "BS_ISem_2020")
public class Course {

    @Column(name="Course_Id")
    private int courseId;
    @Column(name="Name")
    private String name;
    @Column(name="State", nullable=true)
    private int state;
    @Column(name="Semestrer")
    private String semester;
    @Column(name="Description", nullable=true)
    private String description;
    @Column(name="Image", nullable=true)
    private String image;
    @Column(name="Creation_Date", nullable=true)
    private Date creationDate;

    public Course() { }

    public Course(int courseId, String name, int state, String semester, String description, String image, Date creationDate) {
        this.courseId = courseId;
        this.name = name;
        this.state = state;
        this.semester = semester;
        this.description = description;
        this.image = image;
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

    public Date getCreationDate() {return creationDate;}

    public void setCreationDate(Date creationDate) {this.creationDate = creationDate;}
}
