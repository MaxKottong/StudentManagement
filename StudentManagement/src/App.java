import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static ArrayList<Student> students = new ArrayList<Student>();
    public static void main(String args[]) {
        start();
    }

    public static void start() {
        Scanner input = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("-----------------\n");
        System.out.println("1 - Add a classmate");
        System.out.println("2 - Delete a classmate");
        System.out.println("3 - Change a classmate");
        System.out.println("4 - Display classmates");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                deleteStudent();
                break;
            case 3:
                changeStudent();
                break;
            case 4:
                displayStudents();
                break;
        }

        input.close();
    }

    public static void addStudent() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter student name: ");
        String name = input.nextLine();

        System.out.println("Enter student age: ");
        int age = input.nextInt();
        input.nextLine();

        System.out.println("Enter student grade: ");
        String grade = input.nextLine();

        System.out.println("Enter student ID: ");
        String id = input.nextLine();

        Student student = new Student(name, age, grade, id);
        students.add(student);

        start();
        input.close();

    }

    public static void deleteStudent(String id) {
        
    }

    public static void changeStudent(String name, int age, String grade, String id) {
        
    }

    public static void displayStudents() {
        for (Student stu : students) {
            System.out.println(stu);
        }
    }

    private static Student getStudentFromArray(String id) {
        
    }
}