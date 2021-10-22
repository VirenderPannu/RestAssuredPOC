package staleElement.RestAssuredPOC.stepdef;

import java.net.URISyntaxException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import staleElement.RestAssuredPOC.utilities.RestAssuredExtension;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetPostsSteps {

    private static ResponseOptions<Response> response;
    
    @Given("^I perform GET operation for \"([^\"]*)\"$")
    public void iPerformGetOperationFor(String url) throws URISyntaxException{
        // given().contentType(ContentType.JSON);
        response = RestAssuredExtension.GetOps(url);
    } 

    @And("^I perform GET for the post number \"([^\"]*)\"$")
    public void iPerformGetForThePostNumber(String postNumber){
        when()
            .get(String.format("http://localhost:3004/posts/%s", postNumber))
        .then()
            .body("author", equalTo("virender")).statusCode(200);
    } 

    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorNameAs(String authorName) throws Throwable{
        assertThat(response.getBody().jsonPath().get("author"), hasItem(authorName));
    } 

    @And("^I perform GET for the posts \"([^\"]*)\"$")
    public void iPerformGetForThePosts(String[] authors){
        given()
            .contentType(ContentType.JSON)
        .when()
            .get("http://localhost:3004/posts/")
        .then()
            .body("author", containsInAnyOrder(authors))
            .statusCode(200);
    } 

}
