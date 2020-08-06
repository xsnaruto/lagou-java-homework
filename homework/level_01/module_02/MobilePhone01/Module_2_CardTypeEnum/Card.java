/**
 * 卡类型、卡号、用户名、密码、账户余额、通话时长(分钟)、上网流量 行为：显示（卡号 + 用户名 + 当前余额）
 */
public class Card {
    private int type;
    private int num;
    private String username;
    private String password;

    private double balance;

    private int callTime;
    private int dataUse;

    public void showInfo() {
        System.out.printf("卡号：\n", num);
        System.out.printf("姓名：\n", username);
        System.out.printf("余额：\n", balance);
    }
}
