package MobilePhone.Module_1_BasicClass;

/**
 * 通话套餐类 特征：通话时长、短信条数、每月资费 行为: 显示所有套餐信息;
 */
public class PhonePlan {
    private static int callTime; // 通话时长
    private static int messageNum; // 短信用量
    private static double callMoBill; // 通话月账单金额

    /**
     * @return the callTime
     */
    public static int getCallTime() {
        return callTime;
    }

    /**
     * @param callTime the callTime to set
     */
    public static void setCallTime(int callTime) {
        PhonePlan.callTime = callTime;
    }

    /**
     * @return the messageNum
     */
    public static int getMessageNum() {
        return messageNum;
    }

    /**
     * @param messageNum the messageNum to set
     */
    public static void setMessageNum(int messageNum) {
        PhonePlan.messageNum = messageNum;
    }

    /**
     * @return the moBill
     */
    public static double getMoBill() {
        return moBill;
    }

    /**
     * @param moBill the moBill to set
     */
    public static void setMoBill(double moBill) {
        PhonePlan.moBill = moBill;
    }

    // 展示套餐信息
    public static void showInfo() {
        System.out.printf("通话时常：%d 分钟\n", callTime);
        System.out.printf("短信用量：%d 条\n", messageNum);
        System.out.printf("本月账单：%d 元\n", callMoBill);
    }
}
