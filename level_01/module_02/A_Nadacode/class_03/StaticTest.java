/**
 * StaticTest
 */
public class StaticTest {

    private int cnt = 1; // 隶属于对象层级，每个对象拥有独立内存空间；
    private static int snt = 2; // 隶属于类层级，所有对象共享一份内存空间

    // 自定义非静态的成员方法，需要使用引用 . 的方式访问
    public void show() {
        System.out.println("cnt = " + cnt); // 1
        System.out.println("snt = " + snt); // 2，静态成员被所有对象共享，this 关键字可以省略
    }

    // 自定义静态的成员方法，推荐使用类名 . 的方式访问
    public static void test() {
        // System.out.println("cnt = " + cnt); // 报错
        System.out.println("snt = " + snt); //
    }

    public static void main(String[] args) {

        StaticTest st = new StaticTest();
        st.show();

        System.out.println("---------------------------");
        StaticTest.test();
    }
}