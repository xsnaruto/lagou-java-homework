public class ForLoop {
    public static void main(String[] args) {
        // 1. 根据奇数概念打印
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }

        System.out.println("-------------------------------------");

        // 2. 根据等差概念打印
        for (int i = 1; i <= 100; i += 2) {
            System.out.println(i);
        }

        System.out.println("-------------------------------------");

        // 3。 根据通项公式打印
        for (int i = 1; i <= 50; i++) {
            System.out.println(i * 2 - 1);
        }
    }
}