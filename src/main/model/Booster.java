package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Booster{
    private boolean status = false;
    private int rounds;
    private int type;
    private List<String> actions = new ArrayList<>();
    public Booster(int type){

        actions.add("engage in meditation");
        actions.add("sleep earlier");
        actions.add("read a book");
        actions.add("seek help from a psychiatrist");
        actions.add("eat some healthy food");
        this.type=type;
    }

    public boolean isStatus() {
        return status;
    }

    public String print(){
        if(type == 1){
            String action = "You found out that work is harder than you thought :(";
            return action;
        }
        Random random = new Random();
        String action = "You choose to "+actions.get(random.nextInt(actions.size()))+". You will work better! :)";
        status =true;
        rounds = 3;
        return action;
    }
    public String check(){
        if(rounds>0){
            String string = "The motivation will keep for " + rounds +" days, keep going!";
            rounds --;
            return string;
        }   else{
            status =false;
            String string = "Oh no! You feel a little tired. Take it easy!";
            return string;
        }
    }

    public int getRounds() {
        return rounds;
    }

}