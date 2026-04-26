package HomeWork15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Task3Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Ivan", "A1", 1, Arrays.asList(4, 5, 3, 4)));
        students.add(new Student("Anna", "A1", 1, Arrays.asList(2, 3, 2, 2)));
        students.add(new Student("Petr", "B2", 2, Arrays.asList(3, 3, 4, 5)));
        students.add(new Student("Maria", "B2", 2, Arrays.asList(5, 5, 5, 4)));
        students.add(new Student("Kesha", "B2", 2, Arrays.asList(5, 5, 2, 5)));

        processStudents(students);

        System.out.println("Students on course 2:");
        printStudents(students, 2);

        System.out.println("Students on course 3:");
        printStudents(students, 3);
    }

    public static void processStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();

            if (student.getAverageGrade() < 3) {
                iterator.remove();
            } else {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
