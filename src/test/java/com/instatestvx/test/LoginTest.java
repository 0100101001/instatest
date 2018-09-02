package com.instatestvx.test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author dnikiforov
 * @project instatest
 */
public class LoginTest {
  @Test(description = "Test  web api service authorization  with incorrect user credentials")
  @Severity(SeverityLevel.CRITICAL)
  public void loginWithIncorrectCredentials() throws IOException {
    String expectedJson =
        new String(Files.readAllBytes(Paths.get("src/test/resources/data/401.json")));

    ResponseBody responseBody =
        given()
            .auth()
            .preemptive()
            .basic("hello@world.com", "12345678")
            .expect()
            .statusCode(401)
            .and()
            .contentType("application/json")
            .and()
            .response()
            .when()
            .post("http://instatestvx.me");

    assertThat(responseBody.asString()).isEqualTo(expectedJson);
  }
}
