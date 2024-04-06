package main.model;

public class Healing extends Skill {
    private static final int BASE_HEALING = 20;

    public Healing(double multiplier) {
        super(0, BASE_HEALING, multiplier);
    }

    public void setMessages(int type) {
        messages.add("You rested well!");
        messages.add("Great relaxation session!");
        messages.add("Self-care is important!");
    }
}
