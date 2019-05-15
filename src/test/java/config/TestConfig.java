package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

public class TestConfig {

    public static RequestSpecification videoGame_requestSpec;
    public static RequestSpecification football_requestSpec;
    public static ResponseSpecification responseSpec;

    @BeforeClass
    public static void setup() {

        //this will reflect the specific api. Below is videoGame_requestSpec, but we can have multiple api's that needs setting
        //and they can be called in the different tests
        videoGame_requestSpec = new RequestSpecBuilder().
                setBaseUri("http://localhost").
                setPort(8080).
                setBasePath("/app/").
                addHeader("Content-Type", "application/json").
                addHeader("Accept", "application/json").
                build();

        football_requestSpec = new RequestSpecBuilder().
                setBaseUri("http://api.football-data.org").
                setBasePath("v1").
                addHeader("X=Auth-Token","").
                build();

        /*
        Below you set the request for all test classes, alternatively if you want to specify individually then
        on the given step you can have the following template given().spec(videoGame_requestSpec)
         */
        RestAssured.requestSpecification = videoGame_requestSpec;

        //Here the Response is going to have similar responses irrespective of api and so we use a general
        //responSpec name

        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(201).
                build();

        /*
        Below you set the response for all test classes, alternatively if you want to specify individually then
        on the then step you can have the following template then().spec(responseSpec)
         */
        RestAssured.responseSpecification = responseSpec;
    }
}
