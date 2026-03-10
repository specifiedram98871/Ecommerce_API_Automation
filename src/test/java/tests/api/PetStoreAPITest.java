package tests.api;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.api.PetService;
import io.restassured.response.Response;

public class PetStoreAPITest {
    PetService petService = new PetService();
    int petId;
    String petName;
    String petStatus;
    @BeforeClass
    public void setUp() {
        petService = new PetService();
    }
    @Test(description="Verify that a user can add a pet to the store", priority = 1)
    public void testAddPet() {

        PetService petService = new PetService();

        // Add Pet
        Response addResponse = petService.addPet("src/main/resources/testdata/addPet.json");
        Assert.assertEquals(addResponse.getStatusCode(), 200);

        // Extract values  and save for next test
        petId = addResponse.jsonPath().getInt("id");
        petStatus = addResponse.jsonPath().getString("status");
        petName = addResponse.jsonPath().getString("name");
    }
    @Test(description="Verify that a user can get a pet by status", priority = 2, dependsOnMethods = "testAddPet")
    
    public void testGetPet() {
        Response getResponse = petService.getPetsByStatus(petName, petStatus);
        String responseBody = getResponse.getBody().asString();

        Assert.assertTrue(responseBody.contains(petName));
        Assert.assertTrue(responseBody.contains(String.valueOf(petId)));
    }
}