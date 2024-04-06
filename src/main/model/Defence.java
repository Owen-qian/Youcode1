package main.model;

public class Defence extends Skill {

    public Defence (int characterType, int amount, double multiplier) {
        super(characterType, amount, multiplier);
    }

    public void setMessages(int characterType) {
        if (characterType == PLAYER_TYPE) {
            messages.add("Explore the outdoors");
            messages.add("Take a walk outside");
            messages.add("Go for a hike");
            messages.add("Do some exercises");
            messages.add("Go swimming");
        } else if (characterType == MONSTER_TYPE) {
            messages.add("The enemy strengthened itself");
            messages.add("Your hits will deal less damage");
            messages.add("Monster is defending");
        }
    }

}