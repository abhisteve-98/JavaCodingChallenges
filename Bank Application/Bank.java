package Challenge.Java;

import java.util.ArrayList;
//import java.util.Scanner;

public class Bank {

    private final String Name;
    private final ArrayList<Branch> branches;
    public Bank(String bankName){
        this.Name=bankName;
        this.branches=new ArrayList<>();
    }
    public String getBankName(){
        return this.Name;
    }

    public boolean addBranch(String branchName){
        if(findBranch(branchName)==null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }
    public boolean addCustomer(String branchName,String customerName,double initial_amount){
            Branch branch= findBranch(branchName);
            if( branch!=null ){
                return branch.newCustomer(customerName,initial_amount);
            }
        return false;
    }
    public boolean addCustomerTransaction(String branchName,String customerName,double amount){
        Branch branch=findBranch(branchName);
        if(branch!=null){
            return branch.addCustomerTransaction(customerName,amount);
        }
        return false;

    }
    public Branch findBranch(String FindBranchName){
        for(int i=0;i<this.branches.size();i++){
            Branch Found_branch = this.branches.get(i);
            if(Found_branch.getBranchName().equals(FindBranchName)){
                return Found_branch;
            }
        }
        return null;
    }
    public void listCustomers(String branchName,boolean showTransactions){
        Branch branch=findBranch(branchName);
        if(branch!=null){
            System.out.println("Customer details of the branch: "+branch.getBranchName());
            branch.printCustomers(showTransactions);
        }
    }

    public static void main(String[] args) {

        Bank bank1 = new Bank("Punjab National Bank");
        boolean done1=bank1.addBranch("Shastri Nagar");
        boolean done2=bank1.addCustomer("Shastri Nagar","Abhishek Stephen",2000);
        boolean done3=bank1.addCustomer("Shastri Nagar","Harshul Varshney",3000);
        boolean done4=bank1.addCustomer("Shastri Nagar","Junaid Chaudhary",4000);
        boolean done5=bank1.addCustomer("Shastri Nagar","Aakash Tyagi",5000);
        boolean done6=bank1.addCustomerTransaction("Shastri Nagar","Abhishek Stephen",4000);
        boolean done7=bank1.addCustomerTransaction("Shastri Nagar","Harshul Varshney",6000);
        boolean done8=bank1.addCustomerTransaction("Shastri Nagar","Junaid Chaudhary",8000);
        boolean done9=bank1.addCustomerTransaction("Shastri Nagar","Aakash Tyagi",10000);
        bank1.listCustomers("Shastri Nagar",false);
        System.out.println("Bank Name: "+bank1.getBankName());





    }

}
