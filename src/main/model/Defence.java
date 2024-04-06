import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Defence {
    private int amount;
    private double multiplier;
    private List<String> actions = new ArrayList<>();

    public Defence (int amount,double multiplier) {
        this.amount = amount;
        this.multiplier = multiplier;
        actions.add("go hiking");
        actions.add("take a walk");
        actions.add("do exercises");
        actions.add("go swimming");
        actions.add("fave fun with friends");
    }

    public int getAmount(boolean buffed) {
        if(buffed){
            return (int) (amount * multiplier);
        }
        return amount;
    }

    public String getAction() {
        Random random = new Random();
        return "You choose to "+actions.get(random.nextInt(actions.size()+1))+"! :)";
    }

}