import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 使用集合实现斗地主游戏的部分功能，要求如下：
 * （1）首先准备 54 张扑克牌并打乱顺序。
 * （2）由三个玩家交替摸牌，每人 17 张扑克牌，最后三张留作底牌。
 * （3）查看三个玩家手中的扑克牌和底牌。
 * （4）其中玩家手中的扑克牌需要按照大小顺序打印，规则如下：
 * 手中扑克牌从大到小的摆放顺序：大王,小王,2,A,K,Q,J,10,9,8,7,6,5,4,3
 */
public class Exam_05 {
    static ArrayList<Card> cards = new ArrayList<>();

    static ArrayList<Card> player1 = new ArrayList<>();
    static ArrayList<Card> player2 = new ArrayList<>();
    static ArrayList<Card> player3 = new ArrayList<>();

    static {
        for (int j = 96; j <= 99; j++) {
            for (int k = 3; k <= 10; k++) {
                cards.add(new Card(k, j, Integer.toString(k)));
            }
            cards.add(new Card(11, j, "J"));
            cards.add(new Card(12, j, "Q"));
            cards.add(new Card(13, j, "K"));
            cards.add(new Card(14, j, "A"));
            cards.add(new Card(15, j, "2"));
        }
        cards.add(new Card(16, 100, "小王"));
        cards.add(new Card(17, 100, "大王"));
    }

    /**
     * 手动操作选项，打乱牌堆中的牌
     */
    public static void resetCards() {
        //调用 Collections 工具打乱集合内顺序
        Collections.shuffle(cards);
    }

    /**
     * 发牌方法
     * 1. 首先对玩家集合的元素进行清空
     * 2. 对牌堆中的牌执行依次打乱操作
     * 3. 按顺序依次从牌堆中添加牌到玩家的集合中
     */
    public static void sendCards() {
        // 清空玩家手上的牌
        player1.clear();
        player2.clear();
        player3.clear();

        // 调用 Collections 工具打乱集合内顺序
        Collections.shuffle(cards);

        for (int i = 0; i < 51; i++) {
            if (i % 3 == 1) {
                player1.add(cards.get(i));
            } else if (i % 3 == 2) {
                player2.add(cards.get(i));
            } else {
                player3.add(cards.get(i));
            }
        }

        // 将玩家手的牌按照大小顺序进行排列整理
        player1.sort(Comparator.comparingInt(Card::getValueNum).reversed());
        player2.sort(Comparator.comparingInt(Card::getValueNum).reversed());
        player3.sort(Comparator.comparingInt(Card::getValueNum).reversed());
    }

    /**
     * 读取玩家手中的牌
     */
    public static void readCards() {
        System.out.print("\n玩家 1 的牌为：");
        for (Card card : player1) {
            System.out.print(card.getName() + " ");
        }

        System.out.print("\n玩家 2 的牌为：");
        for (Card card : player2) {
            System.out.print(card.getName() + " ");
        }

        System.out.print("\n玩家 3 的牌为：");
        for (Card card : player3) {
            System.out.print(card.getName() + " ");
        }

        System.out.printf("\n剩余底牌为：%s %s %s\n", cards.get(cards.size() - 3).getName(), cards.get(cards.size() - 2).getName(), cards.get(cards.size() - 1).getName());

    }

    public static void main(String[] args) {
        boolean exitGame = false;
        do {
            System.out.println("\n斗地主游戏功能测试\n");
            System.out.println("1. 发牌 \t 3. 洗牌\n2. 看牌 \t 4. 退出");
            System.out.print("请输入想测试的功能：");
            Scanner sc = new Scanner(System.in);
            String choice = sc.next();

            switch (choice) {
                case "1" -> sendCards();
                case "2" -> readCards();
                case "3" -> resetCards();
                case "4" -> exitGame = true;
            }
        } while (!exitGame);
    }
}

/**
 * 卡片类，用于记录单张卡片的名字、颜色、大小值
 */
class Card {
    private int valueNum;
    private int color;
    private String name;

    public Card(int valueNum, int color, String name) {
        this.valueNum = valueNum;
        this.color = color;
        this.name = name;
    }

    public int getValueNum() {
        return valueNum;
    }

    public void setValueNum(int valueNum) {
        this.valueNum = valueNum;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
