import Module_1_BasicClass.User;
import Module_4_Interface.CallInterface;
import Module_4_Interface.CallInterfaceUse;
import Module_4_Interface.DataInterface;
import Module_4_Interface.DataInterfaceUse;

import java.util.Scanner;

/**
 * 测试类，模拟用户购卡，使用，计费流程
 * 1. 提示用户录入数据，利用数据创建一个新的 User 对象
 * 2. 提示用户根据提供的选项输入信息，并进入对应流程
 * 3. 提供「打印通信账单」「打印流量账单」「更新使用量」「退出系统」
 */
public class Test {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
          提示用户输入对应数据，并使用数据创建新用户
         */
        System.out.println("请根据提示输入卡片信息");
        System.out.print("请选择卡类型 1.普卡 2.小卡 3.微型卡：");
        int typeChoice = sc.nextInt(); // 记录用户选择的普卡、小卡、微型卡卡类型

        System.out.print("请输入想要的卡号：");
        String number = sc.next(); // 卡号
        System.out.print("请输入姓名：");
        String name = sc.next(); // 持卡人姓名
        System.out.print("请输入用户名：");
        String username = sc.next(); // 用户名
        System.out.print("请输入密码：");
        String password = sc.next(); // 密码
        System.out.print("请输入充值金额：");
        double balance = sc.nextInt() * 1.0; // 初始充值金额

        // 将上面的数据整合，创建一个新的 User 用户类
        User u = new User(typeChoice, number, name, username, password, balance);
        u.showInfo(); // 创建新用户后，调用 Card 类中的方法，打印新用户的基本数据

        /*
          通过 do while 循环执行数据的「变更」和「查询」功能
         */
        do {
            System.out.println("1.查询通信账单\t2.查询流量账单\n3.更新用量\t\t4. 退出系统");
            System.out.print("请输入序号进入对应功能：");
            int choice = sc.nextInt();

            if (choice == 1) {
                CallInterface ci = new CallInterfaceUse();
                ci.callInterface(u, u.getCallTime(), u.getMessageNum());
            } else if (choice == 2) {
                DataInterface di = new DataInterfaceUse();
                di.dataInterface(u, u.getDataUse());
            } else if (choice == 3) {
                System.out.print("请输入已通话时间(分钟）：");
                u.setCallTime(sc.nextInt());
                System.out.print("请输入短信已用（条）：");
                u.setMessageNum(sc.nextInt());
                System.out.print("请输入流量用量（兆 MB）：");
                u.setDataUse(sc.nextInt());
            } else if (choice == 4) {
                System.exit(0);
            }
        } while (true);
    }
}
