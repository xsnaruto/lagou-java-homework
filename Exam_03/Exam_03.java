import java.util.Arrays;
import java.util.HashMap;

/**
 * 准备一个 HashMap 集合，统计字符串"123,456,789,123,456"中每个数字字符串出现的次数并打印出来。
 * 如：
 * 123 出现了 2 次
 * 456 出现了 2 次
 * 789 出现了 1 次
 */
public class Exam_03 {
    public static void main(String[] args) {

        // 1. 使用题目要求内容创建字符串 str
        String str = "123,456,789,123,456,234,567,678,345,678,234,456,345";

        // 2. 创建一个 HashMap 用于存放题目要求数据
        HashMap<String, Integer> hm = new HashMap<>();

        // 3. 将 str 内容根据逗号进行分割
        String[] strArray = str.split(",");
        System.out.println("字符串内容：" + Arrays.toString(strArray) + "\n");

        // 4. 使用 for each 将 String 数组的内容使用 HashMap 进行记录
        for (String s : strArray) {
            // 集合中包含目标值的时候，使用 put 方法将 value 的值修改并覆盖
            if (hm.containsKey(s)) {
                hm.put(s, hm.get(s) + 1);
            } else {
                // 集合中不包含目标值的时候，创建一个新的 key，并初始化 value 为 1
                hm.put(s, 1);
            }
        }

        // 5. 使用 foreach 遍历 HashMap 打印数值
        for (String key : hm.keySet()) {
            Integer value = hm.get(key);
            System.out.printf("字符串：%s 出现次数为：%d\n", key, value);
        }
    }
}
