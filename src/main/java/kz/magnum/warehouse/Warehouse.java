package kz.magnum.warehouse;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private String name;
    // Коллекция: ArrayList
    private List<Product> products;

    public Warehouse(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " қоймаға қосылды.");
    }

    public void removeProduct(int id) throws ProductNotFoundException {
        Product toRemove = null;
        for (Product p : products) {
            if (p.getId() == id) {
                toRemove = p;
                break;
            }
        }
        
        if (toRemove != null) {
            products.remove(toRemove);
            System.out.println("ID-і " + id + " тауар өшірілді.");
        } else {
            // Өз Exception-ды лақтыру
            throw new ProductNotFoundException("Қате! ID-і " + id + " тауар қоймада табылмады.");
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }
}