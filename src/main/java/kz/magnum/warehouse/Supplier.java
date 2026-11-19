package kz.magnum.warehouse;

public class Supplier {
    private String name;
    private String phone;

    public Supplier(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getContactInfo() {
        return name + " (Тел: " + phone + ")";
    }
    
    public String getName() { return name; }
    public String getPhone() { return phone; }
}