package main.model;

public class Player extends Person{
    private Skill healing;
    public Player(int HP, int damage, int defence,double multiplier){
        super(0, HP, damage, defence, multiplier);
        healing = new Healing(multiplier);
    }

    public Skill getHealing() {
        return healing;
    }
    public String useHealing(){
        int median =HP;
        median = median +this.healing.getAmount(super.booster.isStatus());
        if(median > 100){
            median = 100;
        }
        HP = median;
        return this.healing.getRandomMessage();
    }
}