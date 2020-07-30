/**
 * Point
 */
public class Point {

    int x;
    int y;

    Point() {

    }

    Point(int i, int j) {
        x = i;
        y = j;
    }

    void show() {
        System.out.println("x 是：" + x + " y 是：" + y);
    }

    // 自定义成员方法实现纵坐标减 1
    void up() {
        y--;
    }

    // 自定义成员方法实现纵坐标减去参数指定值
    void up(int i) {
        y -= i;
    }

    public static void main(String[] args) {

        // 1. 使用无参方式打印
        Point p1 = new Point();
        p1.show();

        // 2. 使用有参方式打印
        Point p2 = new Point(9, 7);
        p2.show();

        System.out.println("---------------------------");
        p2.up(); 
        p2.show(); // 9,6
        System.out.println("---------------------------");
        p2.up(3);
        p2.show(); // 9,3
    }
}