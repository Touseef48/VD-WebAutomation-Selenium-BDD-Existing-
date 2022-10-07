package preReq;


import io.restassured.response.Response;

import java.sql.SQLException;
import general.EnvGlobals;

import static io.restassured.RestAssured.given;

public class TestPage {
    public TestPage(){}

//    **********************************************    API Calls   **********************************************

    public static Response saveAsSystems(String name, String randName, int systemId) throws SQLException {
        EnvGlobals.response =
                given()
                        .headers("Authorization", "exampleAuth", "Content-Type", "content", "referer", "reference")
                        .body(RequestPayloads.saveAsSystem(name, randName, systemId)).with().contentType("application/json")
//                        .log().all()
                .when()
                        .post("/save-as-system")
                .then()
//                        .log().all()
                        .assertThat().statusCode(403)
                .extract()
                        .response();

        return EnvGlobals.response;
    }

    public static Response getSystems() {
        EnvGlobals.response =
                given()
                        .headers("Authorization", "exampleAuth", "referer", "reference")
//                        .log().all()
                .when()
                        .get("/app/systems")
                .then()
//                        .log().all()
                        .assertThat().statusCode(200).and()
                .extract()
                        .response();

        return EnvGlobals.response;
    }


}
