import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Dice Battle Arena Driver Program
 *
 * Java API Classes Used:
 * - ArrayList (store fighters)
 * - Random (dice + target selection)
 * - Collections (shuffle turn order)
 * - Math (damage calculations)
 * - Scanner (user input)
 */
public class Main {

    /**
     * Main method runs the battle simulation.
     * Demonstrates method overloading, object passing,
     * and Java API usage.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        // Create fighters
        ArrayList<Fighter> fighters = new ArrayList<>();
        fighters.add(new Fighter("Knight", 100, 10));
        fighters.add(new Fighter("Samurai", 90, 12));
        fighters.add(new Fighter("Viking", 110, 9));
        fighters.add(new Fighter("Ninja", 80, 14));
        fighters.add(new Fighter("Gladiator", 95, 11));

        System.out.println("=== DICE BATTLE ARENA ===\n");

        // Show starting stats
        for (Fighter f : fighters) {
            System.out.println(f);
        }

        int round = 1;

        // Game loop
        while (fighters.size() > 1) {

            System.out.println("\n--- ROUND " + round + " ---");

            // Shuffle turn order
            Collections.shuffle(fighters);

            for (Fighter attacker : fighters) {

                if (!attacker.isAlive()) continue;

                // Choose random opponent
                Fighter defender;
                do {
                    defender = fighters.get(rand.nextInt(fighters.size()));
                } while (defender == attacker || !defender.isAlive());

                System.out.println("\n" + attacker.getName() + " is attacking " + defender.getName());

                System.out.print("Choose attack (1=Basic, 2=Bonus, 3=Weapon): ");
                int choice = scanner.nextInt();

                int damage;

                // Demonstrates method overloading
                if (choice == 1) {
                    damage = BattleUtils.attack(attacker, defender);
                    System.out.println("Basic attack used!");
                } else if (choice == 2) {
                    damage = BattleUtils.attack(attacker, defender, 1.5);
                    System.out.println("Bonus attack used!");
                } else {
                    damage = BattleUtils.attack(attacker, defender, 5, "Sword");
                    System.out.println("Weapon attack used!");
                }

                System.out.println(attacker.getName() + " dealt " + damage + " damage!");

                if (!defender.isAlive()) {
                    System.out.println("💀 " + defender.getName() + " has been eliminated!");
                }
            }

            // Remove dead fighters
            fighters.removeIf(f -> !f.isAlive());

            round++;
        }

        // Winner
        System.out.println("\n🏆 FINAL WINNER: " + fighters.get(0).getName());

        scanner.close();
    }
}