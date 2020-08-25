/**
 * 2. 编程题
 * 编程获取两个指定字符串中的最大相同子串并打印出来。
 * 如： s1="asdafghjka", s2="aaasdfg" 他们的最大子串为"asd"
 * 提示： 将短的那个串进行长度依次递减的子串与较长的串比较。
 */
public class Exam_02 {
    public static void main(String[] args) {
        // 1. 创建两个字符串并打印出来
        String str1 = "ahwwighvgbhabawe";
        String str2 = "agbiuhgbawighvhieaie";

        System.out.println("字符串 1：" + str1);
        System.out.println("字符串 2：" + str2 + "\n");

        // 2. 判断两个字符串的长短关系，并创建两个变量分别接收
        String max = str1.length() > str2.length() ? str1 : str2;
        String min = max == str1 ? str2 : str1;

        // 3. 使用多重 for 循环进行相同字串的对比查找
        // 3.1 外层 for 循环次数设置为短字符串的长度
        for (int i = 0; i < min.length(); i++) {

            // 3.2 内层 for 循环提取短字符串内的内容，并赋值给临时的字符串变量 subString
            for (int j = 0, k = min.length() - i; k != min.length() + 1; j++, k++) {
                String subString = min.substring(j, k);

                // 4. 通过 temp 和 max 比对，比对成功了就打印最大字串并退出程序，否则继续进行循环
                if (max.contains(subString)) {
                    System.out.println("最大子串数量：" + subString.length());
                    System.out.println("最大子串内容：" + subString);
                    System.exit(0);
                }
            }
        }
    }
}