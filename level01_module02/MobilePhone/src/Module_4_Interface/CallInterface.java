package Module_4_Interface;

import Module_1_BasicClass.User;

/**
 * 通话服务接口 抽象方法: 参数1: 通话分钟, 参数2: 手机卡类对象 让通话套餐类实现通话服务接口;
 */
public interface CallInterface {

    /**
     * 抽象方法用于描述通话短信类的服务
     *
     * @param callTime 通话时间
     * @param messageNum 短信用量
     */
    void callInterface(User u, int callTime, int messageNum);
}