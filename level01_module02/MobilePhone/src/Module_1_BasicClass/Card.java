package Module_1_BasicClass;

import Module_2_CardTypeEnum.CardTypeEnum;

/**
 * 卡类型、卡号、用户名、密码、账户余额、通话时长(分钟)、上网流量 行为：显示（卡号 + 用户名 + 当前余额）
 */
public class Card {
    private CardTypeEnum type; // 卡类型
    private String number; // 卡号
    private String name; // 姓名
    private String username; // 用户名
    private String password; // 密码

    private double balance; // 余额

    /**
     * 通过构造方法给新卡赋值
     *
     * @param typeChoice 用户选择的卡类型 id
     * @param number 卡号
     * @param name 姓名
     * @param username 用户名
     * @param password 密码
     * @param balance 余额
     */
    public Card(int typeChoice, String number, String name, String username, String password, double balance) {
        // 通过 if 语句从卡类型的枚举类中设定对应的类型
        if (typeChoice == 1) {
            setType(CardTypeEnum.NORMAL_SIM);
        } else if (typeChoice == 2) {
            setType(CardTypeEnum.MICRO_SIM);
        } else if (typeChoice == 3) {
            setType(CardTypeEnum.NANO_SIM);
        }
        setNumber(number);
        setName(name);
        setUsername(username);
        setPassword(password);
        setBalance(balance);
    }

    /**
     * 测试中需要用到的 get 和 set 方法
     */
    public void setType(CardTypeEnum type) {
        this.type = type;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * showInfo 方法，用于展示卡片的基础信息
     * 展示内容：卡类名称、卡号、用户姓名、卡片余额
     */
    public void showInfo() {
        System.out.println("--------------------------------");
        System.out.printf("卡片类型：%s，固定月租：%.2f\n", type.getTypeName(), type.getMoCost());
        System.out.printf("卡号：%s\n", number);
        System.out.printf("姓名：%s\n", username);
        System.out.printf("余额：%.2f\n", balance);
        System.out.println();
    }
}
