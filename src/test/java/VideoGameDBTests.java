import config.EndPoint;
import config.TestConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class VideoGameDBTests extends TestConfig {

    @Test
    public void getAllGames() {

        given().
        when().get(EndPoint.VIDEOGAMES).
        then();
    }

    @Test
    public void createNewGameByJSON() {

        String gameBodyJson = "{\n" +
                "  \"id\": 45,\n" +
                "  \"name\": \"myNewGame\",\n" +
                "  \"releaseDate\": \"2019-05-15T21:07:29.311Z\",\n" +
                "  \"reviewScore\": 0,\n" +
                "  \"category\": \"Driving\",\n" +
                "  \"rating\": \"mature\"\n" +
                "}";

        given().
                body(gameBodyJson).
        when().
                post(EndPoint.VIDEOGAMES).
        then();
    }

    @Test
    public void updateGame() {

        String gameBodyJson = "{\n" +
                "  \"id\": 45,\n" +
                "  \"name\": \"myUpdatedGame1\",\n" +
                "  \"releaseDate\": \"2019-05-15T21:07:29.311Z\",\n" +
                "  \"reviewScore\": 0,\n" +
                "  \"category\": \"Driving\",\n" +
                "  \"rating\": \"mature\"\n" +
                "}";

        given().
                body(gameBodyJson).
        when().
                put("/videogames/45").
        then();

    }

    @Test
    public void xdeleteGame() {
        given().
        when().
                delete("/videogames/45").
        then();
    }


}
