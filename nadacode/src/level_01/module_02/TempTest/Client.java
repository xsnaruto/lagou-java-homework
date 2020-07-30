package level_01.module_02.TempTest;

/**
 * Client
 */
public class Client {

    public static void main(String[] args) {
        Game game1 = new DNF();
        Game game2 = new LOL();
        Game game3 = new CS();

        Player p1 = new Player();
        p1.happy(game1);
        System.out.println("---------------------------");
        Player p2 = new Player();
        p2.happy(game2);
        System.out.println("---------------------------");
        Player p3 = new Player();
        p3.happy(game3);
    }
}