package kz.magnum.warehouse;

import java.time.LocalDate;
import java.util.Scanner;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        // Деректерді дайындау
        Warehouse magnumWarehouse = new Warehouse("Magnum Қойма Жүйесі");
        InventoryReport report = new InventoryReport();
        Scanner scanner = new Scanner(System.in);

        Category food = new Category("Азық-түлік");
        Supplier milkSupplier = new Supplier("Айналайын", "87011234567");

        // Бастапқы тауарлар (HashMap қолданудың орнына қарапайым бағдарлама үшін осылай жасадық)
        magnumWarehouse.addProduct(new StandardProduct(1, "Алма", 450.0, 100, food, milkSupplier));
        magnumWarehouse.addProduct(new PerishableProduct(2, "Сүт", 350.0, 50, food, milkSupplier, LocalDate.now().plusDays(5)));
        magnumWarehouse.addProduct(new PerishableProduct(3, "Йогурт", 200.0, 20, food, milkSupplier, LocalDate.now().minusDays(2)));

        boolean running = true;
        
        while (running) {
            System.out.println("Мәзір:");
            System.out.println("1. Есептілікті құру (UML Sequence бойынша)");
            System.out.println("2. Тауарды жою (Exception-ды тексеру)");
            System.out.println("3. Деректерді CSV-ге сақтау");
            System.out.println("4. Деректерді CSV-ден жүктеу");
            System.out.println("0. Шығу");
            System.out.print("Таңдауыңыз: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    report.generateReport(magnumWarehouse);
                    break;
                case 2:
                    System.out.print("Жоятын тауардың ID-ін енгізіңіз: ");
                    int id = scanner.nextInt();
                    try {
                        magnumWarehouse.removeProduct(id);
                    } catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage()); // Exception хендлинг
                    }
                    break;
                case 3:
                    FileManager.saveToCSV(magnumWarehouse, "products.csv");
                    break;
                case 4:
                    FileManager.loadFromCSV(magnumWarehouse, "products.csv");
                    break;
                case 0:
                    running = false;
                    System.out.println("Бағдарлама тоқтатылды.");
                    break;
                default:
                    System.out.println("Қате таңдау! 0-4 арасындағы санды енгізіңіз.");
            }
        }
        scanner.close();
    }
}