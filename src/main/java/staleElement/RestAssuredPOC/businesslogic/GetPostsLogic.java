package staleElement.RestAssuredPOC.businesslogic;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;

public class GetPostsLogic {
    
    public static void getAuthorForSinglePostNumber(String author, int postNumber){
        given()
            .contentType(ContentType.JSON)
            .queryParam("_page", "1").queryParam("_limit", "1")
        .with()
            .pathParam("post", postNumber)
        .when()
            .get(String.format("http://localhost:3004/posts/{post}"))
        .then()
            .body("author", equalTo(author))
            .statusCode(200);
    }

public static void getAuthorForAllPosts(String[] authors){
        given()
            .contentType(ContentType.JSON)
            .queryParam("_page", "1").queryParam("_limit", "3")
        .when()
            .get("http://localhost:3004/posts")
        .then()
            .body("author", containsInAnyOrder(authors))
            .statusCode(200);
    }
}
