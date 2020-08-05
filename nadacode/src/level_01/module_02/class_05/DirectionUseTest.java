package level_01.module_02.class_05;

public class DirectionUseTest {

    // 自定义静态方法实现根据参数指定的字符串内容来打印具体的方向信息
    public static void test1(String str) {
        switch (str) {
            case "向上" -> System.out.println("举头望明月");
            case "向下" -> System.out.println("低头思故乡");
            case "向左" -> System.out.println("左边左边");
            case "向右" -> System.out.println("右边右边");
            default -> System.out.println("输入错误哦");
        }
    }

    public static void test2(DirectionEnum de) {
        switch (de) {
            case UP -> System.out.println("举头望明月");
            case DOWN -> System.out.println("低头思故乡");
            case LEFT -> System.out.println("左边左边");
            case RIGHT -> System.out.println("右边右边");
            default -> System.out.println("输入错误哦");
        }
    }
    public static void main(String[] args) {
        DirectionUseTest.test1(Direction.UP.getDesc());
        DirectionUseTest.test2(DirectionEnum.DOWN);
    }
}
