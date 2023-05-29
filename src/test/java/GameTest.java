import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void firstPlayerWin() {
        Player mutant = new Player(1, "мутант", 200);
        Player human = new Player(2, "человек", 100);
        Game game = new Game();

        game.register(mutant);
        game.register(human);
        int expected = 1;
        int actual = game.round("мутант", "человек");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWin() {
        Player mutant = new Player(1, "мутант", 200);
        Player human = new Player(2, "человек", 300);
        Game game = new Game();

        game.register(mutant);
        game.register(human);
        int expected = 2;
        int actual = game.round("мутант", "человек");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nobodyNotWin() {
        Player mutant = new Player(1, "мутант", 200);
        Player human = new Player(2, "человек", 200);
        Game game = new Game();

        game.register(mutant);
        game.register(human);
        int expected = 0;
        int actual = game.round("мутант", "человек");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotRegisterer() {
        Player mutant = new Player(1, "мутант", 200);
        Player human = new Player(2, "человек", 200);
        Game game = new Game();

        game.register(mutant);
        game.register(human);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("гуманоид", "человек"));
    }

    @Test
    public void secondPlayerNotRegisterer() {
        Player mutant = new Player(1, "мутант", 200);
        Player human = new Player(2, "человек", 200);
        Game game = new Game();

        game.register(mutant);
        game.register(human);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("мутант", "гуманоид"));
    }
}
