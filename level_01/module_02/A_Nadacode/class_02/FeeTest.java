/**
 * FeeTest
 */
public class FeeTest {

    public static void main(String[] args) {

        // 1. 声明类型的引用指向该类型的对象
        Fee ft = new Fee();

        // 2. 调用方法并打印
        int res = ft.show(7);
        System.out.println("计算结果是：" + res);
    }
}