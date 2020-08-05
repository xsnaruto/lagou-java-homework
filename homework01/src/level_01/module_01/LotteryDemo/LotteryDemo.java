package level_01.module_01.LotteryDemo; /**
 * 实现双色球抽奖游戏中奖号码的生成，中奖号码由 6 个红球号码和 1 个蓝球号码组成。 
 * 红球号码要求随机生成 6 个 1~33 之间不重复的随机号码。
 * 蓝球号码要求随机生成 1 个 1~16 之间的随机号码。
 */

import java.util.Arrays;
import java.util.Random;

public class LotteryDemo {
    public static void main(String[] args) {
        // 1. 引入随机数工具
        Random ra = new Random();

        // 2. 因考虑后续统计工作便利，所以创建一个一维数组来接收 6 个红球和 1 个蓝球的数据
        int[] ball = new int[7];

        // 3. 使用 for 循环和随机数工具为数组中的元素赋值
        // 3.1. 先获取红球部分的 6 个值
        // 3.1.1 第一层 for 循环负责每个红球的赋值
        for (int i = 0; i < ball.length - 1; i++) {
            // ball[i] = ra.nextInt(6) + 1; 检查重复和排序效果

            ball[i] = ra.nextInt(33) + 1;

            // 3.1.2 第二层 for 循环判断数据是否有重复，如果有重复，通过 i-- 重新进行一次第一层的 for 循环
            for (int j = 0; j < i; j++) {
                if (ball[i] == ball[j]) {
                    i--;
                }
            }
        }
        // 3.2. 获取蓝球部分数值
        ball[ball.length - 1] = ra.nextInt(33) + 1;

        // 4. 优化展示效果并打印结果
        // 4.1. 对红球部分 ball[0] ~ ball[5] 按照从小到大排练
        Arrays.sort(ball, 0, 6);

        // 4.2 将红球结果通过遍历数组打印，蓝球结果取数组最后一位值进行打印
        System.out.println();
        System.out.println("本期双色球大奖的结果为：");
        System.out.println("-----------------------------------");
        System.out.print("红球号码：");
        for (int i = 0; i < ball.length - 1; i++) {
            if (i == ball.length - 2) { // 判断是否是最后一个红球
                if (ball[i] / 10 < 1) {
                    System.out.print("0" + ball[i]);
                } else {
                    System.out.print(ball[i]);
                }
            } else {
                // 4.2.1 如果结果小于 10，在前面补充一个 0
                if (ball[i] / 10 < 1) {
                    System.out.print("0" + ball[i] + ", ");
                } else {
                    System.out.print(ball[i] + ", ");
                }
            }

        }
        System.out.println(); // 换行
        if (ball[ball.length - 1] / 10 < 1) {
            System.out.println("蓝球号码：0" + ball[ball.length - 1]);
        } else {
            System.out.println("蓝球号码：" + ball[ball.length - 1]);
        }
    }
}