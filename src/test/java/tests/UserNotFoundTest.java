package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.SingleUserSpec.*;

@Epic("API Тесты")
@DisplayName("Тесты для негативного запроса получения данных по пользователю")

public class UserNotFoundTest extends TestBase {


    @Test
    @Description("Тест проверяет ответ 401 при запросе пользователя с невалидным id")
    void checkStatusTest() {
        ValidatableResponse response = step("Отправка запроса", () ->
                given(checkIdRequestSpec)
                        .get("/users/23")
                        .then()
        );

        step("Проверка ответа", () -> {
            response
                    .spec(errorResponseSpec);

        });
    }
}