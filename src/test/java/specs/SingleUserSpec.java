package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.*;
import static io.restassured.http.ContentType.JSON;

public class SingleUserSpec {
    public static RequestSpecification checkIdRequestSpec = with()
            .filter(withCustomTemplates())
            .log().all()
            .header("x-api-key", "reqres-free-v1")
            .contentType(JSON);

    public static ResponseSpecification getResponseSpec (int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .log(STATUS)
                .log(BODY)
                .build();
    }

    public static ResponseSpecification checkIdResponseSpec = getResponseSpec(200);
    public static ResponseSpecification checkBodyResponseSpec = getResponseSpec(200);
    public static ResponseSpecification errorResponseSpec = getResponseSpec(404);


}
