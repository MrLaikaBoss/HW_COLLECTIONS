import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GameTest {


    Player player1 = new Player(7, 35, "Denis");
    Player player2 = new Player(3, 32, "Ilya");
    Player player3 = new Player(5, 30, "Oleg");
    Player player4 = new Player(9, 35, "Dima");

    Game game = new Game();

    @Test
    public void firstPlayerWin() {

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Denis", "Ilya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWin() {

        game.register(player3);
        game.register(player4);

        int expected = 2;
        int actual = game.round("Oleg", "Dima");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void draw() {

        game.register(player1);
        game.register(player4);

        int expected = 0;
        int actual = game.round("Denis", "Dima");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotFound() {

        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Sasha", "Oleg")
        );
    }

    @Test
    public void secondPlayerNotFound() {

        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Ilya", "Alexey")
        );
    }
}
