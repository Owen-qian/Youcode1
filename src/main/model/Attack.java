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
            messages.add("The enemy attacked");
            messages.add("You were a victim of procrastination");
            messages.add("Monster retaliated when you were distracted from your work");
        }
    }    
}