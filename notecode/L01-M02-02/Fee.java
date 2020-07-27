/**
 * FeeTest
 */
public class Fee {

    // 自定义成员方法实现费氏数列中第 n 项数值的计算并返回，n 由参数指定
    int show(int n) {
        // // 1. 使用递归方式进行计算
        // // 当 n=1 或者 n = 2 时，结果是 1
        // if (n == 1 || n == 2) {
        // return 1;
        // }
        // return show(n - 1) + show(n - 2);
        // // show(7) => show(6) + show(5); // 13
        // // show(6) => show(5) + show(4); // 8
        // // show(5) => show(4) + show(3); // 5
        // // show(4) => show(3) + show(2); // 3
        // // show(3) => show(2) + show(1); // 2

        // 2. 使用递推方式进行计算
        int a = 1;
        int b = 1;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {

        // 1. 声明类型的引用指向该类型的对象
        Fee ft = new Fee();

        // 2. 调用方法并打印
        int res = ft.show(7);
        System.out.println("计算结果是：" + res);
    }

}