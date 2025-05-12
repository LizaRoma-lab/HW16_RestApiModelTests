package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import models.ListResourceModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.ListSpec;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.ListSpec.listRequestSpec;
import static specs.ListSpec.listResponseSpec;

@Epic("API Тесты")
@DisplayName("Тесты для списка ресурсов")

public class ListResourceTests extends TestBase {

    @Test
    @Description("Тест проверяет  ответ 200 Ок при запросе списка ресурсов")

    void checkListWithStatusTest() {
        ValidatableResponse response = step("Отправка GET запроса списка ресурсов", () ->
                given(ListSpec.listRequestSpec)
                        .when()
                        .get("/unknown")
                        .then()
        );
        step("Проверка ответа сервера", () -> {
            response
                    .spec(listResponseSpec);
        });
    }


    @Test
    @Description("Тест проверяет корректность ответа параметра total при запросе списка ресурсов")
    void checkTotalWithLogsTest() {
        ListResourceModel authData = new ListResourceModel();

        ListResourceModel response = step("Отправка запроса", () ->
                given()
                        .filter(withCustomTemplates())
                        .log().all()
                        .get("/unknown")

                        .then()
                        .log().all()
                        .extract().as(ListResourceModel.class));

        step("Проверка ответа", () ->
                assertEquals(12, response.getTotal()));
    }
}

