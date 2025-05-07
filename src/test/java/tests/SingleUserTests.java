package tests;

import models.ListResourceModel;
import models.SingleUserModel;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.assertj.core.api.Assertions.assertThat;

public class SingleUserTests extends TestBase{


    @Test
    void checkIdUserWithLogsTest() {
        SingleUserModel response = given()
                .log().all()
                .get("/users/2")
                .then()
                .log().all()
                .extract()
                .as(SingleUserModel.class);

        assertThat(response.getData().getId()).isEqualTo(2);
    }

    @Test
    void checkIdUserWithSomeLogsTest() {
        SingleUserModel response = given()
                .log().all()
                .get("/users/2")
                .then()
                .log().body()
                .extract()
                .as(SingleUserModel.class);

        assertThat(response.getData().getId()).isEqualTo(2);
    }

    @Test
    void checkIdUserWithStatusTest() {
        SingleUserModel response = given()
                .log().uri()
                .get("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract()
                .as(SingleUserModel.class);

        assertThat(response.getData().getId()).isEqualTo(2);
    }

}
