import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Attack class
 */
public class Healing {
    private static final int BASE_HEALING = 25;

    private int healingPoints;
    private double multiplier;
    private static List<String> healingMessages;

    public Healing(double multiplier) {
        healingPoints = BASE_HEALING;
        this.multiplier = multiplier;
        healingMessages = new ArrayList<>();
        healingMessages.add("You rested well!");
        healingMessages.add("Great relaxation session!");
        healingMessages.add("Self-care is important!");
    }

    public int getHealingPoints(boolean buffed) {
        if (buffed) {
            return (int) (healingPoints * multiplier);
        }
        return healingPoints;
    }

    public String getRandomMessage() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, healingMessages.size());
        return healingMessages.get(randomNum);
    }
    
}
