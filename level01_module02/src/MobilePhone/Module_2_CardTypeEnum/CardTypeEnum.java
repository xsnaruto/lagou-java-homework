package MobilePhone.Module_2_CardTypeEnum;

/**
 * 设计和实现以下枚举类 手机卡的类型总共有 3 种：普卡、小卡、微型卡;
 */
public enum CardTypeEnum {

    // 创建三个类型的卡，并定义不同类型卡的月租和名称
    NORMAL_SIM(20, "普卡"), MICRO_SIM(30, "小卡"), NANO_SIM(35, "微型卡");

    private final int moCost;
    private final String cardTypeName;

    /**
     * @return the moCost
     */
    public int getMoCost() {
        return moCost;
    }

    /**
     * @return the cardTypeName
     */
    public String getCardTypeName() {
        return cardTypeName;
    }
    
}