import java.util.Random;
import java.util.Scanner;

public class ForGuessTest {
	public static void main(String[] args) {

		// 1. 生成一个随机数并且赋值
		Random ra = new Random();
		int tempNum = ra.nextInt(100) + 1;
		int guessCount = 0;

		// 2. 输入猜测的数字
		System.out.println("请输入 1～100 之间的数");
		for (int i = 6; i >= 0; i--) {
			Scanner sc = new Scanner(System.in);
			int guessNum = sc.nextInt();

			guessCount++;

			// 3. 判断数据大小或匹配
			if (guessCount >= 7) {
				System.out.println("机会已用完，挑战失败。");
			} else {
				if (guessNum > tempNum) {
					System.out.printf("你猜大了,剩余机会 %d 次。\n", i);
				} else if (guessNum < tempNum) {
					System.out.printf("你猜小了,剩余机会 %d 次。\n", i);
				} else {
					System.out.println("恭喜，你猜对了！");
					break; // ⚠️ 猜对的情况下用 break 跳出循环，否则无法执行下面 4. 语句
				}
			}
		}

		// 4. 通过猜测次数进行评分
		System.out.println("猜测次数：" + guessCount);
		if (guessCount < 5) {
			switch (guessCount) {
				case 1:
					System.out.printf("你猜了 %d 次就成功了！牛逼！\n", guessCount);
					break;
				case 2, 3:
					System.out.printf("你猜了 %d 次就成功了！很厉害！\n", guessCount);
					break;
				case 4, 5:
					System.out.printf("你猜了 %d 次！水平还行！\n", guessCount);
					break;
			}
		} else {
			System.out.printf("你猜 %d 次！还要加油哦！\n", guessCount);
		}
	}
}
