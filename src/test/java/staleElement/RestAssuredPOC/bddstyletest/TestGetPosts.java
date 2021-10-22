package staleElement.RestAssuredPOC.bddstyletest;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

import staleElement.RestAssuredPOC.businesslogic.GetPostsLogic;
import staleElement.RestAssuredPOC.businesslogic.TestInitialize;
import staleElement.RestAssuredPOC.utilities.RestAssuredExtension;

public class TestGetPosts extends TestInitialize {

    String[] expectedArray = {"pannu","singh","virender"};
    
    @Test
    public void verifyAuthorForSinglePostNumber(){
        GetPostsLogic.getAuthorForSinglePostNumber("virender",1);
    }
    
    @Test
    public void verifyAuthorForAllPosts(){
        GetPostsLogic.getAuthorForAllPosts(expectedArray);
    }

    @Test
    public void verifyAuthorWithSinglePostNumber() throws URISyntaxException{
        RestAssuredExtension.GetOps("/posts/1");
    }
}
