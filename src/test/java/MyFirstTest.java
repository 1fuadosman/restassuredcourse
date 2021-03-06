import config.EndPoint;
import config.TestConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class MyFirstTest extends TestConfig {

    @Test
    public void myFirstTest() {
        given().
        when().get("videogames/1").
        then().
                log().
                ifValidationFails();

    }

    @Test
    public void getAllGames() {
        when().get(EndPoint.VIDEOGAMES);
    }


}
