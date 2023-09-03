import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class Junit {
App app = new App();

    @Test
    public void testAddStudent() {
        Student gary = new Student("Gary Fisher", 22, "Junior", "123123123");
        app.addStudent(gary);

        assertEquals();
    }
}
