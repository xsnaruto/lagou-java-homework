/**
 * WorkerTest
 */
public class WorkerTest {

    public static void main(String[] args) {
        
        // 1. 使用无参方式构造 Worker 类型的对象并打印特征
        Worker w1 = new Worker();
        // 当子类调用 show 方法后，则下面调用的是重写以后的版本
        w1.show();
        
        
        System.out.println("------------------------------");
        
        // 2. 使用有参方式构造 Worker 类型的对象并打印特征
        Worker w2 = new Worker("张三", 18, 2500);
        // 当子类调用 show 方法后，则下面调用的是重写以后的版本
        w2.show();
        
        // 调用成员方法测试
        w2.eat("豆芽");
        w2.play("王者荣耀");
        w2.work();
    }
}