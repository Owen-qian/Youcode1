package main.model;

public abstract class Person {
    protected Skill attack,defence;
    protected Booster booster;
    protected int HP,type;
    private int shield;

    public int getShield() {
        return shield;
    }

    public Person(int type, int HP, int damage, int defence,double multiplier){
        this.type = type;
        this.HP = HP;
        this.defence = new Defence(type,defence,multiplier);
        this.attack = new Attack(type,damage,multiplier);
        this.booster = new Booster(type);
    }

    public Skill getAttack() {
        return attack;
    }

    public Booster getBooster() {
        return booster;
    }

    public Skill getDefence() {
        return defence;
    }
    public String useAttack(Person p){
        int amount = this.attack.getAmount(this.booster.isStatus());
        p.beAttacked(amount);
        return this.attack.getRandomMessage();
    }
    public String useDefence(){
        shield = this.defence.getAmount(this.booster.isStatus());
        return this.defence.getRandomMessage();
    }
    public String useBooster(){
        return this.booster.print();
    }
    public void beAttacked(int amount){
        if (shield > 0){
            if(shield >= amount){
                shield = shield - amount;
            } else {
                HP = HP + shield -amount;
                shield=0;
            }
        }  else {
            HP = HP - amount;
        }
    }
    private boolean check() {
        return HP <= 0;
    }
}