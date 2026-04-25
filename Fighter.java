/**
 * Fighter class represents a combatant in the Dice Battle Arena.
 * It encapsulates name, hit points (HP), and attack power.
 */
public class Fighter {

    private String name;
    private int hp;
    private int attackPower;

    /**
     * Constructs a Fighter object.
     * @param name the fighter's name
     * @param hp the fighter's starting hit points
     * @param attackPower the fighter's attack strength
     */
    public Fighter(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    /** @return fighter's name */
    public String getName() {
        return name;
    }

    /** @return current HP */
    public int getHp() {
        return hp;
    }

    /** @return attack power */
    public int getAttackPower() {
        return attackPower;
    }

    /** @param hp sets the fighter's HP */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Applies damage to the fighter.
     * @param damage amount of damage taken
     */
    public void takeDamage(int damage) {
        hp = Math.max(0, hp - damage);
    }

    /**
     * Checks if fighter is alive.
     * @return true if HP > 0
     */
    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String toString() {
        return name + " (HP: " + hp + ", ATK: " + attackPower + ")";
    }
}