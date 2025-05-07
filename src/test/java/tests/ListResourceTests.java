package tests;

import models.ListResourceModel;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListResourceTests extends TestBase {
    @Test
    void checkListWithStatusTest() {
        given()
                .log().uri()
                .get("/unknown")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    void checkTotalWithLogsTest() {

        ListResourceModel response = given()
                .log().all()
                .get("/unknown")

        .then()
                .log().all()
                // .body("total", is(12));
                .extract().as(ListResourceModel.class);

        assertEquals(12, response.getTotal());
    }
}
