import java.util.Random;
import java.util.Scanner;

/**
 * 创建 Client 类，包括信息：新建二维数组
 * 包含方法：lastMove 展示上一回合执行的动作信息，checkWin 检查是否获胜，main 根据游戏顺序执行语句
 * 实现步骤：
 * 1. 五子棋游戏的初始化，创建二维数组，创建新的五子棋盘对象并初始化棋盘内容；
 * 2. 通过 Player 类分别创建 2 个玩家对象，提示玩家录入姓名，并给玩家赋值 ID；
 * 3. 通过引入随机数，随机选择一个玩家开始五子棋游戏；
 * 4. 提示玩家录入棋盘坐标信息，更改二维数组内的元素内容，再调用 GobangBoard 类中的方法将更新后的棋盘信息打印出来；
 * 5. 使用 checkWin 成员方法，再每次落子动作后进行游戏的胜负判断，通过 boolean 类型判定是否有人胜出；
 * 6. checkWin 判断结果为 false 时，不进行任何输出，直到结果为 true，打印胜出者信息，然后结束程序。
 */
public class Client {

    // 创建一个二维数组，用来接收五子棋盘的信息，创建一个 int 变量记录回合数
    private static int[][] boardMap = new int[17][17]; // 记录棋盘信息

    public static int[][] getBoardMap() {
        return boardMap;
    }

    public static void setBoardMap(int[][] boardMap) {
        Client.boardMap = boardMap;
    }

    // 成员方法，用于打印执行当前回合的玩家信息和当前回合落子的信息
    public static void lastMove(String name, int count, String x, int yNum) {
        // 每执行一次 move 之后，调用一次 showBoard 方法，用来更新棋盘
        System.out.printf("%s 第 %d 步的落子位置为：%s%d，下一位请落子。\n", name, count, x, yNum);
        System.out.println("--------------------------------------");
    }

    // 成员方法，用于检查是否有人成功串联 5 个棋子，成功的话打印胜出者并退出，没有成功的话不进行任何输出
    public static boolean checkWin(int[][] boardMap, int id, int xNum, int yNum) {
        int c = 0; // 创建一个变量 c 用来记录连子数

        // 防止下面 for 循环判定时导致数组越界
        // 创建变量用来设置 for 循环的循环次数
        int a1; // 防止上面越界
        int a2; // 防止左边越界
        int z1; // 防止下面越界
        int z2; // 防止右边越界
        // 通过 if else 语句将可能导致越界的元素控制在数组范围内
        if (yNum <= 5) {
            a2 = 1;
            z2 = yNum + 4;
        } else if (yNum >= 12) {
            a2 = yNum - 4;
            z2 = 16;
        } else {
            a2 = yNum - 4;
            z2 = yNum + 4;
        }
        if (xNum <= 5) {
            a1 = 1;
            z1 = xNum + 4;
        } else if (xNum >= 12) {
            a1 = xNum - 4;
            z1 = 16;
        } else {
            a1 = xNum - 4;
            z1 = xNum + 4;
        }


        // 横向和纵向的连子判定
        for (int i = a1; i <= z1; i++) {
            if (boardMap[yNum][i] == id) { // 判定如果棋盘坐标的元素内容是否等于玩家的 id
                c++; // 如果元素内容等于玩家的 id，变量 c 自增，累加连子次数
                if (c > 4) {
                    return true;
                }
            } else {
                c = 0; // 当遍历到当前 id 外的其他内容时，变量 c 归零
            }
        }

        // 纵向连子判定
        c = 0; // 执行判定前将 c 清零，避免循环尾部带入的自增数值
        for (int i = a2; i <= z2; i++) {
            if (boardMap[i][xNum] == id) {
                c++;
                if (c > 4) {
                    return true;
                }
            } else {
                c = 0;
            }
        }

        // 左上往右下方向连子判定
        c = 0; // 执行判定前将 c 清零，避免循环尾部带入的自增数值
        for (int i = a2; i <= z2; i++) { // 避免上下越界
            int xy = yNum - xNum; // 使用变量 xy 计算 yNum 和 xNum 之间的关系
            if (i - xy <= 16 && i - xy > 0) { // 判断数组纵坐标是否在范围内，如果不是的话，不执行语句
                if (boardMap[i][i - xy] == id) {
                    c++;
                    if (c > 4) {
                        return true;
                    }
                } else {
                    c = 0;
                }
            }
        }

        // 左下往右上方向连子判定
        c = 0; // 执行判定前将 c 清零，避免循环尾部带入的自增数值
        for (int i = a2; i <= z2; i++) {
            if (yNum - i + xNum <= 16 && yNum - i + xNum > 0) {
                if (boardMap[i][(yNum - i) + xNum] == id) {
                    c++;
                    if (c > 4) {
                        return true;
                    }
                } else {
                    c = 0;
                }
            }
        }

        return false;
    } // 方法结束

