public class ForForTableTest {
	public static void main(String[] args) {
		System.out.println();
		System.out.println("\t\t\t九九乘法表");
		System.out.println("=========================================================================");
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + "*" + j + "=" + i * j + "\t");
			}
			System.out.println();
		}
	}
}
