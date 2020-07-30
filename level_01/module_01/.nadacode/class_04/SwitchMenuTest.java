import java.util.Scanner;

public class SwitchMenuTest {
	public static void main(String[] args) {

		System.out.println("	  欢迎来到拉勾教育");
		System.out.println("--------------------------------------");
		System.out.println("[1] 学员系统		[0] 退出系统");
		// System.out.println("		[0] 退出系统");
		System.out.println("[2] 管理员系统");
		System.out.println("--------------------------------------");
		System.out.println("请选择要进入的系统：");

		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		sc.close();

		switch (choose) {
			case 1:
				System.out.println("正在进入学员系统");
				break;
			case 2:
				System.out.println("正在进入管理员系统");
				break;
			case 0:
				System.out.println("正在退出系统，感谢使用");
				break;
			default:
				System.out.println("输入错误");
		}
	}
}
