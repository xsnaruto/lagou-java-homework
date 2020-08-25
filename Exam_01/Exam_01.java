import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 1. 编程题
 * 编程统计字符串"ABCD123!@#$%ab"中大写字母、小写字母、数字、其它字符的个数并打 印出来。
 */
public class Exam_01 {
    public static void main(String[] args) {
        // 1. 创建字符串变量
        String str = "ABCD123!@#$%ab";

        // 2. 获取不同类型字符的个数，并打印
        // 2.1 根据分类创建不同的数组，使用 replaceAll 配合正则表达式筛选出对应类型字符，再转换成字符数组
        char[] upCase = str.replaceAll("[^A-Z]", "").toCharArray();
        // 2.2 格式化打印，字符的个数通过获取数组的长度进行打印，内容通过将数组 toString 进行打印
        System.out.printf("大写字母有：%d 个，他们是 %s。\n", upCase.length, Arrays.toString(upCase));

        char[] lowCase = str.replaceAll("[^a-z]", "").toCharArray();
        System.out.printf("小写字母有：%d 个，他们是 %s。\n", lowCase.length, Arrays.toString(lowCase));

        char[] numCase = str.replaceAll("[^\\d]", "").toCharArray();
        System.out.printf("数字字符有：%d 个，他们是 %s。\n", numCase.length, Arrays.toString(numCase));

        char[] otherCase = str.replaceAll("[^\\W]", "").toCharArray();
        System.out.printf("数字字符有：%d 个，他们是 %s。\n", otherCase.length, Arrays.toString(otherCase));
    }
}
