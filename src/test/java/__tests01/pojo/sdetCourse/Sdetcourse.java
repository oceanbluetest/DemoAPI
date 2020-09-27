package __tests01.pojo.sdetCourse;

import java.util.List;

public class Sdetcourse {
    List<Course> data;

    public Sdetcourse(){

    }

    public Sdetcourse(List<Course> courseList) {
        this.data = courseList;
    }

    public List<Course> getData() {
        return data;
    }

    public void setData(List<Course> data) {
        this.data = data;
    }

}
