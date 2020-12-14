package rest;

import helpers.RestApiTestBase;
import io.restassured.path.json.JsonPath;
import models.Pet;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static models.OrderStatus.PLACED;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOrderCreation extends RestApiTestBase {

    @Test
    @Tag("Order")
    public void shouldPlaceOrderWithCorrectStatus(){
        int petId = faker.number().numberBetween(0,999);
        Pet createdPet = createPetWithId(petId);
        int orderId = placeOrderToBuyAPet(createdPet.getId()).getInt("id");
        JsonPath order = getOrderById(orderId);
        assertEquals(PLACED.toString(), order.getString("status"));
    }
}
