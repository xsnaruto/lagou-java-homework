import java.util.Scanner;

/**
 * 4. 编程题
 * 使用 List 集合实现简易的学生信息管理系统，要求打印字符界面提示用户选择相应的功能，
 * 根据用户输入的选择去实现增加、删除、修改、查找以及遍历所有学生信息的功能。
 * 其中学生的信息有：学号、姓名、年龄。 要求： 尽量将功能拆分为多个.java 文件。
 */
public class TestSystem extends StudentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exitSystem = false;

        do {
            System.out.println("\n欢迎进入学生管理系统");
            System.out.println("-------------------------");
            System.out.println("1. 增加学生信息 \t 4. 查看所有学生\n2. 查找学生信息 \t 5. 删除学生信息\n3. 修改学生信息 \t 6. 退出管理系统");
            System.out.print("请根据需求输入对应功能的编号：");

            // 排除用户输入内容中除了 1-5 数字外的内容，并转化为 int 类型
            int choice = Integer.parseInt(sc.next().replaceAll("[^1-5]", ""));

            if (choice >= 1 && choice <= 6) {
                // 如果用户输入的是 1-5 的数字，则执行以下语句
                switch (choice) {
                    case 1 -> addStu();
                    case 2 -> searchStu();
                    case 3 -> editStu();
                    case 4 -> readFull();
                    case 5 -> delStu();
                    case 6 -> exitSystem = true;
                }
            } else {
                // 如果用户输入的不是 1 - 5 的数字，则提示输入错误，重新进行 do while 循环
                System.out.println("输入错误，请重新输入：");
            }
        } while (!exitSystem);
        sc.close();
    }
}
