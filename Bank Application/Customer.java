package Challenge.Java;

import java.util.ArrayList;

public class Customer {
    private final ArrayList<Double> transactions;
    private final String name;

    public Customer(String name,double initial_amount){
        this.name=name;
        this.transactions=new ArrayList<>();
        addTransaction(initial_amount);
    }

    public String getName() {
        return name;
    }
    public void addTransaction(double addAmount){
        transactions.add(addAmount);

    }
    public ArrayList<Double> getTransactions(){
        return transactions;
    }

}
