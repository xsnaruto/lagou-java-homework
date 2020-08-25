import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public abstract class StudentSystem {
    private static final List<Student> stuSys = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    /**
     * 添加学生功能 1. 提示用户输入学号、姓名、年龄信息 2. 使用用户输入的信息，在系统中创建一个新的集合元素
     */
    static public void addStu() {
        System.out.print("请输入学号：");
        String id = sc.next();
        System.out.print("请输入姓名：");
        String name = sc.next();
        System.out.print("请输入年龄：");
        int age = sc.nextInt();

        stuSys.add(new Student(id, name, age));
    }

    /**
     * 查找学生功能 1. 判断用户输入的是否为纯数字，如果是，则根据学号进行查找 2. 用户如果输入的不是纯数字内容，则根据姓名进行查找
     *
     * @return 返回查找的学生数据对应的 Index，方便修改数据方法的调用
     */
    static public int searchStu() {
        System.out.print("请输入学号或姓名：");
        String searchTerm = sc.next();

        // 如果用户输入的是纯数字的内容，那么根据学号进行查找
        // 如果用户输入的关键词不是纯数字的内容，那么根据学生的姓名进行查找

        if (searchTerm.matches("[\\d]*")) {
            for (Student stu : stuSys) {
                if (searchTerm.equals(stu.getId())) {
                    System.out.println("\n查询到以下信息：");
                    System.out.printf("学号：%s\n姓名：%s\n年龄：%d\n", stu.getId(), stu.getName(), stu.getAge());
                    return stuSys.indexOf(stu);
                }
            }
        } else {
            for (Student stu : stuSys) {
                if (searchTerm.equals(stu.getName())) {
                    System.out.println("\n查询到以下信息：");
                    System.out.printf("学号：%s\n姓名：%s\n年龄：%d\n", stu.getId(), stu.getName(), stu.getAge());
                    return stuSys.indexOf(stu);
                }
            }
        }
        System.out.println("查询失败\n输入错误，或者没有找到相关信息。");
        return 0;
    }

    /**
     * 修改学生数据 1. 先进行学生数据查询，定位到对应学生的位置 2. 询问用户是否确定要修改此学生数据 3. 提示用户输入新的内容并修改系统中的数据
     */
    static public void editStu() {
        int stuIndex = searchStu();
        System.out.print("请问是否需要修改信息（y or n）：");
        boolean editChoice = "y".equals(sc.next());

        if (editChoice) {
            System.out.print("请输入学号：");
            String id = sc.next();
            System.out.print("请输入姓名：");
            String name = sc.next();
            System.out.print("请输入年龄：");
            int age = sc.nextInt();
            stuSys.set(stuIndex, new Student(id, name, age));
        }
    }

    /**
     * 打印全部学生的信息
     * 1. 先创建一个自定义的排序器，把集合内的元素按照学号正序排列
     * 2. 使用 for each 循环，调用 Student 类中重写的 toString 方法把所有元素打印出来
     */
    static public void readFull() {
        SortID si = new SortID();
        stuSys.sort(si);
       
        System.out.println("\n 全体学生的信息如下：");
       
        for (Student stu : stuSys) {
            System.out.println(stu.toString());
        }
    }

    /**
     * 删除学生数据
     * 1. 先调用查找功能用来进行学生确认
     * 2. 利用查找功能返回的学生对应 Index number 来进行元素删除操作
     */
    static public void delStu() {
        int stuIndex = searchStu();
        System.out.print("请确认是否删除（y or n）：");
        boolean delChoice = "y".equals(sc.next());

        if (delChoice) {
            stuSys.remove(stuIndex);
        }
    }

    /**
     * 自定义排序方式
     */
    static class SortID implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            int s1ID = Integer.parseInt(s1.getId());
            int s2ID = Integer.parseInt(s2.getId());
            if (s1ID > s2ID) {
                return 1;
            } else if (s1ID < s2ID) {
                return -1;
            }
            return 0;
        }
    }
}
