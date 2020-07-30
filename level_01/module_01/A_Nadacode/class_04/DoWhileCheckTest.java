import java.util.Scanner;

public class DoWhileCheckTest {
	public static void main(String[] args) {
		String msg = null;
		do {
			System.out.println("正在疯狂学习中...");
			// Thread.sleep(5000);
			System.out.println("是否合格？y or n");

			Scanner sc = new Scanner(System.in);
			msg = sc.next();
		} while (!"y".equals(msg)); // 用 ! 排除除 y 外的所有输入

		System.out.println("恭喜，任务合格！");
	}
}
