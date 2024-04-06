import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Attack class
 */
public class Attack {
    private static final int BASE_ATTACK = 25;

    private int attackDamage;
    private double multiplier;
    private static List<String> attackMessages;

    public Attack(double multiplier) {
        attackDamage = BASE_ATTACK;
        this.multiplier = multiplier;
        attackMessages = new ArrayList<>();
        attackMessages.add("You studied hard!");
        attackMessages.add("You made progress!");
        attackMessages.add("Keep up the good work!");
    }

    public int getAttackDamage(boolean buffed) {
        if (buffed) {
            return (int) (attackDamage * multiplier);
        }
        return attackDamage;
    }

    public String getRandomMessage() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, attackMessages.size());
        return attackMessages.get(randomNum);
    }
    
}