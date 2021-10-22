package staleElement.RestAssuredPOC.businesslogic;

import cucumber.api.java.Before;
import staleElement.RestAssuredPOC.utilities.RestAssuredExtension;

public class TestInitialize {
    RestAssuredExtension restAssuredExtension = null;
    
    @Before
    public void testSetup(){
        restAssuredExtension = new RestAssuredExtension();
    }
}
