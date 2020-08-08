package MobilePhone.Module_4_Interface;

import MobilePhone.Module_1_BasicClass.User;
import MobilePhone.Module_3_Abstract.CostAbstract;
import MobilePhone.Module_3_Abstract.SubDataCost;

/**
 * 通过 DataInterface 接口类指定的数据来进行功能实现
 */
public class DataInterfaceUse implements DataInterface {

    /**
     * 通过传入的数据来执行数据流量类功能的作用
     * @param u User 类的对象
     * @param dataUse 已用流量
     */
    @Override
    public void dataInterface(User u, int dataUse) {
        System.out.println("数据流量类接口的实现");
        CostAbstract moBill = new SubDataCost(dataUse);
        u.setBalance(u.getBalance() - moBill.getCost()); // 使用卡类的余额数减去消费金额获取当前余额
        u.showInfo(); // 打印卡类基本信息
        System.out.println("------------------------------");
        moBill.showInfo(); // 打印流量类账单信息
    }
}
