/**
 * Student
 */
public class Student {

    // 1. 私有化成员变量，使用 private 关键字修饰
    // private 关键字修饰表示私有的含义，该成员变量只能在当前方法内部中使用
    private int id; // 用于描述学生学号
    private String name; // 用于描述学生姓名

    // 在公有的构造方法中调用 set 方法进行合理值的判断
    public Student() {
    }

    public Student(int id, String name) {
        // this.id = id;
        // this.name = name;

        setID(id);
        setName(name);
    }

    // 2. 提供共有的 get 和 set 方法，并在方法中进行合理值的判断
    public int getID() {
        return id;
    }

    public void setID(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("学号错误");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void show() {
        System.out.printf("我叫%s，学号是%d。\n", getName(), getID());
    }
}