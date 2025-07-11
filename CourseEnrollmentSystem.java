import java.util.*;

class StudentEnrollment {
    String studentName, courseName;

    public StudentEnrollment(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }

    public String toString() {
        return "Student: " + studentName + ", Course: " + courseName;
    }
}

public class CourseEnrollmentSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<StudentEnrollment> enrollments = new ArrayList<>();

    static void enrollStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter course name: ");
        String course = sc.nextLine();
        enrollments.add(new StudentEnrollment(name, course));
        System.out.println("Enrollment successful.");
    }

    static void updateEnrollment() {
        System.out.print("Enter student name to update: ");
        String name = sc.nextLine();
        boolean found = false;

        for (StudentEnrollment e : enrollments) {
            if (e.studentName.equalsIgnoreCase(name)) {
                System.out.print("Enter new course name: ");
                e.courseName = sc.nextLine();
                System.out.println("Enrollment updated.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Enrollment not found.");
        }
    }

    static void removeEnrollment() {
        System.out.print("Enter student name to remove: ");
        String name = sc.nextLine();
        Iterator<StudentEnrollment> iterator = enrollments.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            StudentEnrollment e = iterator.next();
            if (e.studentName.equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Enrollment removed.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Enrollment not found.");
        }
    }

    static void searchEnrollment() {
        System.out.print("Enter student name to search: ");
        String name = sc.nextLine();
        boolean found = false;

        for (StudentEnrollment e : enrollments) {
            if (e.studentName.equalsIgnoreCase(name)) {
                System.out.println(e);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No enrollments found for this student.");
        }
    }

    static void displayAllEnrollments() {
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments available.");
        } else {
            System.out.println("\nAll Enrollments:");
            for (StudentEnrollment e : enrollments) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Course Enrollment System ---");
            System.out.println("1. Enroll Student in Course");
            System.out.println("2. Update Enrollment");
            System.out.println("3. Remove Enrollment");
            System.out.println("4. Search Student Enrollments");
            System.out.println("5. Display All Enrollments");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: enrollStudent(); break;
                case 2: updateEnrollment(); break;
                case 3: removeEnrollment(); break;
                case 4: searchEnrollment(); break;
                case 5: displayAllEnrollments(); break;
                case 6: System.out.println("Exiting system..."); break;
                default: System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);
    }
}
