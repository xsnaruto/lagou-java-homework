/**
 * Boy
 */
public class Boy {

    String name;

    // 自定义构造方法
    Boy() {
        // 调用本类中的有参构造方法
        // this("无名");
        System.out.println("无参构造方法");
    }

    Boy(String name) {
        // 调用本类中的无参构造方法
        this(); // 和无参构造 Boy 方法的 this 同时调用会导致死循环
        System.out.println("有参构造方法！");
        this.name = name;
    }

    // 自定义成员方法实现特征的打印
    void show() {
        System.out.println("我的名字是：" + name);
    }

    public static void main(String[] args) {
        System.out.println();

        // 1. 使用无参方式构造对象并答应特征
        Boy b1 = new Boy();
        b1.show();

        System.out.println("------------------------------------");
        
        // 2. 使用有参构造方法构造对象并打印特征
        Boy b2 = new Boy("张三");
        b2.show();

        System.out.println("------------------------------------");

        // 3. 引用变量的数值可以为空
        // Boy b3 = null; // 创建一个空的引用内存空间，可以正常编译
        // b3.show(); // 使用的时候会报错：空指针异常
        Boy b3 = b2; // 在栈区空间创建一个空间，指向 b2 的堆内存空间
        b3.show(); // b3.show(); == b2.show();



    }
}