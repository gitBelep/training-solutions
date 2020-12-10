package abstractclass.gamecharacter;

public class BattleField {
    private int round;

    private boolean oneHit(Character attacker, Character defender){
        boolean bothAlive = attacker.isAlive() && defender.isAlive();
        if (bothAlive){
            attacker.primaryAttack(defender);
        }
        if (bothAlive){
            attacker.secondaryAttack(defender);
        }
        return bothAlive;
    }

    public Character fight(Character one, Character other){
        boolean bothAlive = true;
        Character attacker = one;
        Character defender = other;
        Character swapper = null;
        while (bothAlive){
            oneHit(attacker, defender);
            swapper =  defender;
            defender = attacker;
            attacker = swapper;
            bothAlive = one.isAlive() && other.isAlive();
            round++;
        }
        swapper = one.isAlive() ? one : other;
        return swapper;
    }


    public int getRound() {
        return round;
    }
}
