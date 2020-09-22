package tests01.pojo.gorest;

public class UserData {
    int id;
    String name;
    String email;
    String gender;
    String status;
    String created_at;
    String updated_at;

    public UserData(){}

    public UserData(int id, String name, String email, String gender, String status, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "\n\t id = " + id +
                "\n\t name = '" + name + '\'' +
                "\n\t email = '" + email + '\'' +
                "\n\t gender = '" + gender + '\'' +
                "\n\t status = '" + status + '\'' +
                "\n\t created_at = '" + created_at + '\'' +
                "\n\t updated_at = '" + updated_at;
    }
}
