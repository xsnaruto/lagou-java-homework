package level_01.module_02.class_04;

public class ShapeTest {
    public static void show(Shape s){
        s.show();
    }

    public static void main(String[] args) {
        // Rect r = new Rect(1, 2, 3, 4);
        ShapeTest.show(new Rect(11,22,33,44));
        ShapeTest.show(new Circle(55,66,77));

    }
}
