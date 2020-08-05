package level_01.module_02.class_04;

public class DogTest {
    public static void main(String[] args) {
        // 创建一个对象
        Dog d1 = new Dog();
        d1.show();

        System.out.println("----------------------------------");

        Dog d2 = new Dog("边牧", "金色", 88);
        d2.show();
    }
}
