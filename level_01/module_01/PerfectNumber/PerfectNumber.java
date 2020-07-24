/**
 * 找出 1000 以内的所有完数并打印出来。 所谓完数就是一个数恰好等于它的因子之和，如：6=1＋2＋3
 */

public class PerfectNumber {
    public static void main(String[] args) {
        // 1. 创建一个 for 循环对 1000 以内的数进行运算
        System.out.print("\n1000 以内的完数有：");
        for (int i = 1; i <= 1000; i++) {
        
            // 2. 创建一个变量用来接收之后可整除因子的相加
            int temp = 0;

            // 3. 创建一个新的内层循环，用来对一个数重复取余，并将能整除的数进行相加
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    temp += j;
                }
            }

            // 4. 判断一个数本身是否等于它的所有因子只和，如果相等则在行内打印出来
            if (i == temp) {
                System.out.print(i + " ");
            }
        }
        System.out.println(); // 结尾换行
    }

}