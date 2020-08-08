package MobilePhone.Module_2_CardTypeEnum;

/**
 * 设计和实现以下枚举类 手机卡的类型总共有 3 种：普卡、小卡、微型卡;
 */
public enum CardTypeEnum {

    // 创建三个类型的卡，并定义不同类型卡的月租和名称
    NORMAL_SIM(1, 15, "普卡"), MICRO_SIM(2, 20, "小卡"), NANO_SIM(3, 30, "微型卡");

    private int id; // 不同卡片类型对应的 id
    private double moCost; // 不同卡片的月租
    private String typeName; // 不同卡片的「名称」

    /**
     * 通过枚举类构造方法指定不同类型的自定义值
     * @param id 不同卡片类型对应的 id
     * @param moCost // 不同卡片的月租
     * @param typeName // 不同卡片的「名称」
     */
    CardTypeEnum(int id, double moCost, String typeName){
        this.id = id;
        this.moCost = moCost;
        this.typeName = typeName;
    }

    public double getMoCost() {
        return moCost;
    }

    public String getTypeName() {
        return typeName;
    }
}
