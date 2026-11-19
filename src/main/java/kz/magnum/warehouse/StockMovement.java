package kz.magnum.warehouse;

import java.time.LocalDate;

public class StockMovement {
    private String type; // "Кіріс" немесе "Шығыс"
    private int quantity;
    private LocalDate date;

    public StockMovement(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
        this.date = LocalDate.now();
    }

    public void recordMovement() {
        System.out.println("Қозғалыс тіркелді: " + type + " - " + quantity + " дана, Күні: " + date);
    }
}