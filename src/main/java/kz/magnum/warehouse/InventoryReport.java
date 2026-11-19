package kz.magnum.warehouse;

public class InventoryReport implements Reportable {
    
    // Use Case: Есептілікті құру
    @Override
    public void generateReport(Warehouse warehouse) {
        System.out.println("\n===== " + warehouse.getName().toUpperCase() + " БОЙЫНША ЕСЕП =====");
        if (warehouse.getProducts().isEmpty()) {
            System.out.println("Қойма бос.");
            return;
        }
        
        for (Product product : warehouse.getProducts()) {
            System.out.println(product.getDetails());
        }
        System.out.println("=========================================\n");
    }
}