package nadacode.task09;

public abstract class Account {
    private int money;

    /**
     * 创建无参构造方法
     */
    public Account() {
    }

    /**
     * 创建有参构造方法，设置 money
     */
    public Account(int money) {
        setMoney(money);
    }

    /**
     * @return the money
     */
    public int getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(int money) {
        this.money = money;
    }

    // 自定义抽象方法，计算利息并返回的功能描述
    public abstract double getLixi();

}