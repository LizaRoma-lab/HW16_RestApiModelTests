package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.SingleUserSpec.*;

@Epic("API Тесты")
@DisplayName("Тесты для позитивного запроса получения данных по пользователю")

public class SingleUserTests extends TestBase {

    @Test
    @Description("Тест проверяет ответ метода /users/2 со всеми логами ")
    void checkIdUserWithLogsTest() {
        ValidatableResponse response = step("Отправка запроса", () ->
                given(checkIdRequestSpec)
                        .get("/users/2")
                        .then()
                        .spec(checkIdResponseSpec)
                );

        step("Получение ответа", () -> {
        int actualId = response.extract().path("data.id");
        assertEquals(2, actualId);
        });
    }

    @Test
    @Description("Тест проверяет ответ метода /users/2 с логированием body")
    void checkIdUserWithSomeLogsTest() {
        ValidatableResponse response = step("Отправка запроса", () ->
        given(checkIdRequestSpec)

                .get("/users/2")
                .then()
                .spec(checkBodyResponseSpec)
        );

        step("Получение ответа", () -> {
            int actualId = response.extract().path("data.id");
            assertEquals(2, actualId);
        });
    }

    @Test
    @Description("Тест проверяет статус 200 Ок метода /users/2")
    void checkIdUserWithStatusTest() {
        ValidatableResponse response = step("Отправка запроса", () ->
        given(checkIdRequestSpec)

                .get("/users/2")
                .then()
                .spec(checkBodyResponseSpec)
        );

        step("Получение ответа", () -> {
            int actualId = response.extract().path("data.id");
            assertEquals(2, actualId);
        });
    }

}
