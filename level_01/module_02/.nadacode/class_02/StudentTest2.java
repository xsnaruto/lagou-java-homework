import java.util.Scanner;

/**
 * StudentTest2
 */
public class StudentTest2 {
    public static void main(String[] args) {
        // 1. 提示用户输入学生人数，并使用变量记录
        System.out.print("请输入学生的人数：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        // 2. 根据学生人数，准备对应的一维数组
        // 下面的代码是声明一个成都为 num 元素类型为 Student 类型的一维数组
        // 数组中的每个月素都是 Student 类型，也就是说数组中的每个元素都可以看做一个 Student 类
        Student[] arr = new Student[num];

        // 3. 提示用户输入每个学生的信息，并记录到一维数组中
        for (int i = 0; i < num; i++) {
            System.out.print("请输入第" + (i + 1) + "个学生的学号:");
            int id = sc.nextInt();
            System.out.print("请输入第" + (i + 1) + "个学生的姓名：");
            String name = sc.next();
            arr[i] = new Student(id, name);
        }
        sc.close();
        System.out.println("----------------------------------------");

        // 4. 打印所有学生的信息
        System.out.println("该班级所有学生信息有：");
        for (int i = 0; i < num; i++) {
            // System.out.println(arr[i]);
            arr[i].show();
        }
    }
}