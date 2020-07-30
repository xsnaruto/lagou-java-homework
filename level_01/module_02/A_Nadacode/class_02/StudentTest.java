/**
 * StudentTest
 */
public class StudentTest {

    public static void main(String[] args) {
        // 1. 声明 Student 类型的引用，指向 Student 类型的对象
        Student s1 = new Student();

        // 2. 对成员变量进行赋值并打印
        // s1.id = 1001;
        // s1.name = "张三";
        // s1.setID(-1001);
        s1.setID(1001);
        s1.setName("张三");
        s1.show();

        System.out.println("-----------------------------------------");

        // 3. 使用有参方式构造对象并打印特征
        Student s2 = new Student(1002, "李四");
        s2.show();
    }
}