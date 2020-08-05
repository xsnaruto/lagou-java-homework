import java.util.Random;
import java.util.Scanner;

/**
 * 五子棋游戏，该有的功能都有就行……
 */
public class SingleGobangGame {

    static String name1; // 玩家1姓名
    static String name2; // 玩家2姓名
    static int id1; // 玩家1 ID
    static int id2; // 玩家2 ID
    static int count1 = 0; // 玩家1落子次数
    static int count2 = 0; // 玩家2落子次数
    static int winTimes1 = 0; // 玩家1获胜次数
    static int winTimes2 = 0; // 玩家2获胜次数

    static String warningFunc; // 记录是否开启连子提示功能

    static String x; // 记录玩家落子的 x 字母坐标
    static int xNum; // 记录玩家落子的 x 数字坐标
    static int yNum; // 记录玩家落子的 y 数字坐标

    static int[][] boardMap = new int[17][17]; // 用于记录棋盘信息的二维数组

    // 初始化棋盘
    public SingleGobangGame(int[][] boardMap) {
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

    // 打印棋盘
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

    // 下棋动作：提示玩家输入落子的坐标信息，并赋值给五子棋盘的二维数组
    public static void move(int[][] boardMap, int id) {
        Scanner sc = new Scanner(System.in); // 创建扫描器记录玩家键盘录入内容
        // 创建一个 String 类型的变量 strLocation 用来接收用户输入的坐标信息
        String strLocation;

        do {
            System.out.print("请输入落子坐标（不区分大小写和横纵坐标输入顺序）：");
            strLocation = sc.nextLine(); // 接收用户输入的坐标信息

            // 开始判定字母坐标
            if (strLocation.replaceAll("[^A-Za-z]", "").equals("")) { // 如果用户输入的内容没有字母，执行完 replaceAll 之后就没有没有内容了，如果 equals 空内容""成立，就提示错误，重新开始循环
                System.out.println("输入坐标错误，请重新输入……\n");
                continue;
            } else {
                x = strLocation.replaceAll("[^A-Za-z]", ""); // replaceAll() 用来提取字符串 strLocation 中的对应值，[^A-Za-z] 表示刷选范围 A-Z 和 a-z，"" 表示用于替换的内容
            }

            // 如果用户输入的字母是小写字母，通过 if 语句判定后进行转换
            if (x.charAt(0) >= 'a' && x.charAt(0) <= 'z') { // 如果 x 是小写字母，将其指向大写字母对应的坐标；
                xNum = x.charAt(0) - 96; // 如果字母是小写字母，减去 96 获得对应的数字坐标位置
                x = x.toUpperCase(); //  将小写字母转为大写字母，并赋值给 x，方便 Client 类中 lastMove 方法调用打印时展现更美观
            } else if (x.charAt(0) >= 'A' && x.charAt(0) <= 'z') {
                xNum = x.charAt(0) - 64; // 如果字母是小写字母，减去 96 获得对应的数字坐标位置
            } else { // 如果不是大写字母也不是小写字母，提示输入错误，跳回循环起点重新开始输入
                System.out.println("输入坐标错误，请重新输入……\n");
                continue;
            }

            // 开始判定数字坐标
            if (strLocation.replaceAll("[^0-9]", "").equals("")) { // 如果用户输入的内容内没有数字，提示输入错误并重新要求输入
                System.out.println("输入坐标错误，请重新输入……\n");
                continue;
            } else {
                yNum = Integer.parseInt(strLocation.replaceAll("[^0-9]", "")); // Integer.parseInt() 用来把字符类型的数字转换为 int 类型，[^0-9] 提取范围 0-9 内的数字
            }

            if (yNum < 1 || yNum > 16) { // 如果数字坐标小于 1 或者大于 16，超出棋盘范围，提示用户输入错误，跳回 while 循环开始处重新输入
                System.out.println("输入坐标错误，请重新输入……\n");
                continue;
            }

            if (boardMap[yNum][xNum] != 0) { // 玩家输入坐标的数组位置元素不为 0，表示该位置已有棋子，提示玩家重新输入后，跳回循环起点，要求玩家输入新坐标
                System.out.println("落子位置已经存在棋子了哦，请重新输入。\n");
            } else { // do while 循环使用的是无限循环，直到用户输入正确，下面语句赋值完成后，才会通过 break 跳出循环
                boardMap[yNum][xNum] = id; // 通过成员的 ID 来给棋盘落子的位置做标记，玩家 1 落子则将对应位置的数组内容改为 1，玩家 2 落子则将对应位置的数组改为 2
                count1++; // 通过 count 自增的方法，统计对应玩家的落子次数
                break; // 以上左右步骤没有问题的情况下才会跳出循环
            }
        } while (true);

        System.out.println("--------------------------------------");
//        return boardMap;
    }

    // 游戏过程中打印玩家的信息
    public static void showInfo() {
        System.out.printf("玩家1：%s，棋子：●，获胜：%d次\n", name1, winTimes1);
        System.out.printf("玩家2：%s，棋子：○，获胜：%d次\n", name2, winTimes2);
    }

    // 打印上一步玩家落子位置
    public static void lastMove(String name, String x, int yNum) {
        // 每执行一次 move 之后，调用一次 showBoard 方法，用来更新棋盘
        System.out.printf("%s 上一步的落子位置为：%s%d，下一位请落子。\n", name, x, yNum);
        System.out.println("--------------------------------------");
    }

    // 检查是否有人胜利，同时提供警报提示
    public static boolean checkWin(int[][] boardMap, String warningFunc, int id, int xNum, int yNum) {
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


        // 横向的连子判定
        for (int i = a1; i <= z1; i++) {
            if (boardMap[yNum][i] == id) { // 判定如果棋盘坐标的元素内容是否等于玩家的 id
                c++; // 如果元素内容等于玩家的 id，变量 c 自增，累加连子次数
                if (c > 4) {
                    return true;
                } else if (warningFunc.equals("y") && c == 4 && (i == 4 | i == 16)) { // 当有一颗子处于棋盘边缘的同时，已经有 4 颗子连线的时候，提供提示
                    System.out.println("㊟ 注意：已经存在四子连成线了哦！");
                    System.out.println("--------------------------------------");
                } else if (warningFunc.equals("y") && c == 3 && boardMap[yNum][i - 3] == 0 && boardMap[yNum][i + 1] == 0) { // 当存在三子连线，同时两端都为未落子的状态，发送提示
                    System.out.println("㊟ 注意：可能有风险的三子连成线咯！");
                    System.out.println("--------------------------------------");
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
                } else if (warningFunc.equals("y") && c == 4 && (i == 4 || i == 16)) {
                    System.out.println("㊟ 注意：已经存在四子连成线了哦！");
                    System.out.println("--------------------------------------");
                } else if (warningFunc.equals("y") && c == 3 && boardMap[i - 3][xNum] == 0 && boardMap[i + 1][xNum] == 0) {
                    System.out.println("㊟ 注意：可能有风险的三子连成线咯！");
                    System.out.println("--------------------------------------");
                } else {
                    c = 0;
                }
            }
        }

        // 左上往右下方向连子判定
        c = 0; // 执行判定前将 c 清零，避免循环尾部带入的自增数值
        for (int i = a2; i <= z2; i++) { // 避免上下越界
            int xy = yNum - xNum; // 使用变量 xy 计算 yNum 和 xNum 之间的关系
            if (i - xy <= 16 & i - xy > 0) { // 判断数组纵坐标是否在范围内，如果不是的话，不执行语句
                if (boardMap[i][i - xy] == id) {
                    c++;
                    if (c > 4) {
                        return true;
                    } else {
                        c = 0;
                    }
                }
            }
        }

        // 左下往右上方向连子判定
        c = 0; // 执行判定前将 c 清零，避免循环尾部带入的自增数值
        for (int i = a2; i <= z2; i++) {
            if (yNum - i + xNum <= 16 & yNum - i + xNum > 0) {
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
    }

    // 用于重复玩家落子动作，根据 main 方法中传入的玩家先后顺序来定义由谁先下第一颗子
    public static int[] fullRound(SingleGobangGame game, int fullFullRound, int[][] boardMap, String nameA, String nameB, int idA, int idB, int countA, int countB, int winA, int winB) {

        int[] allWinTimes = new int[2];
        do {
            move(boardMap, idA);
            countA++;
            game.showBoard(boardMap, fullFullRound);
            lastMove(nameA, x, yNum);
            if (checkWin(boardMap, warningFunc, idA, xNum, yNum)) {
                System.out.println("--------------------------------------");
                System.out.printf("五子连线啦，本局已结束，恭喜 %s 获胜！\n", nameA);
                winA++;
                allWinTimes[0] = winA;
                allWinTimes[1] = winB;
                return allWinTimes;
            }
            showInfo();

            System.out.println(); // 换行

            move(boardMap, idB);
            countB++;
            game.showBoard(boardMap, fullFullRound);
            lastMove(nameA, x, yNum);
            if (checkWin(boardMap, warningFunc, idB, xNum, yNum)) {
                System.out.println("--------------------------------------");
                System.out.printf("五子连线啦，本局已结束，恭喜 %s 获胜！\n", nameB);
                winB++;
                allWinTimes[0] = winA;
                allWinTimes[1] = winB;
                return allWinTimes;
                // System.exit(0);
            }
            showInfo();
            System.out.println(); // 换行
        } while (true);

    }

    public static void main(String[] args) {
        boolean choice; // 用来接收用户选择开始新游戏或者退出游戏的选择
        int fullFullRound = 0; // 统计局数

        // 调用 Player 类创建两个 Player 对象，同时给对象分别进行赋值，分别代表两个玩家
        Scanner sc = new Scanner(System.in); // 创建扫描器接收用户输入信息

        System.out.print("玩家 1 请输入姓名："); // 提示玩家输入姓名
        name1 = sc.nextLine();  // 将玩家输入的姓名内容传递给 p1 的 name 变量
        id1 = 1; // 默认给 p1 玩家赋值 ID 为 1

        System.out.print("玩家 2 请输入姓名："); // 提示玩家输入姓名
        name2 = sc.nextLine(); // 将玩家输入的姓名内容传递给 p2 的 name 变量
        id2 = 2; // 默认给 p2 玩家的 ID 设置为 2

        do {
            System.out.print("是否需要开启横竖排的「危机警告」 y or n：");
            warningFunc = sc.nextLine();
            if (warningFunc.equals("y") | warningFunc.equals("n")) {
                break;
            } else {
                System.out.println("输入错误，请重新输入");
            }
        } while (true);

        do {
            // 使用 GobangBoard 类创建一个棋盘对象，同时传入新创建的二维数组，
            fullFullRound++;
            SingleGobangGame game = new SingleGobangGame(boardMap);

            // 每局游戏开始的时候，玩家单局落子次数清零
            count1 = 0;
            count2 = 0;

            // 打印初始化的棋盘，并在棋盘下面展示两个玩家的信息
            game.showBoard(boardMap, fullFullRound); // 调用创建的棋盘对象 game 里面的 showBoard 方法打印棋盘
            showInfo();
            System.out.println(); // 换行打印

            // 调用随机数工具选择第一个落子的人，然后开始正式下棋的方法，玩家轮流进行下棋操作
            Random ra = new Random(); // 创建随机数工具

            int firstPlayer = ra.nextInt(2) + 1;

            int[] allWinTimes;
            if (firstPlayer == 1) {
                allWinTimes = fullRound(game, fullFullRound, boardMap, name1, name2, id1, id2, count1, count2, winTimes1, winTimes2);
            } else {
                allWinTimes = fullRound(game, fullFullRound, boardMap, name2, name1, id2, id1, count2, count1, winTimes2, winTimes1);
            }
            winTimes1 = allWinTimes[0];
            winTimes2 = allWinTimes[1];

            do {
                System.out.println("--------------------------------------");
                System.out.print("开始新游戏请输入1，结束并打印成绩请输入2：");
                String choiceNum = (sc.nextLine()).replaceAll("[^1-2]", "");
                System.out.println(); // 换行

                if (choiceNum.equals("")) {
                    System.out.println("输入有误，请重新输入！");
                } else if (Integer.parseInt(choiceNum) == 1) {
                    choice = true;
                    break;
                } else if (Integer.parseInt(choiceNum) == 2) {
                    System.out.println("======================================");
                    System.out.println("最终成绩：");
                    System.out.printf("玩家 %s 总获胜次数：%d\n", name1, winTimes1);
                    System.out.printf("玩家 %s 总获胜次数：%d\n", name2, winTimes2);

                    if (winTimes1 > winTimes2) {
                        System.out.printf("最终获胜者是 %s！\n", name1);
                    } else if (winTimes1 < winTimes2) {
                        System.out.printf("最终获胜者是 %s！\n", name2);
                    } else {
                        System.out.println("平局平局，大家水平相当。");
                    }
                    choice = false;
                    break;
                }
            } while (true); // 结束用户选择

        } while (choice); // 结束游戏

    }

}
