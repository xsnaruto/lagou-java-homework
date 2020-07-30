package nadacode.task08;

public class SubSuperTest extends SuperTest {
    {
        System.out.println("SubSuperTest 类的构造块"); // 第二个执行
    }

    static {
        System.out.println("SubSuperTest 类中的静态代码块"); // 第一个执行
    }

    public SubSuperTest() {
        System.out.println("SubSuperTest 类中的构造方法体"); // 第三个执行
    }

    public static void main(String[] args) {

        // 使用无参方式构造对象
        SubSuperTest st = new SubSuperTest();
    }
}
