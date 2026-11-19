package kz.magnum.warehouse;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class FileManager {
    
    // Деректерді CSV файлға сақтау
    public static void saveToCSV(Warehouse warehouse, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("ID,Name,Price,Quantity,Type\n"); // Заголовок
            for (Product p : warehouse.getProducts()) {
                String type = (p instanceof PerishableProduct) ? "Perishable" : "Standard";
                writer.write(p.getId() + "," + p.getName() + "," + p.getPrice() + "," + p.getQuantity() + "," + type + "\n");
            }
            System.out.println("Деректер сәтті сақталды: " + filename);
        } catch (IOException e) {
            System.out.println("Файлға сақтау кезінде қате кетті: " + e.getMessage());
        }
    }

    // Деректерді CSV файлдан оқу (Қарапайым нұсқа)
    public static void loadFromCSV(Warehouse warehouse, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine(); // Заголовокты өткізіп жібереміз
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                int qty = Integer.parseInt(parts[3]);
                String type = parts[4];

                // Оқу кезінде қарапайым санат/жеткізуші қосып отырамыз
                Category cat = new Category("Жалпы");
                Supplier sup = new Supplier("Белгісіз", "000");
                
                if (type.equals("Perishable")) {
                    warehouse.addProduct(new PerishableProduct(id, name, price, qty, cat, sup, LocalDate.now().plusDays(10)));
                } else {
                    warehouse.addProduct(new StandardProduct(id, name, price, qty, cat, sup));
                }
            }
            System.out.println("Деректер файлдан сәтті жүктелді!");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Файлды оқу кезінде қате кетті: " + e.getMessage());
        }
    }
}