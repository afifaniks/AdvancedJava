package lambda;

/**
 * Project: AdvancedJava
 * Author: AFIF AL MAMUN
 * Created in 10/11/20
 * Web: https://afifaniks.me
 */
public class Student {
    enum Gender {
        MALE,
        FEMALE
    }

    private String name;
    private int age;
    private Gender gender;

    public Student(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
