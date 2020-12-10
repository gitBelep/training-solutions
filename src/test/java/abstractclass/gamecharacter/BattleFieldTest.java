package abstractclass.gamecharacter;

import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BattleFieldTest {

    @Test
    public void fight() {
        Random random = new Random(123);
        BattleField battleField = new BattleField();
        Character characterArcher = new Archer(new Point(0, 0), random);
        Character characterWarrior = new AxeWarrior(new Point(5, 0), random);
        battleField.fight(characterArcher, characterWarrior);

        assertTrue(battleField.getRound() > 0);
        assertTrue(!characterArcher.isAlive() || !characterWarrior.isAlive());
    }

    @Test
    public void fightCloseTogether() {
            Random random = new Random(123);
            BattleField battleField = new BattleField();
            Character characterArcher = new Archer(new Point(0, 0), random);
            Character characterWarrior = new AxeWarrior(new Point(1, 0), random);
            battleField.fight(characterArcher, characterWarrior);
            System.out.println(battleField.getRound() + "A:" + characterArcher.isAlive());
            assertTrue(battleField.getRound() > 0);
            assertTrue(!characterArcher.isAlive() || !characterWarrior.isAlive());
    }

    @Test
    public void fightCloseTogetherMore() {
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            BattleField battleField = new BattleField();
            Character characterArcher = new Archer(new Point(0, 0), random);
            Character characterWarrior = new AxeWarrior(new Point(1, 0), random);
            battleField.fight(characterArcher, characterWarrior);
            System.out.println(battleField.getRound() + " kör, Archer:" + characterArcher.isAlive() +", Axe:" +characterWarrior.isAlive());
            assertTrue(battleField.getRound() > 0);
            assertTrue(!characterArcher.isAlive() || !characterWarrior.isAlive());
        }
    }
}