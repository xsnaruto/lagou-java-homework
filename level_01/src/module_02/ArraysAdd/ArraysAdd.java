package ArraysAdd;

import java.util.Random;

/**
 * 编程实现以下需求：
 * 定义一个长度为[16][16]的整型二维数组并输入或指定所有位置的元素值，
 * 1. 分别实现二维数组中所有行和所有列中所有元素的累加和并打印；
 * 2. 分别实现二维数组中左上角到右下角和右上角到左下角所有元素的累加和并打印。
 */

public class ArraysAdd {
    public static void main(String[] args) {
        // 1. 创建一个长度为 [16][16] 的二维数组，并创建 add1 和 add2 用来接收之后元素相加的值
        int[][] arr = new int[16][16];
        int add1 = 0;
        int add2 = 0;

        System.out.println("\t\t\t\t\t五子棋盘\t\t\t\t\t");
        System.out.println("-------------------------------------------------");

        // 2. 通过随机数工具给数组元素赋值，同时打印内容检查是否复制成功
        Random ra = new Random();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = ra.nextInt(50) + 1;

                // 3. 打印数组内容，并在小于 10 的数字前加 0 以优化打印效果
                if (arr[i][j] >= 10) {
                    System.out.print(arr[i][j] + " ");
                } else {
                    System.out.print("0" + arr[i][j] + " ");
                }

                // 4. 在数组元素赋值后，直接将数组元素相加并赋值给 add1
                add1 += arr[i][j];
            }

            // 5. 在第一层 for 循环的后面进行左上角至右下角和右上角至左下角的数值相加并赋值给 add2
            // 4.2 左上角至右下角的元素数值相加
            add2 += arr[i][i];
            // 4.2 右上角至左下角的原属数值相加
            add2 += arr[i][arr.length - 1 - i];

            System.out.println(); // 每执行一轮第一层 for 循环之后进行换行
        }

        System.out.println("-------------------------------------------------");

        // 5. 打印 add1 和 add2 的最终值
        System.out.println("所有数组元素相加的最终值为：" + add1);
        System.out.println("数组 X 型位置元素相加和为：" + add2);
    }
}
