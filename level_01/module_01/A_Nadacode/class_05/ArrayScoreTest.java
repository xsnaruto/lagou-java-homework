import java.util.Scanner;

/**
 * ArrayScoreTest
 */
public class ArrayScoreTest {

    public static void main(String[] args) {

        // 1. 提示用户输入学生人数，并使用变量来进行记录
        System.out.println("请输入学生的人数：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        // 2. 根据人数来创建两个一维数组，负责记录名字和成绩
        String[] name = new String[num];
        int[] score = new int[num];

        // 3. 提示用户依次输入学生姓名和成绩
        for (int a = 0; a < num; a++) {

            System.out.printf("请输入第 %d 个学生的姓名:\n", a + 1);
            name[a] = sc.next();

            System.out.printf("请输入%s的成绩：", name[a]);
            score[a] = sc.nextInt();
        }

        // 4. 计算平均分
        int sumScore = 0;
        for (int b = 0; b < num; b++) {
            sumScore += score[b];
        }
        double avgScore = sumScore * 1.0 / num;

        // 5. 打印出包含所有学生信息的成绩单
        System.out.println("\t\t成绩单\t\t");
        System.out.println("==============================");
        System.out.println("姓名\t\t\t成绩");
        System.out.println("------------------------------");
        for (int c = 0; c < num; c++) {
            System.out.printf("%s\t\t\t%d\n", name[c], score[c]);
        }
        System.out.println("------------------------------");
        System.out.printf("总分：%d\t均分：%.2f\n", sumScore, avgScore);

    }
}