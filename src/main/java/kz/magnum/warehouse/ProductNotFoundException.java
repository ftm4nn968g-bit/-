package kz.magnum.warehouse;

// Тауар табылмаған кездегі қателік классы
public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}