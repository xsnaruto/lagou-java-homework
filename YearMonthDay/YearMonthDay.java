package YearMonthDay;

import java.util.Scanner;

/**
 * HomeWork_01 提示用户输入年月日信息，判断这一天是这一年的第几天并打印出来
 */
public class YearMonthDay {

    public static void main(String[] args) {

        // 1. 请求用户按要求分别输入年、月、日信息
        // 1.1. 提示用户输入年月日信息，创建变量接收用户输入的对应数据
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份：");
        int dateYear = sc.nextInt();
        System.out.println("请输入月份：");
        int dateMonth = sc.nextInt();
        System.out.printf("请输入 %d 月多少号：\n", dateMonth);
        int dateDate = sc.nextInt();
        sc.close();

        // 1.2. 创建一个 int 变量，然后判断用户输入日期为当年的第多少天，再将天数赋值给变量
        int fullDay = dateDate; // 直接接收日的数据

        for (int i = 1; i < dateMonth; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10) {
                fullDay += 31;
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                fullDay += 30;
            } else {
                if ((dateYear % 4 == 0 && dateYear % 100 != 0) || dateYear % 400 == 0) {
                    // System.out.println("今年是闰年");
                    fullDay += 29;
                } else {
                    fullDay += 28;
                }
            }
        }

        // 1.3. 打印结果
        System.out.println();
        System.out.printf("你输入的数据 %d 年 %d 月 %d 日，为当前年的第 %d 天。\n", dateYear, dateMonth, dateDate, fullDay);
    }

}