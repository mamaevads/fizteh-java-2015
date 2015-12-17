package ru.fizteh.fivt.students.mamaevads.miniorm;
/*import java.util.List;


import junit.framework.TestCase;
import org.junit.Test;
import ru.fizteh.fivt.students.mamaevads.miniorm.Column;
import ru.fizteh.fivt.students.mamaevads.miniorm.DatabaseService;
import ru.fizteh.fivt.students.mamaevads.miniorm.PrimaryKey;
import ru.fizteh.fivt.students.mamaevads.miniorm.Table;

public class DatabaseServiceTest extends TestCase {

        @Table
        public static class Student {
            @Column
            @PrimaryKey
            private String name;
            @Column(name="roomnum")
            private String room;
            @Column
            private Integer age;

            public Student() {}

            private Student(String name, String room, int age) {
                this.name = name;
                this.room = room;
                this.age = age;
            }

            @Override
            public String toString() {
                return "Student{" + name + "|" + room + "|" + age + "}";
            }
        }

        @Test
        public void testTableCreation() {
        try {
            DatabaseService<Student> service = new DatabaseService<>(Student.class);
            service.createTable();
            service.dropTable();
        } catch (Exception e) {
            e.printStackTrace();
            fail("failed: " + e.getMessage());
        }
    }

        @Test
        public void testRowOperations() {
        try {
            DatabaseService<Student> service = new DatabaseService<>(Student.class);
            service.createTable();
            service.insert(new Student("ivanov", "305", 18));
            service.insert(new Student("petrov", "305", 18));
            service.insert(new Student("sidorov", "306", 19));
            service.insert(new Student("nobody", "306", 17));
            service.update(new Student("petrov", "308", 18));
            service.deleteByKey("sidorov");
            service.delete(new Student("nobody", "308", 30));

            assertNull(service.queryById("sidorov"));
            assertEquals("[Student{ivanov|305|18}, Student{petrov|308|18}]", service.queryForAll().toString());
            service.dropTable();
        } catch (Exception e) {
            e.printStackTrace();
            fail("failed: " + e.getMessage());
        }
    }


}

*/