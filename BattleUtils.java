import java.util.Random;

/**
 * BattleUtils provides utility methods for performing attacks
 * and dice-based combat logic.
 */
public class BattleUtils {

    private static Random rand = new Random();

    /**
     * Basic attack (no modifiers).
     * @param attacker attacking fighter
     * @param defender defending fighter
     * @return damage dealt
     */
    public static int attack(Fighter attacker, Fighter defender) {
        int roll = rand.nextInt(6) + 1;
        int damage = attacker.getAttackPower() + roll;
        defender.takeDamage(damage);
        return damage;
    }

    /**
     * Bonus attack with multiplier.
     * @param attacker attacking fighter
     * @param defender defending fighter
     * @param multiplier damage multiplier
     * @return damage dealt
     */
    public static int attack(Fighter attacker, Fighter defender, double multiplier) {
        int roll = rand.nextInt(6) + 1;
        int damage = (int) Math.round((attacker.getAttackPower() + roll) * multiplier);
        defender.takeDamage(damage);
        return damage;
    }

    /**
     * Weapon-based attack with bonus damage.
     * @param attacker attacking fighter
     * @param defender defending fighter
     * @param bonusDamage additional fixed damage
     * @param weaponName name of weapon used
     * @return damage dealt
     */
    public static int attack(Fighter attacker, Fighter defender, int bonusDamage, String weaponName) {
        int roll = rand.nextInt(6) + 1;
        int damage = attacker.getAttackPower() + roll + bonusDamage;
        defender.takeDamage(damage);
        return damage;
    }

    /**
     * Rolls multiple dice.
     * @param count number of dice
     * @return total roll value
     */
    public static int rollDice(int count) {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += rand.nextInt(6) + 1;
        }
        return total;
    }
}