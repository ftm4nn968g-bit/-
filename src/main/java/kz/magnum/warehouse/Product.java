package kz.magnum.warehouse;

// Абстракт класс. Одан нақты тауарлар (мысалы, тез бұзылатын) мұрагерлік алады
public abstract class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private Category category;
    private Supplier supplier;

    public Product(int id, String name, double price, int quantity, Category category, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.supplier = supplier;
    }

    // Инкапсуляция: айнымалылар private, тек getter/setter арқылы қатынасамыз
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public Category getCategory() { return category; }
    public Supplier getSupplier() { return supplier; }

    public void updateQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    // Полиморфизм: бұл әдісті әр тауар өзінше қайта жазады (override)
    public abstract String getDetails();
}