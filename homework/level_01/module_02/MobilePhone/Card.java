public class Card {
    private int type;
    private int id;
    private String username;
    private String password;

    private double balance;

    private int callTime;
    private int dataUse;

    public void showInfo() {
        System.out.printf("卡号：\n", id);
        System.out.printf("姓名：\n", username);
        System.out.printf("余额：\n", balance);
    }
}
