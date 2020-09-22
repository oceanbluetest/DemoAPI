package tests01.pojo.sdetCourse;

public class Course {
    String _id;
    String name;
    String duration;
    int id;
    int __v;

    public Course(){};

    public Course(String name, String duration, String _id, int __v) {
        this.name = name;
        this.duration = duration;
        this._id = _id;
        this.__v = __v;
    }

    public Course(String name, String duration, int id, String _id, int __v) {
        this.name = name;
        this.duration = duration;
        this.id = id;
        this._id = _id;
        this.__v = __v;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}
