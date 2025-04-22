
import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class Experiment1 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 30, 50000),
                new Employee("Alice", 25, 60000),
                new Employee("Bob", 35, 45000)
        );

        employees.sort(Comparator.comparingDouble(e -> e.salary));

        employees.forEach(System.out::println);
    }
}

