public class Worksheet1 {
    public static void main(String[] args) {
        int productId = 101;
        String productName = "Laptop";
        double productPrice = 75000;

        Product product = new Product(productId, productName, productPrice);

        product.displayProductDetails();
    }
}
class Product {
    // Attributes
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void displayProductDetails() {
        System.out.println("Product Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}
