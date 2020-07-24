
/**
 * 自定义数组扩容规则
 * 当已存储元素数量达到总容量的 80%时，扩容 1.5 倍。
 */

import java.util.Scanner;

public class DilatationArray {

    public static void main(String[] args) {
        // 1. 初始化一个长度为 10 的数组，并创建一个变量用来接收之后用户输入数据的次数
        String[] strArr = new String[10];
        int inputTime = 0;
        Scanner sc = new Scanner(System.in);

        // 2. 通过 for 循环，提示用户输入数据，并将数据赋值给数组内的元素
        for (int i = 0; i <= inputTime; i++) { // 无限循环即可，用 i<=inputTime 可搭配 5.1 步的 i++ 跳出循环
            System.out.print("请输入数据：");
            strArr[i] = sc.nextLine();
            inputTime++;

            // 展示数据用于检查代码
            System.out.printf("输入次数：%d，循环次数：%d，数组长度：%d，临界长度：%d。\n", inputTime, i, strArr.length, strArr.length * 8 / 10);
            System.out.println("-----------------------------------------");

            // 3. 判断是否存储内容超过总容量 80%，如果超过就询问用户是否继续输入数据
            while (inputTime >= (strArr.length * 8 / 10)) {
                System.out.print("扩容并续存请输入：y / 打印并退出请输入 n：");
                String choice = sc.nextLine();

                // 4. 根据用户录入内容进入对应流程
                switch (choice) {

                    // 5.1. 使用 for 循环将数组所有元素进行打印（可能存在空内容，所以不使用 toString)
                    case "n":
                        sc.close();
                        System.out.println("=========================================");
                        System.out.print("完整数组数据为：");
                        for (int j = 0; j < inputTime - 1; j++) {
                            System.out.print(strArr[j] + ", ");
                        }
                        System.out.println((strArr[inputTime - 1]));
                        System.out.println("-----------------------------------------");
                        System.out.println("程序已退出。");

                        i++; // i++ 后再加上第一层 for 循环的 i++，使 i>inputTime，结束循环
                        System.exit(0); // 退出 Java 程序

                        // 5.2. 创建新数组，长度为旧数组长度的 1.5 倍，创建成功后将 strArr 引用地址指向新数组的内存地址
                    case "y":
                        String[] tmpArr = new String[strArr.length + (strArr.length >> 1)]; // 给位移运算符添加括号
                        // System.out.println(strArr.length + ", " + (strArr.length >> 1));
                        System.arraycopy(strArr, 0, tmpArr, 0, inputTime); // 将旧数组的数据复制到新的数组
                        strArr = tmpArr; // 将旧数组的引用内存地址指向新的数组地址（旧数组引用内存地址无使用时会被释放）
                        break;

                    // 5.3. 输入错误时跳回 while 循环开始处提示用户重新输入
                    default:
                        System.out.println("输入错误，请重新输入:");
                        continue;
                }
            }
        }

        // ============================================================================================

        // // 1. 初始化一个长度为 10 的数组，并创建一个变量用来接收之后用户输入数据的次数
        // String[] strArr = new String[10];
        // int inputTime = 0;
        // Scanner sc = new Scanner(System.in);

        // String choice = "y"; // 提前创建一个变量用来记录步骤 3 用户进行的选择，方便用来跳出第一层的 while 循环

        // // 2. do while 循环，先提示用户输入数据并赋值给数组
        // do {
        //     System.out.println("请输入数据：");
        //     strArr[inputTime] = sc.nextLine();
        //     inputTime++;

        //     // 3. 创建第二层 while 循环，当用户输入次数超过了数组内存的 80，提示用户进行选择
        //     while (inputTime >= (strArr.length * 8 / 10)) {
        //         System.out.print("扩容并续存请输入：y / 打印并退出请输入 n：");
        //         choice = sc.nextLine();

        //         // 3.1. 根据用户录入内容进入对应流程
        //         switch (choice) {

        //             // 3.1.1. 使用 for 循环将数组所有元素进行打印（可能存在空内容，避免打印 null 所以不使用 toString)
        //             case "n":
        //                 sc.close();
        //                 System.out.println("=========================================");
        //                 System.out.print("完整数组数据为：");
        //                 for (int j = 0; j < inputTime - 1; j++) {
        //                     System.out.print(strArr[j] + ", ");
        //                 }
        //                 System.out.println((strArr[inputTime - 1]));
        //                 System.out.println("-----------------------------------------");
        //                 System.out.println("程序已退出。");

        //                 // 3.1.2. 创建新数组，长度为旧数组长度的 1.5 倍，创建成功后将 strArr 引用地址指向新数组的内存地址
        //             case "y":
        //                 String[] tmpArr = new String[strArr.length + (strArr.length >> 1)]; // 给位移运算符添加括号
        //                 System.arraycopy(strArr, 0, tmpArr, 0, inputTime); // 将旧数组的数据复制到新的数组
        //                 strArr = tmpArr; // 将旧数组的引用内存地址指向新的数组地址（旧数组引用内存地址无使用时会被释放）
        //                 break; // strArr[] 引用地址更新后，跳出第二层 while 循环，继续执行用户数据录入

        //             // 3.1.3. 当输入内容不是 y 也不是 n 时，跳回当前 while 循环开始处，提示用户重新输入
        //             default:
        //                 System.out.println("输入错误，请重新输入:");
        //                 continue; // 重新开始当前循环，提示用户进行选择
        //         }
        //     }
        // } while (choice.equals("y")); // 步骤 1 初始化 choice 为 y 用来保持最开始的循环；步骤 3 对 choice 的值进行修改，如果是 n 则结束循环

    }
}