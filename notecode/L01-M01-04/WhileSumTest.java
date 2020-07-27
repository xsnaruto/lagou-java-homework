import java.util.Scanner;

public class WhileSumTest {
	public static void main(String[] args) {
		System.out.println("请输入一个整数：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		double sum = 0.0;

		// 使用 for 循环实现
		// for (int i = 1; i <= num; i++) {
		// sum += 1.0 / i;
		// }

		// 使用 while 循环实现
		int i = 1;
		while (i <= num) {
			sum += 1.0 / i;
			i++;
		}
		System.out.println("最终的计算结果是：" + sum);
	}
}
