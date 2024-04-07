package main.model;

public class Attack extends Skill {

    public Attack(int characterType, int attackDamage, double multiplier) {
        super(characterType, attackDamage, multiplier);
    }

    public void setMessages(int characterType) {
        if (characterType == PLAYER_TYPE) {
            messages.add("You studied hard");
            messages.add("You made progress");
            messages.add("Keep up the good work");
        } else if (characterType == MONSTER_TYPE) {
            messages.add("Massive work makes you stressful");
            messages.add("You were a victim of procrastination");
            messages.add("You were distracted from your work. Things become worse.");
        }
    }    
}