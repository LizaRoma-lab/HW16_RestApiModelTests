package specs;

import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.specification.*;


import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class ListSpec {
    public static RequestSpecification listRequestSpec = with()

            .filter(withCustomTemplates())
            .log().uri()
            .header("x-api-key", "reqres-free-v1")
            .contentType(JSON);


    public static ResponseSpecification listResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(STATUS)
            .log(BODY)
            .build();


}
