package tests01;

import org.testng.annotations.Test;
import tests01.pojo.dummyAPI.Employee;
import tests01.pojo.dummyAPI.Employee2;
import tests01.pojo.gorest.User;
import tests01.pojo.jsonplaceholder.Comments;
import tests01.pojo.jsonplaceholder.Post;
import tests01.pojo.sdetCourse.Sdetcourse;

import static io.restassured.RestAssured.*;

public class ag_DeserializationPOJO {
    //NOTE: BASIC ----------------------
    @Test(description = "Basic deserialization, using one POJO")
    void test01(){
        Post post = given().get("https://jsonplaceholder.typicode.com/posts/1").as(Post.class);

        System.out.println(post.getUserId());
        System.out.println(post.getId());
        System.out.println(post.getTitle());
        System.out.println(post.getBody());
    }

    @Test(description = "CLASS TASK - Basic deserialization")
    void test011(){
        Comments comments = given().get("https://jsonplaceholder.typicode.com/comments/1").as(Comments.class);

        System.out.println(comments.getPostId());
        System.out.println(comments.getId());
        System.out.println(comments.getName());
        System.out.println(comments.getEmail());
        System.out.println(comments.getBody());
    }

    //NOTE: BASIC-COMPLEX ------------------------

    @Test(description = "Basic-Complex - Deserialization, Need to create 2 POJOS: Employee.class and EmployeeData.class")
    void test02(){
        Employee employee = given().get("http://dummy.restapiexample.com/api/v1/employee/1").as(Employee.class);
        System.out.println(employee.toString());
    }

    @Test(description = "CLASS TASK")
    void test021(){
        User user = given().get("https://gorest.co.in/public-api/users/14").as(User.class);
        System.out.println(user.toString());
    }

    //NOTE: MORE-COMPLEX ----------------------
    @Test(description = "more-complex deserialization, Need to create 2 POJOS: Sdetcourse.class and Course.class")
    void test03(){
        Sdetcourse sdetcourse = given()
                .queryParam("name", "Selenium course")
                .queryParam("name", "Java course")
                .get("https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse")
                .as(Sdetcourse.class);

        System.out.println(sdetcourse.getData().get(0).get_id());
        System.out.println(sdetcourse.getData().get(0).getDuration());
        System.out.println(sdetcourse.getData().get(0).getId());
        System.out.println(sdetcourse.getData().get(0).getName());
        System.out.println(sdetcourse.getData().get(0).get__v());

        System.out.println(sdetcourse.getData().get(1).getName());
    }

}
