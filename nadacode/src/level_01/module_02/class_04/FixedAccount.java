package level_01.module_02.class_04;

public class FixedAccount extends Account {

    public FixedAccount(){}
//    public FixedAccount(int i) {
//        super(i); // 表示调用父类的有参构造方法
//    }

    @Override
    public double getLixi() {
        // TODO Auto-generated method stub
        return getMoney() * 0.03 * 1;
    }

    public static void main(String[] args) {
        // 1. 声明一个 Account 类型的引用，指向子类类型的对象，形成多
        Account acc = new FixedAccount();
        acc.setMoney(1000);
        double liXi = acc.getLixi();
        System.out.println("计算的利息是：" + liXi);
    }

}