package level_01.module_02.class_02;

/**
 * Person
 */
public class Person {

    String name;
    int age;

    // 自定义构造方法
    Person(String name, int age) {
        // System.out.println("我就是自定义的构造方法！");
        // name = "张三";
        // age = 28;
        this.name = name; // 使用 this 关键字，指定 name 为当前成员方法中的变量而不是成员变量
        this.age = age; // 使用 this 关键字，作用同上
    }

    Person() {

    }

    // 自定义成员方法实现所有特征的打印
    void show() {
        this.grow();
        System.out.println("我是" + name + "，今年 " + age + " 岁了。");
    }

    // 自定义成员方法实现年龄增长 1 岁
    void grow() {
        age++;
    }

    // 自定义成员方法实现年龄增长参数指定数值的行为
    void grow(int i) {
        age += i;
    }

    // 自定义成员方法实现 Person 类型对象的获取并返回的行为
    Person getPerson() {
        // 返回当前调用对象的本身 Person tp = new Person(); return tp;
        return this;
    }

    public static void main(String[] args) {

        // 1. 声明一个 Person 类型的引用指向 Person 类型的对象
        Person p1 = new Person("张三", 28);

        // 打印特征
        p1.show(); // 0

        System.out.println("-----------------------------");
        Person p2 = new Person("李四", 30);
        p2.show();

        // 根据参数类型自动化调用对应的构造方法
        System.out.println("-----------------------------");
        Person p3 = new Person();
        p3.show();

        System.out.println("-----------------------------");
        // 实现重载方法的调用和测试
        p1.grow();
        p1.show();
        
        p2.grow(5);
        p2.show();
        
        System.out.println("-----------------------------");
        Person p4 = p1.getPerson();
        System.out.println("p1 = "+ p1);
        System.out.println("p4 = "+ p4);
    }
}