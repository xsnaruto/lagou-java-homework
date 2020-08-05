package level_01.module_02.GobangGame;

/**
 * 创建一个五子棋棋盘的类，用以实现两个功能：
 * 1. 将 Client 类新建的二维数组引入，并初始化元素内容；
 * 2. 将数组内容打印成棋盘，同时负责之后更新棋盘的信息，展示落子的状态
 */
public class GobangBoard {

    // 1. 构造方法，用于二维数组的初始化；
    public GobangBoard(int[][] boardMap) {
        for (int i = 0; i < boardMap.length; i++) {
            for (int j = 0; j < boardMap.length; j++) {
                if (i == 0) {
                    boardMap[i][j] = 64 + j;
                } else if (j == 0) {
                    boardMap[i][j] = i;
                } else {
                    boardMap[i][j] = 0;
                }
            }
        }
    }

    // 2. 成员方法，用来将二维数组的信息通过五子棋盘的形式打印出来
    public void showBoard(int[][] boardMap, int fullFullRound) {
        System.out.printf("\t五子棋：第 %d 回合\t\n", fullFullRound);
        System.out.println("--------------------------------------");
        for (int i = 0; i < boardMap.length; i++) {
            System.out.print(" "); // 为了打印美观，五子棋盘每行前添加两个空格
            for (int j = 0; j < boardMap.length; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("   ");
                } else if (i == 0) {
                    System.out.printf("%c ", boardMap[i][j]); // 打印棋盘横坐标，通过大写字母展示
                } else if (j == 0) {
                    if (i < 10) {
                        System.out.printf(" %d ", boardMap[i][j]); // 打印棋盘纵坐标，为了对齐，小于 10 的数字前加空格
                    } else {
                        System.out.printf("%d ", boardMap[i][j]); // 打印棋盘纵坐标，通过数字的形式展示
                    }
                    // 打印棋盘内部落子区域的内容，无操作区域默认为 0，已操作区域根据用户 ID 进行区别打印
                } else if (boardMap[i][j] == 0) { // 如果元素为 0，表示没有落子，默认打印"+"
                    System.out.print("· ");
                } else if (boardMap[i][j] == 1) { // 如果元素是奇数，证明当前位置被玩家 1 落子，输出空心圆白子
                    System.out.print("● ");
                } else if (boardMap[i][j] == 2) { // 如果元素是偶数，证明当前位置被玩家 2 落子，输出实心圆黑子
                    System.out.print("○ ");
                }
            }
            System.out.println(); // 每次第一层循环打印结束后进行换行打印
        }
        System.out.println("--------------------------------------"); // 用于分割棋盘内容和游戏进度信息
    }

// 测试五子棋棋盘的打印
//    public static void main(String[] args) {
//        int[][] boardMap = new int[17][17];
//        GobangBoard gb = new GobangBoard(boardMap);
//        gb.showBoard(boardMap, 1);
//    }
}
