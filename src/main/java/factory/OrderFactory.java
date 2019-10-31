package factory;

import com.github.javafaker.Faker;
import models.Order;
import models.OrderStatus;

public class OrderFactory {

    private static Faker faker = new Faker();
    public static Order generateNewOrder(int petId){
        Order order = new Order();
        order.setPetId(petId);
        order.setQuantity(1);
        order.setStatus(OrderStatus.PLACED);
        return order;
    }

}
