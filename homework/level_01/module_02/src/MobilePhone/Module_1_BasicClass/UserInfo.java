/**
 * 用户消费信息类 特征：统计通话、短信、流量信息，以及每月消费金额
 */
public class UserInfo {
    private String name;
    private String number;

    private int callTime; // 通话时长
    private int messageNum; // 短信条数
    private int dataUse; // 数据流量
    private int moBill; // 月租

    /**
     * 有参构造方法，创建新用户时，初始化客户可用的「通话时长」「短信条数」「数据流量」「月租」
     * 
     * @param callTime
     * @param messageNum
     * @param dataUse
     * @param moBill
     */
    public UserInfo(int callTime, int messageNum, int dataUse, int moBill) {
        setCallTime(callTime);
        setMessageNum(messageNum);
        setDataUse(dataUse);
        setMoBill(moBill);
    }

    /**
     * @return the callTime
     */
    public int getCallTime() {
        return callTime;
    }

    /**
     * @param callTime the callTime to set
     */
    public void setCallTime(int callTime) {
        this.callTime = callTime;
    }

    /**
     * @return the messageNum
     */
    public int getMessageNum() {
        return messageNum;
    }

    /**
     * @param messageNum the messageNum to set
     */
    public void setMessageNum(int messageNum) {
        this.messageNum = messageNum;
    }

    /**
     * @return the dataUse
     */
    public int getDataUse() {
        return dataUse;
    }

    /**
     * @param dataUse the dataUse to set
     */
    public void setDataUse(int dataUse) {
        this.dataUse = dataUse;
    }

    /**
     * @return the moBill
     */
    public int getMoBill() {
        return moBill;
    }

    /**
     * @param moBill the moBill to set
     */
    public void setMoBill(int moBill) {
        this.moBill = moBill;
    }

    public void showUserInfo() {
        System.out.println("");
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 用于打印用户的消费账单
     */
    public void showUserInfo() {
        System.out.println("姓名：" + getName());
        System.out.println("号码：" + getNumber());
        System.out.println("--------------------");
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
