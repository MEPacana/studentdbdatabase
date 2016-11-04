import java.io.Serializable;

/**
 * Created by User on 11/4/2016.
 */
public class Course implements Serializable{
    public String courseCode;
    public String courseDescription;
    public Course (){}

    public Course(String courseCode, String courseDescription) {
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
}
