package TempTest;

/**
 * Client
 */
public class Client {

    public static void main(String[] args) {
        Game game1 = new DNF();
        Gmae game2 = new LOL();
        // Gmae game3 = new CS();

        Player p = new Player();
        p.happy(game1);
        p.happy(game2);
        // p.happy(game3);
    }
}