public class Person {
    // 数据类型 成员变量名 = 初始值; - 其中 = 初始值 通常都省略不写;
    String name;
    int age;

    void show() {
        System.out.printf("姓名：%s，年龄：%d。\n", name, age);
    }

    // 自定义成员方法实现姓名修改
    void editName(String n) {
        name = n;
    }

    // 自定义成员方法实现年龄修改
    void editAge(int a) {
        age = a;
    }

    void editFull(String nn, int aa) {
        name = nn;
        age = aa;
    }

    // 可变长参数
    void showArg(String... arg) {
        for (int i = 0; i < arg.length; i++) {
            System.out.print(arg[i] + " ");
        }
        System.out.println();
    }

    // 自定义成员方法实现姓名数值的获取并返回数值
    String getName() {
        return name;
    }

    // 自定义成员方法实现年龄数值的获取并返回数值
    int getAge() {
        return age;
    }

    public static void main(String[] args) {

        System.out.println();

        // 1 声明 Person 类型的引用，指向 Person 类型的对象
        // 数据类型（类名） 引用变量名 = new 类名();
        Person p = new Person();

        // 2. 打印对象的成员变量值
        System.out.printf("姓名：%s，年龄：%d。\n", p.name, p.age);

        // 3. 修改变量数值
        p.name = "张三";
        p.age = 25;
        p.show();

        // 通过成员方法的调用实现成员方法的修改
        p.editName("李四");
        p.editAge(26);
        p.show();

        // 一个方法进行多数据修改
        p.editFull("王五", 27);
        p.show();

        System.out.println("---------------------------");
        // 可变长参数的使用
        p.showArg();
        p.showArg("张三");
        p.showArg("李四", "王五");
        
        System.out.println("---------------------------");
        // 通过成员方法调用实现成员变量数值的获取并打印 
        String str1 = p.getName();
        System.out.println("获取到的名字是：" + str1);
        int int1 = p.getAge();
        System.out.println("获取到的年龄是："+ int1);
    }
}