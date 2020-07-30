/**
 * 编程实现 People 类的封装
 */
public class People {

    // 1. 私有化成员变量，使用 private
    private String name;
    private int age;
    // private String country;  // 隶属于对象层级，每个对象都拥有独立一份内存空间
    // public static String country;  // 隶属于类层级，整个类共用一份，并被共享
    private static String country;

    // 创建两个构造方法，一个有参一个无参
    People() {
    }

    People(String name, int age, String country) {
        setName(name);
        setAge(age);
        // setCountry(country);
    }

    // 2. 提供共有的 get 和 set 方法，并在方法体中进行合理值判断
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

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        // this.country = country;
        People.country = country;
    }

    public void show() {
        System.out.printf("姓名：%s，年龄：%d，国籍：%s\n", getName(), getAge(), getCountry());
    }

}