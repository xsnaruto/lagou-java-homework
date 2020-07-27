/**
 * ArraysTest
 */
import java.util.Arrays;

public class ArraysTest {

    public static void main(String[] args) {

        int[] arr = { 10, 20, 30, 40, 50 };

        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        // 使用 toString 输出数组内容
        System.out.println(Arrays.toString(arr));

        // 使用 fill 对数组内容批量赋值
        Arrays.fill(arr, 20);
        System.out.println(Arrays.toString(arr));

        // 使用 equals 功能对多个数组进行比较
        int[] arr1 = new int[5];
        Arrays.fill(arr1, 20);
        System.out.println(Arrays.equals(arr, arr1));
    }
}