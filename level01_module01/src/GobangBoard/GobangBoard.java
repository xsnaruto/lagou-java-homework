package GobangBoard;

/**
 * 使用二维数组和循环实现五子棋游戏棋盘的绘制
 */

public class GobangBoard {
    public static void main(String[] args) {

        // 1. 创建一个 17 行 17 列的二维数组
        int[][] chest = new int[17][17];

        // 2. 创建双重循环循环对数组进行遍历赋值
        // 2.1 第一层循环用来遍历每一行
        for (int i = 0; i < chest.length; i++) {

            // 2.2. 第二层循环用来遍历每一行的每一列，并打印
            for (int j = 0; j < chest.length; j++) {

                if (i == 0 && j == 0) {
                    System.out.print("  ");
                }else if (i == 0) {
                    chest[0][j] = j - 1;
                    System.out.printf("%x ", chest[0][j]);
                } else if (j == 0) {
                    chest[i][0] = i - 1;
                    System.out.printf("%x ", chest[i][0]);
                } else {
                    System.out.print("+ ");
                }
            }
            System.out.println(); // 每行打印完后进行换行
        }
    }
}