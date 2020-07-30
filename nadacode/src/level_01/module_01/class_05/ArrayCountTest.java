import java.util.Scanner;

public class ArrayCountTest {
    public static void main(String[] args) {

        // 1. 提示用户输入一个正整数并使用变量记录
        System.out.println("请输入一个正整数：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        // 2. 准备一个长度为 10 元素类型为 int 类型的一维数组
        int[] arr = new int[10];

        // 3. 拆分正整数中的每个数字并统计到一维数组中
        int temp = num;
        while (temp > 0) {
            arr[temp % 10]++;
            temp /= 10;
        }

        // 4. 打印最终的统计结果
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                System.out.printf("数字 %d 出现了 %d 次。\n", i, arr[i]);

            }
        }

    }
}