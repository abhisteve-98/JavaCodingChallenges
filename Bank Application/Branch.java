package Challenge.Java;

import java.util.ArrayList;

public class Branch {
    private final ArrayList<Customer> customers;
    private final String branchName;

    public Branch(String branchName){
        this.branchName=branchName;
        this.customers=new ArrayList<>();
    }

    public String getBranchName(){
        return this.branchName;
    }

    public boolean newCustomer(String name,double initial_amount){
        if(findCustomer(name)==null){
            this.customers.add(new Customer(name,initial_amount));
            return true;
        }
        return false;
    }
    public boolean addCustomerTransaction(String customerName,double amount){
        Customer found=findCustomer(customerName);
        if(found!=null){
            found.addTransaction(amount);
            return true;
        }
        return false;

    }

    private Customer findCustomer(String toFind){
        for(int i=0;i<this.customers.size();i++) {
            Customer search=this.customers.get(i);
            if (search.getName().equals(toFind)) {
                return search;
            }
        }
        return null;
    }
    public void printCustomers(boolean wantTransactions){
        for(int i=0;i<this.customers.size();i++){
            System.out.println((i+1)+"->"+this.customers.get(i).getName());
            if(wantTransactions) {
                System.out.println("Transactions of " + customers.get(i).getName());
                for (int j = 0; j < this.customers.get(i).getTransactions().size(); j++) {
                    System.out.println(j + 1 + "->" + this.customers.get(i).getTransactions().get(j));
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Branch branch1=new Branch("Bank Of Baroda");
//        System.out.println("Initial size of arraylist of customers is:"+branch1.customerSize());
        boolean cus1=branch1.newCustomer("Abhishek",2000);
        if(cus1){
            System.out.println("Successfully added first customer ");
        }
        boolean cus2=branch1.newCustomer("Harshul",3000);
        if(cus2){
            System.out.println("Successfully added second customer ");
        }
        boolean cus3=branch1.newCustomer("Junaid",5000);
        if(cus3){
            System.out.println("Successfully added third customer");
        }
        boolean cus4=branch1.newCustomer("Akash",1000);
        if(cus4){
            System.out.println("Successfully added fourth customer");
        }
//        System.out.println("New size of arraylist of customers is:"+branch1.customerSize());
        branch1.addCustomerTransaction("Abhishek",3000);
        branch1.addCustomerTransaction("Harshul",4000);
        branch1.addCustomerTransaction("Junaid",800);
        branch1.addCustomerTransaction("Akash",9000);
        System.out.println("Branch: "+branch1.getBranchName());
        branch1.printCustomers(true);
    }
}
