/**
 * Singleton
 */
public class Singleton {

    // 2. 声明本类类型的引用指向本类类型的对象，使用 private static 关键字共同修饰
    private static Singleton sin = new Singleton();

    // 1. 私有化构造方法，使用 private 关键字修饰
    private Singleton() {
    }; // 设置 private 使得方法无法创建对象

    // 3. 提供公有的 get 方法负责将对象返回出去，使用 public static 关键字共同修饰
    public static Singleton getInstance() {
        return sin;
    }
}