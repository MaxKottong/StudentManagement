public class Teacher extends Person{
    int salary;
    String section;

    public Teacher(String name, int age, String section, int salary, String id) {
        super(name, age, id);
        this.salary = salary;
        this.section = section;
    }

    @Override
    public String toString() {
        return "Teacher: " + name + ", " + "Age: " + age + ", " + "Section: " + section + ", " + "Salary: " + salary + ", " + "ID: " + id;
    }
}
