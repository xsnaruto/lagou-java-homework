import java.util.Scanner;

/**
 * ArrayArrayTriangleTest
 */
import java.util.Scanner;

public class ArrayArrayTriangleTest {

    public static void main(String[] args) {

        // 1. 提示用户输入一个行数，并使用变量记录
        System.out.println("请输入一个行数：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        // 2. 根据用户输入的行数来声明对应的二维数组
        int[][] arr = new int[num][];

        // 3. 用 for 循环对二维数组的元素进行初始化
        for (int i = 0; i < num; i++) { // 控制行
            arr[i] = new int[i + 1]; // 对每一行的数组分配列数
            for (int j = 0; j <= i; j++) { // 控制对应行的每一列元素
                if (j == 0 || i == j) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                }
            }
        }

        // 4. 打印最终生成的结果
        System.out.println();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }
}