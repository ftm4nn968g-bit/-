package kz.magnum.warehouse;

import java.time.LocalDate;

// Тез бұзылатын тауар (Мұрагерлік)
public class PerishableProduct extends Product {
    private LocalDate expiryDate;

    public PerishableProduct(int id, String name, double price, int quantity, Category category, Supplier supplier, LocalDate expiryDate) {
        super(id, name, price, quantity, category, supplier);
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public String getDetails() {
        String status = isExpired() ? " (МЕРЗІМІ ӨТКЕН!)" : "";
        return "ID: " + getId() + " | " + getName() + " | Бағасы: " + getPrice() + 
               " | Саны: " + getQuantity() + " | Жарамдылық мерзімі: " + expiryDate + status;
    }
}