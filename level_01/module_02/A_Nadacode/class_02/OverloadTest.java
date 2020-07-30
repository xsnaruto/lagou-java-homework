/**
 * OverloadTest
 */
public class OverloadTest {

    // 自定义成员方法
    void show() {
        System.out.println("show()");
    }

    void show(int i) { // 体现在方法参数的个数不同
        System.out.println("show(int)");
    }

    void show(int i, double d) { // 体现在方法参数的个数不同
        System.out.println("show(int, double)");
    }
    
    void show(int i, int j) { // 体现在方法参数的类型不同
        System.out.println("show(int, int)");
    }
    
    void show(double d, int i) { // 体现在方法参数的顺序不同
        System.out.println("show(double, int)");
    }

    // 错误，与参数的变量名无关
    // void show(double a, int b) { 
    //     System.out.println("show(double, int)");
    // }

    // 错误，与返回值类型无关
    // int show(double d, int i) { 
    //     System.out.println("show(double, int)");
    // }

    public static void main(String[] args) {

        // 1. 声明 OverloadTest 类型的引用指向该类型的对象
        OverloadTest ot = new OverloadTest();
        // 2. 调用 show 方法
        ot.show();
        ot.show(66);
        ot.show(55, 4.44);
        ot.show(33, 11);
        ot.show(1.23, 585);
        // ot.show(1.23, 585);
    }
}
