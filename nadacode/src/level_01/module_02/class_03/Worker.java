public class Worker extends Person {

    private int salary;

    public Worker() {
        super(); // super() 表示调用父类的无参构造方法，若没有加，编译器会自动添加
        System.out.println("Worker()");
    }

    public Worker(String name, int age, int salary) {
        super(name, age); // 表示调用了父类的无参构造方法
        System.out.println("Worker(String name, int age, int salary)");
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary >= 2200 && salary <= 14999) {
            this.salary = salary;
        } else {
            System.out.println("薪水录入错误");
        }
    }

    // 自定义成员方法描述工作的行为
    public void work() {
        System.out.println("今天的砖有点烫手！");
    }

    @Override // 标注、注解，用于说明下面方法是对父类方法的重写；与注释区别：若没有构成重写，则编译报错
    public void show() {
        super.show(); // super. 表示调用父类的 show 方法
        System.out.println("我的薪水是：" + salary);
    }
}