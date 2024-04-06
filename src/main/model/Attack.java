import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Attack class
 */
public class Attack {
    private static final int BASE_ATTACK = 25;

    private int attackDamage;
    private boolean boosted;
    private static List<String> attackMessages;

    public Attack() {
        attackDamage = BASE_ATTACK;
        boosted = false;
        attackMessages = new ArrayList<>();
        attackMessages.add("You studied hard!");
        attackMessages.add("You made progress!");
        attackMessages.add("Keep up the good work!");
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public boolean getBoosted() {
        return boosted;
    }

    public String getRandomMessage() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, attackMessages.size());
        return attackMessages.get(randomNum);
    }
    
}