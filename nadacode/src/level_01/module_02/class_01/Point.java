package level_01.module_02.class_01;

/**
 * Point
 */
public class Point {

    int x; // 描述横坐标
    int y; // 描述纵坐标

    void show() {
        System.out.println("行坐标是：" + x + ", 纵坐标是：" + y + "。");
    }

    void setPoint(int xx, int yy) {
        x = xx;
        y = yy;
    }

    // 自定义方法实现 int 类型的可变长参数使用
    void showArg(int... args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("下标 " + i + "的元素是 " + args[i]);
        }
    }

    // 获取横纵坐标的值并且打印
    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    public static void main(String[] args) {

        // 1. 声明一个引用指向 point 类型的对象
        Point p = new Point();

        // 2. 打印成员变量值
        System.out.println("横坐标：" + p.x);
        System.out.println("纵坐标：" + p.y);

        System.out.println("========================");
        // 3. 修改横纵为 3 和 5
        p.x = 3;
        p.y = 5;

        // 4. 再次打印成员变量值
        // System.out.println("横坐标：" + p.x);
        // System.out.println("纵坐标：" + p.y);
        p.show();

        System.out.println("-----------------");
        p.setPoint(88, 99);
        p.show();

        System.out.println("--------------------------");
        p.showArg(1, 2, 3, 5, 7, 8, 9);

        System.out.println("--------------------------");
        int xX = p.getX();
        System.out.println("X 的结果是：" + xX);
        int yY = p.getY();
        System.out.println("Y 的结果是：" + yY);
    }
}