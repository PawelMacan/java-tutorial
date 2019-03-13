package tutorial.model;

import lombok.Data;

@Data
public class Bill {
    private int quantity;
    private double price;
    private double vatRate;
}
