/**
 * Person
 */
public class Person {

    // 1. 私有化成员变量，使用 private 关键字修饰
    private String name;
    private int age;

    // 3. 在构造方法中调用 set 方法进行合理值判断
    public Person() {
        System.out.println("Person()");
    }

    public Person(String name, int age) {
        System.out.println("Person(String name, int age)");
        setName(name);
        setAge(age);
    }

    // 2. 提供公有的 get 和 set 办法，并进行合理值判断
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 120) {
            this.age = age;
        } else {
            System.out.println("年龄输入错误！");
        }
    }

    // 自定义成员方法打印数据
    public void show() {
        System.out.printf("我是%s，今年%d岁。\n", getName(), getAge());
    }

    // 自定义成员方法描述吃饭的行为
    public void eat(String food) {
        System.out.println(food + "真好吃！");
    }

    // 自定义成员方法描述娱乐的行为
    public void play(String game) {
        System.out.println(game + "真好玩！");
    }

}
