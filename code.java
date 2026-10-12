import java.util.ArrayList;
import java.util.Scanner;

/**
 * Project 3: Student Marks Manager
 * Concepts: ArrayList, for loop, methods, grade logic, average/highest calculation
 */
public class StudentMarksManager {

    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Integer> marks = new ArrayList<>();

    static String getGrade(int mark) {
        if (mark >= 90) return "A";
        else if (mark >= 75) return "B";
        else if (mark >= 60) return "C";
        else if (mark >= 40) return "D";
        else return "F";
    }

    static void addStudent(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.next();
        System.out.print("Enter marks (0-100): ");
        int mark = sc.nextInt();

        if (mark < 0 || mark > 100) {
            System.out.println("Invalid marks! Must be between 0 and 100.");
            return;
        }
        names.add(name);
        marks.add(mark);
        System.out.println("Student added.");
    }

    static void showAll() {
        if (names.isEmpty()) {
            System.out.println("No students yet.");
            return;
        }
        System.out.println("\nName\t\tMarks\tGrade");
        System.out.println("-----------------------------");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + "\t\t" + marks.get(i) + "\t" + getGrade(marks.get(i)));
        }
    }

    static void showStats() {
        if (marks.isEmpty()) {
            System.out.println("No students yet.");
            return;
        }
        int total = 0, highestIndex = 0;
        for (int i = 0; i < marks.size(); i++) {
            total += marks.get(i);
            if (marks.get(i) > marks.get(highestIndex)) {
                highestIndex = i;
            }
        }
        double average = (double) total / marks.size();
        System.out.println("Total students : " + marks.size());
        System.out.println("Class average  : " + average);
        System.out.println("Topper         : " + names.get(highestIndex)
                + " (" + marks.get(highestIndex) + ")");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Student Marks Manager ===");
            System.out.println("1. Add student");
            System.out.println("2. Show all students");
            System.out.println("3. Show statistics");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(sc); break;
                case 2: showAll();      break;
                case 3: showStats();    break;
                case 4: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid option.");
            }
        } while (choice != 4);

        sc.close();
    }
}
