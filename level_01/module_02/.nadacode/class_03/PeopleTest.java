import java.util.Scanner;

/**
 * PeopleTest
 */
public class PeopleTest {

    public static void main(String[] args) {
        // 3. 验证 static 关键字修饰的静态成员是否与创建对象无关
        System.out.println("获取到的国际信息是：" + People.getCountry());

        // 1.1 通过有参方式初始化方法数值，调用并打印
        People p1 = new People("张三", 23, "中国");
        People.setCountry("西班牙");
        p1.show();

        // 1.2. 通过提示用户输入参数内容，调用方法进行打印
        People p2 = new People();
        Scanner sc = new Scanner(System.in);
        System.out.print("输入姓名：");
        p2.setName(sc.next());

        System.out.print("输入年龄:");
        p2.setAge(sc.nextInt());

        System.out.print("输入国籍:");
        People.setCountry(sc.next());

        sc.close();
        p2.show();

        System.out.println("--------------------------------------");

        // 2. 验证 static 关键字修饰的成员是否被所有对象共享
        People.setCountry("英国");
        System.out.println("第一个对象的国籍是：" + People.getCountry());
        System.out.println("第二个对象的国籍是：" + People.getCountry());

        People p3 = new People();
        System.out.println("P3 = " + p3.getName());
        System.out.println("第三个对象的国籍是：" + People.getCountry());
    }
}