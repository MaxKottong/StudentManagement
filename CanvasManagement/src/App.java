import java.util.ArrayList;
import java.util.Scanner;

//This code was written by Max Kottong of Team 1 (TECH TITANS)

public class App {
    // Defining arrays for Student and Teacher separately
    static ArrayList<Student> students = new ArrayList<Student>();
    static ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    static Scanner input = new Scanner(System.in);

    public static void main(String args[]) {
        showMenu();
    }

    // Menu and switch for choices
    public static void showMenu() {
        Boolean isContinue = true;

        while (isContinue) {
            Boolean isPressNext = true;

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
            System.out.println("9: Exit");

            int choice = input.nextInt();
            input.nextLine();

            String studentId = "";
            String teacherId = "";
            Student student = null;
            String name = "";
            int age = 0;
            String id = "";
            int index = 0;

            switch (choice) {
                case 1:
                    System.out.println("Enter student name: ");
                    name = input.nextLine();

                    System.out.println("Enter student age: ");
                    age = input.nextInt();
                    input.nextLine();

                    System.out.println("Enter student grade: ");
                    String grade = input.nextLine();

                    System.out.println("Enter student ID: ");
                    id = input.nextLine();

                    student = new Student(name, age, grade, id);
                    addStudent(student);
                    isPressNext = false;
                    break;
                case 2:
                    System.out.println("What is the ID of the student you want to delete?");
                    studentId = input.nextLine();

                    deleteStudent(studentId);
                    break;
                case 3:
                    Student newStudent = null;
                    System.out.println("What is the ID of the student you want to change?");
                    studentId = input.nextLine();
                    student = getStudentFromArray(studentId);

                    if (student == null) {
                        System.out.println("A student with that ID does not exist");
                    } else {
                        System.out.println("What would you like to change the students name to?");
                        String newStudentName = input.nextLine();

                        System.out.println("What would you like to change the students age to?");
                        int newStudentAge = input.nextInt();
                        input.nextLine();

                        System.out.println("What would you like to change the students grade to?");
                        String newStudentGrade = input.nextLine();

                        System.out.println("What would you like to change the students id to?");
                        String newStudentId = input.nextLine();

                        newStudent = new Student(newStudentName, newStudentAge, newStudentGrade, newStudentId);

                        System.out.println("Student changed successfully");
                    }
                    index = findIndexById(students, studentId);
                    changeStudent(index, newStudent);
                    break;
                case 4:
                    displayStudents();
                    break;
                case 5:
                    System.out.println("Enter teacher name: ");
                    name = input.nextLine();

                    System.out.println("Enter teacher age: ");
                    age = input.nextInt();
                    input.nextLine();

                    System.out.println("Enter teacher section: ");
                    String section = input.nextLine();

                    System.out.println("Enter teacher salary: ");
                    int salary = input.nextInt();
                    input.nextLine();

                    System.out.println("Enter teacher ID");
                    id = input.nextLine();

                    Teacher teacher = new Teacher(name, age, section, salary, id);
                    addTeacher(teacher);
                    isPressNext = false;
                    break;
                case 6:
                    System.out.println("What is the ID of the teacher you want to delete?");
                    teacherId = input.nextLine();

                    deleteTeacher(teacherId);
                    break;
                case 7:
                    Teacher newTeacher = null;
                    System.out.println("What is the ID of the teacher you want to change?");
                    teacherId = input.nextLine();
                    teacher = getTeacherFromArray(id);

                    if (teacher == null) {
                        System.out.println("A teacher with that ID does not exist");
                    } else {
                        System.out.println("What would you like to change the teachers name to?");
                        String newTeacherName = input.nextLine();

                        System.out.println("What would you like to change the teachers age to?");
                        int newTeacherAge = input.nextInt();
                        input.nextLine();

                        System.out.println("What would you like to change the teachers section to?");
                        String newTeacherSection = input.nextLine();

                        System.out.println("What would you like to change the teachers salary to?");
                        int newTeacherSalary = input.nextInt();
                        input.nextLine();

                        System.out.println("What would you like to change the teachers id to?");
                        String newTeacherId = input.nextLine();

                        newTeacher = new Teacher(newTeacherName, newTeacherAge, newTeacherSection,
                                newTeacherSalary, newTeacherId);
                        System.out.println("Teacher changed successfully");
                    }
                    index = findIndexByIdTeacher(teachers, teacherId);
                    changeTeacher(index, newTeacher);
                    break;
                case 8:
                    displayTeachers();
                    break;
                case 9:
                    isContinue = false;
            }

            if (isPressNext) {
                pressEnterToContinue();
            }
        }

        input.close();
    }

    // Adds student using user input to students array
    public static void addStudent(Student student) {
        students.add(student);
    }

    // Deletes student using user inputted ID, by seeing if that ID exists in the
    // students array
    public static void deleteStudent(String id) {
        Student student = getStudentFromArray(id);

        if (student == null) {
            System.out.println("A student with that ID does not exist");
        } else {
            students.removeIf(e -> e.getId().equals(id));
            System.out.println("Student removed successfully");
        }
    }

    // Changes student based on user input, sets the student to be correct by
    // finding index in array and replacing the element there
    public static void changeStudent(int index, Student student) {
        students.set(index, student);
    }

    // Loops through array and displays students with the overrided toString method
    // in the student class
    public static void displayStudents() {
        for (Student stu : students) {
            System.out.println(stu);
        }
    }

    // Gets students from the array using their ID and returns that student
    public static Student getStudentFromArray(String id) {
        Student student = students.stream().filter(stu -> id.equals(stu.id)).findFirst().orElse(null);

        return student;
    }

    public static void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public static void deleteTeacher(String id) {
        Teacher teacher = getTeacherFromArray(id);

        if (teacher == null) {
            System.out.println("A teacher with that ID does not exist");
        } else {
            teachers.removeIf(e -> e.getId().equals(id));
            System.out.println("Teacher removed successfully");
        }
    }

    public static void changeTeacher(int index, Teacher newTeacher) {
        teachers.set(index, newTeacher);

        System.out.println("Teacher changed successfully");
    }

    public static void displayTeachers() {
        for (Teacher tea : teachers) {
            System.out.println(tea);
        }
    }

    public static Teacher getTeacherFromArray(String id) {
        Teacher teacher = (Teacher) teachers.stream().filter(tea -> id.equals(tea.id)).findFirst().orElse(null);

        return teacher;
    }

    // Used on some choices, as menu was popping immediately upon method succession,
    // not letting user know if their actions went through
    private static void pressEnterToContinue() {
        System.out.println("Press Enter key to continue...");
        input.nextLine();
    }

    private static int findIndexById(ArrayList<Student> students, String id) {
        int index = -1;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id.equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static int findIndexByIdTeacher(ArrayList<Teacher> teacers, String teacherId) {
        int index = -1;

        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).id.equals(teacherId)) {
                index = i;
                break;
            }
        }
        return index;
    }
}