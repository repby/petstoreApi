package helpers;

import com.github.javafaker.Faker;
import factory.OrderFactory;
import factory.PetFactory;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.Order;
import models.Pet;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;

public class RestApiTestBase {
    protected static RequestSpecification defaultRequest;
    protected static ResponseSpecification defaultResponse;
    protected Gson gson = new Gson();
    public Faker faker = new Faker();

    @BeforeAll
    public static void beforeClass() {
        RestAssuredHelper configurator = new RestAssuredHelper();
        defaultRequest = configurator.requestSpec();
        defaultResponse = configurator.responseSpec();

    }

    public Pet createPetWithId(int petId){
        Pet pet = PetFactory.generatePetWithId(petId);
        given()
                .spec(defaultRequest).log().all()
                .body(gson.toJson(pet))
                .when()
                .post("/pet")
                .then()
                .log().all()
                .spec(defaultResponse);
        return pet;
    }

    public JsonPath getPetFromTheStoreById(int petId, int statusCode){
        return given()
                .spec(defaultRequest).log().all()
                .when()
                .get("/pet/"+petId)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .jsonPath();
    }

    public JsonPath removePetFromTheStoreById(int petId){
         return given()
                 .spec(defaultRequest)
                 .when()
                 .delete("/pet/"+petId)
                 .then()
                 .log().all()
                 .statusCode(200).extract().jsonPath();
    }

    public JsonPath placeOrderToBuyAPet(int petId){
        Order order = OrderFactory.generateNewOrder(petId);
        return given()
                .spec(defaultRequest)
                .body(gson.toJson(order))
                .log().all()
                .when()
                .post("/store/order")
                .then().log().all()
                .extract().jsonPath();
    }
    public JsonPath getOrderById(int orderId){
        return given()
                .spec(defaultRequest)
                .when()
                .get("/store/order/" + orderId)
                .then().log().all()
                .extract().jsonPath();
    }

}
