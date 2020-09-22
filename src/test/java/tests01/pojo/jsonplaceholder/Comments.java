package tests01.pojo.jsonplaceholder;

public class Comments {
    int postId;
    int id;
    String name;
    String email;
    String body;

    public Comments(){}

    public Comments(int userId, int id, String title, String body, String email) {
        this.postId = userId;
        this.id = id;
        this.name = title;
        this.body = body;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
