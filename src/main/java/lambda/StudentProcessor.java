package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Project: AdvancedJava
 * Author: AFIF AL MAMUN
 * Created in 10/11/20
 * Web: https://afifaniks.me
 */
public class StudentProcessor {
    public List<String> process(List<Student> students,
                                Function<Student, String> function) {
        ArrayList<String> list = new ArrayList<>();

        for (Student student: students) {
            String name = function.apply(student);
            list.add(name);
        }

        return list;
    }

    public List<Student> filter(List<Student> students,
                                Predicate<Student> predicate) {
        ArrayList<Student> list = new ArrayList<>();

        for (Student student: students) {
            if (predicate.test(student)) {
                list.add(student);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Oyan", 22, Student.Gender.MALE),
                new Student("Sentu", 25, Student.Gender.MALE),
                new Student("Rokob", 22, Student.Gender.FEMALE),
                new Student("Onik", 32, Student.Gender.MALE)
        );

        Function<Student, String> nameFunc = student -> student.getName();
        Function<Student, String> ageFunc = student -> String.valueOf(student.getAge());
        Function<Student, String> genderFunc = student -> student.getGender().toString();

        StudentProcessor studentProcessor = new StudentProcessor();
        List<String> names = studentProcessor.process(students, nameFunc);

        Predicate<Student> olderThan23 = student -> student.getAge() > 23;
        List<Student> ageFiltered = studentProcessor.filter(students, olderThan23);

        for (String name: names) {
            System.out.println(name);
        }

        for (Student student: ageFiltered) {
            System.out.println(student.getName());
        }

        // Passing lambda directly
        List<Student> females = studentProcessor.filter(students,
                student -> student.getGender().equals(Student.Gender.FEMALE));

        for (Student student: females) {
            System.out.println(student.getName());
        }
    }
}
