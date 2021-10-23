package staleElement.RestAssuredPOC.stepdef;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import staleElement.RestAssuredPOC.utilities.RestAssuredExtension;

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

    @And("^I perform GET operation with path parameter for address \"([^\"]*)\"$")
    public void iPerformGETOperationWithPathParameterForAddress(String url, DataTable table) throws Throwable {
        List<List<String>> data = table.raw();

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("id", data.get(1).get(0));

        //response = RestAssuredExtension.GetWithQueryParamsWithToken(url, pathParams, response.getBody().jsonPath().get("access_token"));

        // EARestAssuredV2 eaRestAssuredV2 = new EARestAssuredV2(url,APIConstant.ApiMethods.GET,token);
        // response = eaRestAssuredV2.ExecuteWithQueryParams(queryParams);
    }
    
}
