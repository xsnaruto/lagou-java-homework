package Module_3_Abstract;

public class SubDataCost extends CostAbstract {
    private int dataUse; // 已使用的数据流量
    private double dataCost; // 数据流量的花费

    /**
     * 构造方法，赋值「流量用量」，同时计算出「流量花费」并赋值
     *
     * @param dataUse 流量使用量
     */
    public SubDataCost(int dataUse) {
//        u.setDataUse(dataUse);
        this.dataUse = dataUse;
        this.dataCost = dataUse * 0.1; // 流量资费设置为 1MB/0.01元
        super.setCost(super.getCost() + getDataCost()); // 把流量类的花费加入到父类中总消费数
    }

    /**
     * 成员变量的 get set 方法
     *
     * @return 「流量用量」「流量花费」
     */
    public int getDataUse() {
        return dataUse;
    }

    public double getDataCost() {
        return dataCost;
    }

    /**
     * showInfo 方法重写，将对应流量类型的「用量」和「费用」打印出来
     */
    @Override
    public void showInfo() {
        System.out.printf("已用流量：%d 兆\n", getDataUse());
        System.out.printf("流量费用：%.2f 元\n", getDataCost());
        System.out.println();
    }
}
