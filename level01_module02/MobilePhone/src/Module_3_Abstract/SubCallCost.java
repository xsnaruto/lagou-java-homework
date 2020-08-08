package Module_3_Abstract;

public class SubCallCost extends CostAbstract {
    private int callTime; // 通话时间
    private int messageNum; // 短信用量
    private double callCost; // 通信类的花费

    /**
     * 通过传入的通话时间和短信条数，计算通信类的花费，并将数值赋值给当前类成员变量
     * 通过 super 方法获取当前卡片消费金额，加上通信类消费后重新通过 super 赋值到父类的总消费里面
     *
     * @param callTime
     * @param messageNum
     */
    public SubCallCost(int callTime, int messageNum) {
        this.callTime = callTime;
        this.messageNum = messageNum;
        this.callCost = callTime * 0.2 + messageNum * 0.1; // 默认设置通话 2毛/分钟，短信 1毛/条
        super.setCost(super.getCost() + this.callCost); // 把通信类的花费加入到父类中总消费数
    }

    public int getCallTime() {
        return callTime;
    }

    public int getMessageNum() {
        return messageNum;
    }

    public double getCallCost() {
        return callCost;
    }

    /**
     * 通过重写父类的 showInfo 方法，打印出通信类的账单信息
     */
    @Override
    public void showInfo() {
        System.out.printf("通话时长：%d 分钟\n", getCallTime());
        System.out.printf("通话时长：%d 条\n", getMessageNum());
        System.out.printf("通信费用：%.2f 元\n", getCallCost());
        System.out.println();
    }
}
