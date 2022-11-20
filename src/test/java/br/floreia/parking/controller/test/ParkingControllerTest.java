package br.floreia.parking.controller.test;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import br.floreia.parking.controller.dto.ParkingCreateDTO;
import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingControllerTest {
  @LocalServerPort
  private int RANDOM_PORT;

  @BeforeEach
  public void setupTest() {
    RestAssured.port = RANDOM_PORT;
  }

  @Test
  void whenFindAllThenCheckResult() {
    RestAssured.given()
      .when()
      .get("/parking")
      .then()
        .statusCode(HttpStatus.OK.value());
  }
  
  @Test
  void create() {
    var createDTO = new ParkingCreateDTO();
    createDTO.setColor("ROSA");
    createDTO.setLicense("WRT-5555");
    createDTO.setModel("Logan");
    createDTO.setState("MG");

    RestAssured.given()
        .when()
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .body(createDTO)
      .post("/parking")
      .then()
      .statusCode(HttpStatus.CREATED.value())
      .body("license", Matchers.equalTo("WRT-5555"))
      .body("color", Matchers.equalTo("ROSA"))
      .body("model", Matchers.equalTo("Logan"))
      .body("state", Matchers.equalTo("MG"));


  }
}
