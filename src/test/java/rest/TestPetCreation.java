package rest;

import helpers.RestApiTestBase;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPetCreation extends RestApiTestBase {

    @Test
    @Tag("Pet")
    public void shouldAddNewPetToTheStore(){
        int petId = faker.number().numberBetween(0,999);
        createPetWithId(petId);
        JsonPath response = getPetFromTheStoreById(petId, 200);
        assertEquals(response.getInt("id"), petId);
    }
}
