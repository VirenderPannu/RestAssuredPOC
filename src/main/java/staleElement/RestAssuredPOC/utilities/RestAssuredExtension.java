package staleElement.RestAssuredPOC.utilities;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class RestAssuredExtension {

    public static RequestSpecification request;

    public RestAssuredExtension() {
        //ARRANGE
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        RequestSpecification requestSpec = requestSpecBuilder.setBaseUri("http://localhost:3004/")
                                            .setContentType(ContentType.JSON)
                                            .build();
        request = RestAssured.given().spec(requestSpec);
    }

    public static ResponseOptions<Response> GetOps(String url) {
        new RestAssuredExtension();
        //ACT
        try {
            return request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void GetOpsWithPathParameter(String url, Map<String, String> pathParams) {
        //ACT
        request.pathParams(pathParams);
        try {
            request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
