package level_01.module_02.class_04;

public class Man implements Hunter {
    @Override
    public void run() {
        System.out.println("正在奔跑。。。");
    }

    @Override
    public void hunt() {
        System.out.println("正在追赶猎物。。。");
    }

    public static void main(String[] args) {
        Runner m1 = new Man();
        m1.run();

        Hunter m2 = new Man();
        m2.hunt();
    }
}
