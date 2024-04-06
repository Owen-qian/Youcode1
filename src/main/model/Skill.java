package main.model;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Skill {
    protected int PLAYER_TYPE = 0;
    protected int MONSTER_TYPE = 1;

    protected int amount;
    protected double multiplier;
    protected List<String> messages;

    public Skill(int characterType, int amount, double multiplier) {
        this.amount = amount;
        this.multiplier = multiplier;
        this.messages = new ArrayList<>();
        setMessages(characterType);
    }

    public abstract void setMessages(int characterType);

    public int getAmount(boolean buffed) {
        if (buffed) {
            return (int) (amount * multiplier);
        }
        return amount;
    }

    public String getRandomMessage() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, messages.size());
        return messages.get(randomNum);
    }
}
