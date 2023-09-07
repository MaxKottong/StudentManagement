import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Junit {

    @Test
    public void testAddStudent() {
        Student gary = new Student("Gary Fisher", 22, "Junior", "123123123");
        App.addStudent(gary);

        assertEquals(2, App.students.size());
    }

    @Test
    public void testDeleteStudent() {
        App.deleteStudent("123123123");

        assertEquals(1, App.students.size());
    }

    @Test
    public void testChangeStudent() {
        Student steve = new Student("Steve O", 55, "Graduate", "12345");
        App.addStudent(steve);

        steve.age = 44;

        App.changeStudent(0, steve);

        assertEquals(44, App.getStudentFromArray("12345").age);
    }

    // Not testing display because its only output, nothing to instance
    // public void testDisplayStudent() {

    // }

    @Test
    public void testAddTeacher() {
        Teacher gary = new Teacher("Gary Fisher", 22, "ITSC", 500000, "123123123");
        App.addTeacher(gary);

        assertEquals(2, App.teachers.size());
    }

    @Test
    public void testDeleteTeacher() {
        App.deleteTeacher("123123123");

        assertEquals(1, App.teachers.size());
    }

    @Test
    public void testChangeTeacher() {
        Teacher steve = new Teacher("Steve O", 55, "ITSC", 50000, "12345");
        App.addTeacher(steve);

        steve.age = 44;

        App.changeTeacher(0, steve);

        assertEquals(44, App.getTeacherFromArray("12345").age);
    }
}
