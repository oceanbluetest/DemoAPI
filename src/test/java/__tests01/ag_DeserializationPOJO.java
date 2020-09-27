package __tests01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;
import __tests01.pojo.dummyAPI.Employee;
import __tests01.pojo.gorest.User;
import __tests01.pojo.jsonplaceholder.Comments;
import __tests01.pojo.jsonplaceholder.Post;
import __tests01.pojo.sdetCourse.Sdetcourse;

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

    //NOTE: Using Gson serialize and deserialize

    @Test
    void test04(){
        //Deserialize
        String userData = "{\n" +
                "    \"code\": 200,\n" +
                "    \"meta\": null,\n" +
                "    \"data\": {\n" +
                "        \"id\": 8,\n" +
                "        \"name\": \"Shankar Acharya Esq.\",\n" +
                "        \"email\": \"shankar_acharya_esq@runolfsson.io\",\n" +
                "        \"gender\": \"Male\",\n" +
                "        \"status\": \"Active\",\n" +
                "        \"created_at\": \"2020-09-26T03:50:03.907+05:30\",\n" +
                "        \"updated_at\": \"2020-09-26T03:50:03.907+05:30\"\n" +
                "    }\n" +
                "}";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        User user = gson.fromJson(userData, User.class);
        System.out.println(user.toString());

        System.out.println(user.getData().getName());

        //Serialize
        String post = gson.toJson(user);
        System.out.println();
        System.out.println(post);
    }

}
