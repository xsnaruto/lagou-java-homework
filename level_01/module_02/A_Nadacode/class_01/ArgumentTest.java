/**
 * ArgumentTest
 */
public class ArgumentTest {

    // 打印传输参数
    void show1(int aa) {
        System.out.println("show 方法中的 aa = " + aa);
    }

    void show2(int[] arr1) {
        arr1 = new int[2]; // 创建新的数组，arr1 指向了新的内存地址
        arr1[0] = 199; // 注意代码执行的顺序，arr1 和 arr2 当前指向相同的对内存地址
        System.out.println("show 方法中的 arr1[0] = " + arr1[0]);
    }

    public static void main(String[] args) {

        // 1. 声明 ArgumentTest 类型的引用指向该类型的对象
        ArgumentTest at = new ArgumentTest();

        // 2. 使用引用变量调用show 方法 进行测试
        int bb = 10;
        at.show1(bb);

        System.out.println("-----------------------------------------");
        // 3. 效用 show 2 方法进行测试
        int[] arr2 = { 19, 28 };
        at.show2(arr2);
        System.out.println("main 方法中 arr2[0] = " + arr2[0]);

    }
}
