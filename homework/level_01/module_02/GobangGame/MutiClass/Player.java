package MutiClass;

import java.util.Scanner;

/**
 * 玩家类，包含玩家信息，以及玩家游戏的进度信息； 成员方法包括：执行落子动作，展示玩家信息 补充方法：使用 String
 * 类型记录用户输入的坐标信息，区分用户输入的「字母」和「数字」，同时判断输入是否合理，最后返回对应数值以继续给 move 方法
 */
public class Player {
    // 成员变量，用于记录玩家信息和 ID
    private String name; // 玩家姓名
    private int id; // 玩家 ID
    private int count = 0; // 玩家落子次数
    private int winTimes = 0; // 玩家获胜次数

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getWinTimes() {
        return winTimes;
    }

    public void setWinTimes(int winTimes) {
        this.winTimes = winTimes;
    }

    String x; // 记录玩家落子的 x 字母坐标
    int xNum; // 记录玩家落子的 x 数字坐标
    int yNum; // 记录玩家落子的 y 数字坐标

    // 下棋动作：提示玩家输入落子的坐标信息，并赋值给五子棋盘的二维数组
    public int[][] move(int[][] boardMap) {
        Scanner sc = new Scanner(System.in); // 创建扫描器记录玩家键盘录入内容
        // 创建一个 String 类型的变量 strLocation 用来接收用户输入的坐标信息
        String strLocation;

        do {
            System.out.print("请输入落子坐标（不区分大小写和横纵坐标输入顺序）：");
            strLocation = sc.nextLine(); // 接收用户输入的坐标信息

            // 开始判定字母坐标
            if (strLocation.replaceAll("[^A-Za-z]", "").equals("")) { // 如果用户输入的内容没有字母，执行完 replaceAll 之后就没有没有内容了，如果
                                                                      // equals 空内容""成立，就提示错误，重新开始循环
                System.out.println("输入坐标错误，请重新输入……\n");
                continue;
            } else {
                x = strLocation.replaceAll("[^A-Za-z]", ""); // replaceAll() 用来提取字符串 strLocation 中的对应值，[^A-Za-z] 表示刷选范围
                                                             // A-Z 和 a-z，"" 表示用于替换的内容
            }

            // 如果用户输入的字母是小写字母，通过 if 语句判定后进行转换
            if (x.charAt(0) >= 'a' && x.charAt(0) <= 'z') { // 如果 x 是小写字母，将其指向大写字母对应的坐标；
                xNum = x.charAt(0) - 96; // 如果字母是小写字母，减去 96 获得对应的数字坐标位置
                x = x.toUpperCase(); // 将小写字母转为大写字母，并赋值给 x，方便 Client 类中 lastMove 方法调用打印时展现更美观
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
                yNum = Integer.parseInt(strLocation.replaceAll("[^0-9]", "")); // Integer.parseInt() 用来把字符类型的数字转换为 int
                                                                               // 类型，[^0-9] 提取范围 0-9 内的数字
            }

            if (yNum < 1 || yNum > 16) { // 如果数字坐标小于 1 或者大于 16，超出棋盘范围，提示用户输入错误，跳回 while 循环开始处重新输入
                System.out.println("输入坐标错误，请重新输入……\n");
                continue;
            }

            if (boardMap[yNum][xNum] != 0) { // 玩家输入坐标的数组位置元素不为 0，表示该位置已有棋子，提示玩家重新输入后，跳回循环起点，要求玩家输入新坐标
                System.out.println("落子位置已经存在棋子了哦，请重新输入。\n");
            } else { // do while 循环使用的是无限循环，直到用户输入正确，下面语句赋值完成后，才会通过 break 跳出循环
                boardMap[yNum][xNum] = id; // 通过成员的 ID 来给棋盘落子的位置做标记，玩家 1 落子则将对应位置的数组内容改为 1，玩家 2 落子则将对应位置的数组改为 2
                count++; // 通过 count 自增的方法，统计对应玩家的落子次数
                break; // 以上左右步骤没有问题的情况下才会跳出循环
            }
        } while (true);
        
        sc.close();
        
        System.out.println("--------------------------------------");
        return boardMap;
    }

    // 展示玩家信息：打印玩家的姓名，使用棋子的颜色，以及单局中落子的次数
    public void showInfo() {
        if (id == 1) {
            System.out.printf("玩家1：%s，棋子：●，落子：%d次，获胜：%d次\n", name, count, winTimes);
        } else {
            System.out.printf("玩家2：%s，棋子：○，落子：%d次，获胜：%d次\n", name, count, winTimes);
        }
    }
}
