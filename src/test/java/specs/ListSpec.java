package specs;

import com.sun.net.httpserver.Request;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import tests.TestBase;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class ListSpec {
    public static RequestSpecification listRequestSpec = with()
//            .config(RestAssuredConfig.config()
//                    .sslConfig(new SSLConfig().relaxedHTTPSValidation()))
            .filter(withCustomTemplates())
            .log().uri()
            .header("x-api-key", "reqres-free-v1")
            .contentType(JSON);

//            .baseUri("https://reqres.in")
//            .basePath("/api/unknown");

    public static ResponseSpecification listResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(STATUS)
            .log(BODY)
            .build();
}
