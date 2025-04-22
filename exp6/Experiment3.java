
import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
}

public class Experiment3 {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 75000),
                new Product("Smartphone", "Electronics", 50000),
                new Product("Table", "Furniture", 10000),
                new Product("Chair", "Furniture", 5000)
        );

        // Group products by category and find the most expensive product in each category
        Map<String, Product> mostExpensiveProduct = products.stream()
                .collect(Collectors.toMap(
                        p -> p.category,
                        p -> p,
                        (p1, p2) -> p1.price > p2.price ? p1 : p2
                ));

        System.out.println("Most Expensive Product per Category:");
        mostExpensiveProduct.forEach((category, product) ->
                System.out.println(category + ": " + product.name + " (" + product.price + ")")
        );

        // Calculate the average price of all products
        double averagePrice = products.stream()
                .mapToDouble(p -> p.price)
                .average()
                .orElse(0);

        System.out.println("\nAverage Price of All Products: " + averagePrice);
    }
}

