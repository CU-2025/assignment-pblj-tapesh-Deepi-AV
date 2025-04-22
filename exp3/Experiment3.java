import java.util.*;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}
class Course {
    private String name;
    private int maxEnrollment;
    private List<String> prerequisites;
    private List<String> enrolledStudents;

    public Course(String name, int maxEnrollment, List<String> prerequisites) {
        this.name = name;
        this.maxEnrollment = maxEnrollment;
        this.prerequisites = prerequisites;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public void enrollStudent(String studentName, List<String> completedCourses)
            throws CourseFullException, PrerequisiteNotMetException {
        if (enrolledStudents.size() >= maxEnrollment) {
            throw new CourseFullException("Error: CourseFullException - " + name + " is full.");
        }

        for (String prerequisite : prerequisites) {
            if (!completedCourses.contains(prerequisite)) {
                throw new PrerequisiteNotMetException(
                        "Error: PrerequisiteNotMetException - Complete " + prerequisite + " before enrolling in " + name + ".");
            }
        }

        enrolledStudents.add(studentName);
        System.out.println("Success: " + studentName + " enrolled in " + name + ".");
    }
}



public class Experiment3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create courses
        Course advancedJava = new Course("Advanced Java", 2, Arrays.asList("Core Java"));
        Course coreJava = new Course("Core Java", 5, new ArrayList<>());

        Map<String, Course> courses = new HashMap<>();
        courses.put("Advanced Java", advancedJava);
        courses.put("Core Java", coreJava);

        // Enroll a student
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enroll in Course: ");
        String courseName = scanner.nextLine();

        if (!courses.containsKey(courseName)) {
            System.out.println("Error: Course " + courseName + " does not exist.");
            return;
        }

        Course course = courses.get(courseName);

        System.out.print("Completed courses (comma-separated): ");
        String completedCoursesInput = scanner.nextLine();
        List<String> completedCourses = Arrays.asList(completedCoursesInput.split("\\s*,\\s*"));

        try {
            course.enrollStudent(studentName, completedCourses);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println(e.getMessage());
        }
    }
}
