package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import models.SingleUserModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("API Тесты")
@DisplayName("Тесты для позитивного запроса получения данных по пользователю")

public class SingleUserTests extends TestBase {


    @Test
    @Description("Тест проверяет ответ метода /users/2 со всеми логами ")
    void checkIdUserWithLogsTest() {
        SingleUserModel response = step("Отправка запроса", () ->
                given()
                        .filter(withCustomTemplates())
                        .log().all()
                        .get("/users/2")
                        .then()
                        .log().all()
                        .extract()
                        .as(SingleUserModel.class));

        step("Получение ответа", () ->
                assertThat(response.getData().getId()).isEqualTo(2));
    }

    @Test
    @Description("Тест проверяет ответ метода /users/2 с логированием body")
    void checkIdUserWithSomeLogsTest() {
        SingleUserModel authData = new SingleUserModel();
        SingleUserModel response = step("Отправка запроса", () ->
        given()
                .filter(withCustomTemplates())
                .log().all()
                .get("/users/2")
                .then()
                .log().body()
                .extract()
                .as(SingleUserModel.class));

        step("Получение ответа", () ->
        assertThat(response.getData().getId()).isEqualTo(2));
    }

    @Test
    @Description("Тест проверяет статус 200 Ок метода /users/2")
    void checkIdUserWithStatusTest() {
        SingleUserModel authData = new SingleUserModel();
        SingleUserModel response = step("Отправка запроса", () ->
        given()
                .filter(withCustomTemplates())
                .log().uri()
                .get("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract()
                .as(SingleUserModel.class));

        step("Получение ответа", () ->
        assertThat(response.getData().getId()).isEqualTo(2));
    }

}
