/**
 * ThisTest
 */
public class ThisTest {

    // 自定义构造方法
    ThisTest() {
        // this 表示当前正在构造的对象
        System.out.println("构造方法中：this =" + this);
    }

    // 自定义成员方法
    void show() {
        // this 代表当前正在调用的对象
        System.out.println("成员方法中：this = " + this);
    }

    public static void main(String[] args) {

        // 1. 声明 ThisTest 类型的引用指向该类型的对象
        ThisTest tt = new ThisTest();
        // 2. 调用 show 方法
        System.out.println("main 方法中：tt = " + tt);

        tt.show();
    }
}