    public static void fullRound(GobangBoard game, int fullFullRound, int[][] boardMap, Player a, Player b) {
        // int roundCount;
        do {
            setBoardMap(a.move(boardMap));
            game.showBoard(boardMap, fullFullRound);
            lastMove(a.getName(), a.getCount(), a.x, a.yNum);
            a.showInfo();
            b.showInfo();
            if (checkWin(boardMap, a.getId(), a.xNum, a.yNum)) {
                System.out.println("--------------------------------------");
                System.out.printf("五子连线啦，本局已结束，恭喜 %s 获胜！\n", a.getName());
                a.setWinTimes(a.getWinTimes() + 1);
                break;
                // System.exit(0);
            }

            System.out.println(); // 换行

            setBoardMap(b.move(boardMap));
            game.showBoard(boardMap, fullFullRound);
            lastMove(b.getName(), b.getCount(), b.x, b.yNum);
            a.showInfo();
            b.showInfo();
            if (checkWin(boardMap, b.getId(), b.xNum, b.yNum)) {
                System.out.println("--------------------------------------");
                System.out.printf("五子连线啦，本局已结束，恭喜 %s 获胜！\n", b.getName());
                b.setWinTimes(a.getWinTimes() + 1);
                break;
                // System.exit(0);
            }
            System.out.println(); // 换行
        } while (true);

    }

    public static void main(String[] args) {

        boolean choice; // 用来接收用户选择开始新游戏或者退出游戏的选择
        int fullFullRound = 0; // 统计局数

        // 调用 Player 类创建两个 Player 对象，同时给对象分别进行赋值，分别代表两个玩家
        Scanner sc = new Scanner(System.in); // 创建扫描器接收用户输入信息

        Player p1 = new Player(); // 创建一个 Player 对象 p1
        System.out.print("玩家 1 请输入姓名："); // 提示玩家输入姓名
        p1.setName(sc.nextLine());  // 将玩家输入的姓名内容传递给 p1 的 name 变量
        p1.setId(1); // 默认给 p1 玩家赋值 ID 为 1

        Player p2 = new Player(); // 创建一个 Player 对象 p2
        System.out.print("玩家 2 请输入姓名："); // 提示玩家输入姓名
        p2.setName(sc.nextLine()); // 将玩家输入的姓名内容传递给 p2 的 name 变量
        p2.setId(2); // 默认给 p2 玩家的 ID 设置为 2

        do {
            // 使用 GobangBoard 类创建一个棋盘对象，同时传入新创建的二维数组，
            fullFullRound++;
            GobangBoard game = new GobangBoard(getBoardMap());

            // 每局游戏开始的时候，玩家单局落子次数清零
            p1.setCount(0);
            p2.setCount(0);

            // 打印初始化的棋盘，并在棋盘下面展示两个玩家的信息
            game.showBoard(boardMap, fullFullRound); // 调用创建的棋盘对象 game 里面的 showBoard 方法打印棋盘
            p1.showInfo(); // 调用 Player 类创建的 p1 对象内的 showInfo 方法，打印玩家 1 的信息
            p2.showInfo(); // 调用 Player 类创建的 p2 对象内的 showInfo 方法，打印玩家 2 的信息
            System.out.println(); // 换行打印

            // 调用随机数工具选择第一个落子的人，然后开始正式下棋的方法，玩家轮流进行下棋操作
            Random ra = new Random(); // 创建随机数工具

            int firstPlayer = ra.nextInt(2) + 1;

            if (firstPlayer == 1) {
                fullRound(game, fullFullRound, getBoardMap(), p1, p2);
            } else {
                fullRound(game, fullFullRound, getBoardMap(), p2, p1);
            }

            do {
                System.out.println("--------------------------------------");
                System.out.print("开始新游戏请输入1，结束并打印成绩请输入2：");
                int choiceNum = sc.nextInt();
                System.out.println(); // 换行

                if (choiceNum == 1) {
                    choice = true;
                    break;
                } else if (choiceNum == 2) {
                    System.out.println("======================================");
                    System.out.println("最终成绩：");
                    System.out.printf("玩家 %s 总获胜次数：%d\n", p1.getName(), p1.getWinTimes());
                    System.out.printf("玩家 %s 总获胜次数：%d\n", p2.getName(), p2.getWinTimes());

                    if (p1.getWinTimes() > p2.getWinTimes()) {
                        System.out.printf("最终获胜者是 %s！\n", p1.getName());
                    } else if (p1.getWinTimes() < p2.getWinTimes()) {
                        System.out.printf("最终获胜者是 %s！\n", p2.getName());
                    } else {
                        System.out.println("平局平局，大家水平相当。");
                    }
                    choice = false;
                    break;
                } else {
                    System.out.println("输入有误，请重新输入！");
                }
            } while (true); // 结束用户选择

        } while (choice); // 结束游戏

    }
}
