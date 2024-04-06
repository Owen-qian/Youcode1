package main.model;

public class Monster extends Person{
    private Skill healing;
    public Monster(int HP, int damage, int defence,double multipler) {
        super(1, HP, damage, defence, multipler);
    }
}