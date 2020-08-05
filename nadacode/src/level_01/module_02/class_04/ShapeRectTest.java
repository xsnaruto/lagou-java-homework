package level_01.module_02.class_04;

public class ShapeRectTest {
    public static void main(String[] args) {
        // 1. 声明 Shape 类型的引用，指向 Shape 类型的对象，并打印特征
        Shape s1 = new Shape(1, 2);
        s1.show();

        System.out.println("---------------------------------");
        // 2. 声明 Rect 类型的引用，指向 Rect 类型的对象，并打印特征
        Rect r1 = new Rect(3, 4, 5, 6);
        r1.show();

        System.out.println("---------------------------------");
        // 3. 声明 Shape 类型，指向 Rect 类型的对象，并打印特征
        Shape s2 = new Rect(7, 8, 9, 10);
        s2.show();

        System.out.println("---------------------------------");
        // 4. 测试 Shape 类型的引用能否调用父类和子类中独有的方法
        int i = s2.getX();
        // int i = s2.getLen(); // Shape 类中没有 getLen() 方法；
        int j = r1.getLen();
        System.out.println(i);
        System.out.println(j);

        s1.test();
        Shape.test();
        r1.test();
        Rect.test();
        s2.test();

        System.out.println("---------------------------------");
        // 5. 通过强转方式使父类调用子类的方法
        // int s2Len = s2.getLen();
        int s2Len = ((Rect) s2).getLen();
        System.out.println(s2Len);
    }
}
