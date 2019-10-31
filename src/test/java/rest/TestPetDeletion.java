package rest;

import helpers.RestApiTestBase;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPetDeletion extends RestApiTestBase {

    @Test
    @Tag("Pet")
    public void shouldRemovePetFromTheStore(){
        int petId = faker.number().numberBetween(0,999);
        createPetWithId(petId);
        removePetFromTheStoreById(petId);
        JsonPath response = getPetFromTheStoreById(petId,404);
        assertEquals(response.getInt("code"), 1);
        assertEquals(response.getString("type"), "error");
        assertEquals(response.getString("message"), "Pet not found");
    }
}
