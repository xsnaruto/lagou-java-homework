import java.util.Scanner;

public class WhileReverseTest {
	public static void main(String[] args) {
		System.out.println("请输入一个正整数：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		// 方法一，拆分后直接进行不换行的打印
		// while (num > 0) {
		// 	System.out.print(num % 10);
		// 	num /= 10;
		// }

		// 方法二，拆分整数中的每个数字并记录到变量中
		int res = 0;
		int temp = num;
		while (temp > 0) {
			res = res * 10 + temp % 10;
			temp /= 10;
		}
		System.out.println(res);

		System.out.println();
	}
}
