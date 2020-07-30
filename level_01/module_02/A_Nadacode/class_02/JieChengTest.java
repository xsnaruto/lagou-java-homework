/**
 * JieChengTest
 */
public class JieChengTest {

    // 自定义成员方法，实现将参数 n 的阶乘计算出来并返回
    int show(int n) {
        // // 递推方式
        // int num = 1;
        // for (int i = 1; i <= n; i++) {
        // num *= i;
        // }
        // return num;

        // 当 n 的数值为 1 时，阶乘的结果就是 1；
        // 递归：在方法体内部调用了自身方法
        if (1 == n) {
            return 1;
        }
        return n * show(n - 1); // 等于 5 * show(4) ==> ... 持续执行 show 方法进行计算 
    }
    // 否则阶乘的结果就是 n*(n-1)!

    public static void main(String[] args) {

        // 1. 声明 JieChengTest 类型的引用指向该类型的对象
        JieChengTest jct = new JieChengTest();

        // 2. 调用方法进行计算并打印
        int res = jct.show(5);
        System.out.println("最终计算结果是：" + res);
    }

}