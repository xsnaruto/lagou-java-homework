package Module_3_Abstract;

/**
 * 创建一个套餐的抽象类，把语音套餐和流量套餐中相同的特征和行为组成在一起
 * 相同的特征有：资费；
 * 相同的行为有：打印套餐信息；
 */
public abstract class CostAbstract{
    private double cost; // 月消费金额

    public void showInfo(){ // 打印月消费金额
        System.out.printf("当月消费金额为：%d\n", cost);
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
