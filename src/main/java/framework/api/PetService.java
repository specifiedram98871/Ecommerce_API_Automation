package framework.api;

import framework.utils.JsonUtils;
import framework.utils.RandomUtils;
import framework.utils.ConfigReader;
import io.restassured.response.Response;
import org.json.JSONObject;


import static io.restassured.RestAssured.given;

public class PetService {

    String baseUrl = ConfigReader.getProperty("petSwaggerUrl");

    public Response addPet(String url) {

        JSONObject json = JsonUtils.getJsonFromFile(url);

        json.put("id",RandomUtils.generateId());

        return given()
                .contentType("application/json")
                .body(json.toString())
                .post(baseUrl + "/pet");
    }
    // to retrive pet by status
    public Response getPetsByStatus(String name, String status) {

        return given()
                .queryParam("status", status + "," + name)
                .when()
                .get(baseUrl + "/pet/findByStatus");
    }
}