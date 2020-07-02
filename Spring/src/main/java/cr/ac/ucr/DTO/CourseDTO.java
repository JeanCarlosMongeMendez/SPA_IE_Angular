package cr.ac.ucr.DTO;

import javax.persistence.Column;
import java.util.Date;

public class CourseDTO {

    private int courseId;
    private String name;
    private int state;
    private String semester;
    private String description;
    private String image;
    private int createBy;
    private Date creationDate;

    public int getCourseId() {return courseId;}

    public void setCourseId(int courseId) {this.courseId = courseId;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getState() {return state;}

    public void setState(int state) {this.state = state; }

    public String getSemester() {return semester;}

    public void setSemester(String semester) {this.semester = semester; }

    public String getDescription() {return description; }

    public void setDescription(String description) {this.description = description;}

    public String getImage() {return image;}

    public void setImage(String image) {this.image = image;}

    public int getCreateBy() {return createBy;}

    public void setCreateBy(int createBy) {this.createBy = createBy; }

    public Date getCreationDate() {return creationDate;}

    public void setCreationDate(Date creationDate) {this.creationDate = creationDate; }

}
