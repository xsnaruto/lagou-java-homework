package Module_4_Interface;

import Module_1_BasicClass.User;
import Module_3_Abstract.CostAbstract;
import Module_3_Abstract.SubCallCost;

/**
 * 通过 CallInterface 接口类指定的数据来进行功能实现
 */
public class CallInterfaceUse implements CallInterface {

    /**
     * 通过传入的数据来执行通信类功能的作用
     * @param u 用户类，调用用户对象
     * @param callTime 通话时间
     * @param messageNum 短信用量
     */
    @Override
    public void callInterface(User u, int callTime, int messageNum) {
        System.out.println("通话短信类型接口实现：");
        CostAbstract moBill = new SubCallCost(callTime, messageNum);
        u.setBalance(u.getBalance() - moBill.getCost()); // 使用卡类的余额数减去消费金额获取当前余额
        u.showInfo(); // 打印卡类基本信息
        System.out.println("--------------------------");
        moBill.showInfo(); // 打印通信类的账单信息
    }
}
