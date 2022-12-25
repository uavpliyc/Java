public class ObjectTest {
    public static void main(String[] args) {
        Student s1 = new Student("tanaka",1);
        Student s2 = new Student("tanaka",1);

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        String str1 = new String("test");
        String str2 = new String("test");

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

    }
}

class Student {
    private String name;
    private int num;

    public Student(String name, int num) {
        this.name = name;
        this.num = num;
    }
}
