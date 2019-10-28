package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Order {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private OrderStatus status;
    private boolean complete;
}
