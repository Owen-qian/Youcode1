package main.model;

import java.util.Random;

public class Monster extends Person {
    private int defenceCount;
    private int max_HP;
    private int count = 0;
    public Monster(int HP, int damage, int defence, double multipler,String name) {
        super(1, HP, damage, defence, multipler,name);
        max_HP = HP;
        this.defenceCount = 3;
    }

    public int getMaxHP(){
        return max_HP;
    }
    public String randomAction(Person p) {
        Random random = new Random();
        double hpPercentage = (double) HP / max_HP;

        // Monster always boosts itself in the first round
        if (count == 0) {
            count++;
            return useBooster();
        }

        // If HP is higher than 50%
        if (hpPercentage > 0.5) {
            double randomNumber = random.nextDouble();
            if (randomNumber < 0.7) {
                // 70% possibility to attack
                return useAttack(p); // Assuming the monster always attacks the opponent
            } else {
                // 30% possibility to boost
                return useBooster();
            }
        } else { // If HP is lower than or equal to 50%
            if (defenceCount > 0) {
                double randomNumber = random.nextDouble();
                if (randomNumber < 0.33) {
                    // 33% possibility to attack
                    return useAttack(p); // Assuming the monster always attacks the opponent
                } else if (randomNumber < 0.67) {
                    // 33% possibility to boost
                    return useBooster();
                } else {
                    // 33% possibility to defend
                    defenceCount--;
                    return useDefence();
                }
            } else {
                // If no defence actions left, possibilities become same as HP > 50%
                double randomNumber = random.nextDouble();
                if (randomNumber < 0.7) {
                    // 70% possibility to attack
                    return useAttack(p); // Assuming the monster always attacks the opponent
                } else {
                    // 30% possibility to boost
                    return useBooster();
                }
            }
        }
    }
}
