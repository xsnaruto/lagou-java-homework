public class ForWaterTest {
	public static void main(String[] args) {
		for (int i = 100; i <= 999; i++) {
			int a = i / 100; // 获取百位数
			int b = i / 10 % 10; // 获取十位数
			int bb = i % 100 / 10; // 获取十位数
			int c = i % 10; // 获取个位数

			if (i == a * a * a + b * b * b + c * c * c) {
				System.out.println(i);
			}
		}
	}
}
