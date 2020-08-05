package level_01.module_02.class_04;

public class SuperTest {
    {
        System.out.println("SuperTest 类的构造块"); // 第二个执行
    }

    static {
        System.out.println("SuperTest 类中的静态代码块"); // 第一个执行
    }

    public SuperTest() {
        System.out.println("SuperTest 类中的构造方法体"); // 第三个执行
    }

    public static void main(String[] args) {

        // 使用无参方式构造对象
        SuperTest st = new SuperTest();
    }
}
