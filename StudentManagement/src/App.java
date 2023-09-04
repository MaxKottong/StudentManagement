import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static ArrayList<Student> students = new ArrayList<Student>();
    static ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    public static void main(String args[]) {
        start();
    }

    public static void start() {
        Scanner input = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("-----------------\n");
        System.out.println("1 - Add a student");
        System.out.println("2 - Delete a studet");
        System.out.println("3 - Change a student");
        System.out.println("4 - Display student");
        System.out.println("5 - Add a teacher");
        System.out.println("6 - Delete a teacher");
        System.out.println("7 - Change a teacher");
        System.out.println("8 - Display teacher");

        int choice = input.nextInt();

        String studentId;
        String teacherId;

        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                System.out.println("What is the ID of the student you want to delete?");
                studentId = input.nextLine();

                input.close();
                deleteStudent(studentId);
                break;
            case 3:
                System.out.println("What is the ID of the student you want to change?");
                studentId = input.nextLine();

                input.close();
                changeStudent(studentId);
                break;
            case 4:
                displayStudents();
                break;
            case 5:
                addTeacher();
                break;
            case 6:
                System.out.println("What is the ID of the teacher you want to delete?");
                teacherId = input.nextLine();

                input.close();
                deleteTeacher(teacherId);
                break;
            case 7:
                System.out.println("What is the ID of the teacher you want to change?");
                teacherId = input.nextLine();

                input.close();
                changeTeacher(teacherId);
                break;
            case 8:
                displayTeachers();
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
        Student student = getStudentFromArray(id);

        if (student == null) {
            System.out.println("A student with that ID does not exist");
            start();
        } else {
            //delete student here
        }
    }

    public static void changeStudent(String id) {
        Student student = getStudentFromArray(id);

        if (student == null) {
            System.out.println("A student with that ID does not exist");
            start();
        } else {
            //change student here
        }
    }

    public static void displayStudents() {
        for (Student stu : students) {
            System.out.println(stu);
        }
    }

    private static Student getStudentFromArray(String id) {
        Student student = students.stream().filter(stu -> id.equals(stu.id)).findFirst().orElse(null);
        
        return student;
    }

    public static void addTeacher() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter teacher name: ");
        String name = input.nextLine();

        System.out.println("Enter teacher age: ");
        int age = input.nextInt();
        input.nextLine();

        System.out.println("Enter teacher section: ");
        String section = input.nextLine();

        System.out.println("Enter teacher salary: ");
        int salary = input.nextInt();
        input.nextLine();

        System.out.println("Enter teacher ID");
        String id = input.nextLine();

        Teacher teacher = new Teacher(name, age, section, salary, id);
        teachers.add(teacher);

        start();
        input.close();

    }

    public static void deleteTeacher(String id) {
        Teacher teacher = getTeacherFromArray(id);

        if (teacher == null) {
            System.out.println("A teacher with that ID does not exist");
            start();
        } else {
            //delete teacher here
        }
    }

    public static void changeTeacher(String id) {
        Teacher teacher = getTeacherFromArray(id);

        if (teacher == null) {
            System.out.println("A teacher with that ID does not exist");
            start();
        } else {
            //change teacher here
        }
    }

    public static void displayTeachers() {
        for (Teacher tea : teachers) {
            System.out.println(tea);
        }
    }

    private static Teacher getTeacherFromArray(String id) {
        Teacher teacher = (Teacher)teachers.stream().filter(tea -> id.equals(tea.id)).findFirst().orElse(null);

        return teacher;
    }
}