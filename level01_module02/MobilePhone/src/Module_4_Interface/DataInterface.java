package MobilePhone.Module_4_Interface;

import MobilePhone.Module_1_BasicClass.User;

/**
 * 上网服务接口 抽象方法: 参数1: 上网流量, 参数2: 手机卡类对象 让上网套餐类实现上网服务接口。
 */
public interface DataInterface {

    /**
     * 抽象方法用于描述数据流量类的服务
     * @param u User 类的对象
     * @param dataUse 已用流量
     */
    void dataInterface(User u, int dataUse);
}