package kz.magnum.warehouse;

// Қарапайым тауар
public class StandardProduct extends Product {
    public StandardProduct(int id, String name, double price, int quantity, Category category, Supplier supplier) {
        super(id, name, price, quantity, category, supplier);
    }

    @Override
    public String getDetails() {
        return "ID: " + getId() + " | " + getName() + " | Бағасы: " + getPrice() + 
               " | Саны: " + getQuantity() + " | Санат: " + getCategory().getCategoryName();
    }
}