
import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class Experiment2 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Emma", 85),
                new Student("Liam", 72),
                new Student("Olivia", 90),
                new Student("Noah", 78)
        );

        List<String> filteredStudents = students.stream()
                .filter(s -> s.marks > 75)
                .sorted((s1, s2) -> Integer.compare(s2.marks, s1.marks))
                .map(s -> s.name)
                .collect(Collectors.toList());

        filteredStudents.forEach(System.out::println);
    }
}
