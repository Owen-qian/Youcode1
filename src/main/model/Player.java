package main.model;

public class Player extends Person{
    private Skill healing;
    public Player(int HP, int damage, int defence,double multiplier,String name){
        super(0, HP, damage, defence, multiplier, name);
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
    public void setHP(int HP){
        this.HP = HP;
    }
}