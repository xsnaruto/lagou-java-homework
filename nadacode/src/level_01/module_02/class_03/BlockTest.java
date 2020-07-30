/**
 * BlockTest
 */
public class BlockTest {

    // 当需要在执行构造方法体之前做一些准备工作时，将准备工作的相关代码写在构造块中；
    // 比如「对成员变量」进行统一的初始化；
    {
        System.out.println("构造块！"); // 构造块
    }

    // 静态代码块，最先执行，static 随着类的加载就准备就绪
    // 静态代码块随加载而准备就绪，类只执行一次，所以只会加载一次
    static {
        System.out.println("静态代码块！"); // 静态代码块
    }

    // 自定义构造方法
    public BlockTest() {
        System.out.println("构造方法体！");
    }

    public static void main(String[] args) {

        BlockTest bt = new BlockTest();
        System.out.println(bt);

        // 每创建一次对象都会执行一次构造块
        BlockTest bt2 = new BlockTest();
        System.out.println(bt2);

        //

    }
}