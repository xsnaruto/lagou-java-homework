package Module_1_BasicClass;

/**
 * 用户消费信息类 特征：统计通话、短信、流量信息，以及每月消费金额
 */
public class User extends Card {

    private int callTime; // 通话时长
    private int messageNum; // 短信条数
    private int dataUse; // 数据流量
    private int moBill; // 月租

    /**
     * 调用父类 Card 的构造方法初始化子类 User 的数据
     *
     * @param typeChoice 记录用户选择的卡类型
     * @param number
     * @param name
     * @param username
     * @param password
     * @param balance
     */
    public User(int typeChoice, String number, String name, String username, String password, double balance) {
        super(typeChoice, number, name, username, password, balance);
    }


    public int getCallTime() {
        return callTime;
    }

    public void setCallTime(int callTime) {
        this.callTime = callTime;
    }

    public int getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(int messageNum) {
        this.messageNum = messageNum;
    }

    public int getDataUse() {
        return dataUse;
    }

    public void setDataUse(int dataUse) {
        this.dataUse = dataUse;
    }

    public int getMoBill() {
        return moBill;
    }

    public void setMoBill(int moBill) {
        this.moBill = moBill;
    }

    /**
     * 用于打印用户的消费账单
     */
    public void showUserInfo() {
        System.out.println("套餐通话时长：" + getCallTime() + "分钟");
        System.out.println("已用通话时长：" + getCallTime() + "分钟");
        System.out.println("--------------------");
        System.out.println("套餐包含短信：" + getMessageNum() + "条");
        System.out.println("已用短信用量：" + getMessageNum() + "条");
        System.out.println("--------------------");
        System.out.println("套餐包含流量：" + getDataUse() + "兆");
        System.out.println("已用流量用量：" + getDataUse() + "兆");
        System.out.println("--------------------");
        System.out.println("套餐月租费用：" + getMoBill() + "元");
        System.out.println("当月消费费用：" + getMoBill() + "元");
        System.out.println("当前应缴费用：" + getMoBill() + "元");
    }
}
