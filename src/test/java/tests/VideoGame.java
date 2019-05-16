package tests;

import config.EndPoint;
import config.TestConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class VideoGame extends TestConfig {



    @Test(priority = 1)
    public void getAllGames() {
        given().
        when().get(EndPoint.VIDEOGAMES).
        then();
    }

    @Test(priority = 2)
    public void createNewGameByJSON() {
        String gameBodyJson = "{\n" +
                "  \"id\": " + testID  + ",\n" +
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

    @Test(priority = 3)
    public void updateGame() {
        String gameBodyJson = "{\n" +
                "  \"id\": " + testID  + ",\n" +
                "  \"name\": \"myUpdateGame\",\n" +
                "  \"releaseDate\": \"2019-05-15T21:07:29.311Z\",\n" +
                "  \"reviewScore\": 0,\n" +
                "  \"category\": \"Driving\",\n" +
                "  \"rating\": \"mature\"\n" +
                "}";

        given().
                body(gameBodyJson).
        when().
                put(EndPoint.VIDEOGAMES + testID).
        then();
    }

    @Test
    public void deleteGame() {
        given().
        when().
                delete(EndPoint.VIDEOGAMES + testID).
        then();
    }


}
