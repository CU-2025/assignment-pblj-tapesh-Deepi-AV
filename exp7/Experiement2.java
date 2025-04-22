
import java.sql.*;
import java.util.Scanner;

public class Experiement2  {
    static final String URL = "jdbc:mysql://localhost:3308/javaclass";
    static final String USER = "root";
    static final String PASSWORD = "deep@21";
    static Connection conn;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            while (true) {
                System.out.println("\n1. Add Product\n2. View Products\n3. Update Product\n4. Delete Product\n5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> addProduct();
                    case 2 -> viewProducts();
                    case 3 -> updateProduct();
                    case 4 -> deleteProduct();
                    case 5 -> {
                        conn.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice! Try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addProduct() {
        try {
            System.out.print("Enter Product Name: ");
            String name = scanner.next();
            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();

            String query = "INSERT INTO Product (ProductName, Price, Quantity) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                conn.setAutoCommit(false);
                pstmt.setString(1, name);
                pstmt.setDouble(2, price);
                pstmt.setInt(3, quantity);
                pstmt.executeUpdate();
                conn.commit();
                System.out.println("Product added successfully!");
            }
        } catch (SQLException e) {
            rollbackTransaction();
        }
    }

    private static void viewProducts() {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Product")) {
            while (rs.next()) {
                System.out.println(rs.getInt("ProductID") + " | " +
                        rs.getString("ProductName") + " | " +
                        rs.getDouble("Price") + " | " +
                        rs.getInt("Quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateProduct() {
        try {
            System.out.print("Enter Product ID to update: ");
            int id = scanner.nextInt();
            System.out.print("Enter new Price: ");
            double price = scanner.nextDouble();

            String query = "UPDATE Product SET Price = ? WHERE ProductID = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                conn.setAutoCommit(false);
                pstmt.setDouble(1, price);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                conn.commit();
                System.out.println("Product updated successfully!");
            }
        } catch (SQLException e) {
            rollbackTransaction();
        }
    }

    private static void deleteProduct() {
        try {
            System.out.print("Enter Product ID to delete: ");
            int id = scanner.nextInt();

            String query = "DELETE FROM Product WHERE ProductID = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                conn.setAutoCommit(false);
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
                conn.commit();
                System.out.println("Product deleted successfully!");
            }
        } catch (SQLException e) {
            rollbackTransaction();
        }
    }

    private static void rollbackTransaction() {
        try {
            conn.rollback();
            System.out.println("Transaction rolled back!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

