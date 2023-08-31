public class Student extends Person {
    public String grade;

    public Student(String name, int age, String grade, String id) {
        super(name, age, id);
        this.grade = grade;
    }

    public getStudentName() {

    }

    @Override
    public String toString() {
        return "Student: " + name + ", " + "Age: " + age + ", " + "Grade: " + grade + ", " + "ID: " + id;
    }
}
