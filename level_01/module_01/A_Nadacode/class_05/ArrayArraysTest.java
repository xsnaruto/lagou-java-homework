public class ArrayArraysTest {
	public static void main(String[] args) {
		// 1. 声明一个具有两行数组的二维数组
		int[][] brr = new int[2][2];

		// 2. 使用外层 for 循环控制打印的行数
		for (int i = 0; i < brr[i].length - 1; i++) {
			for (int j = 0; j < brr[i].length; j++) {
				System.out.print(brr[i][j] + "");
			}
			System.out.println();
		}
	}
}
