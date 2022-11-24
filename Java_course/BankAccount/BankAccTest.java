import java.util.ArrayList;

public class BankAccTest {
    public static void main(String[] args) {
        ArrayList<BankAcc> bankAccList = new ArrayList<BankAcc>();
        bankAccList.add(new BankAcc());
        bankAccList.add(new BankAcc());
        bankAccList.add(new BankAcc());
        printBankAccList(bankAccList);
        System.out.println("");
        System.out.println("-----------------------------------------------------");
        System.out.println("Depositing $10 in checking and savings account 1: " + bankAccList.get(0).depositCheck(10) + bankAccList.get(0).depositSave(10));
        System.out.println("Depositing $25 in checking and savings account 2: " + bankAccList.get(1).depositCheck(25) + bankAccList.get(1).depositSave(25));
        System.out.println("Depositing $40 in checking and savings account 3: " + bankAccList.get(2).depositCheck(40) + bankAccList.get(2).depositSave(40));
        System.out.println("");
        printBankAccList(bankAccList);
        System.out.println("-----------------------------------------------------");
        System.out.println("Depositing $30 in checking and savings account 1: " + bankAccList.get(0).depositCheck(30) + bankAccList.get(0).depositSave(30));
        System.out.println("Depositing -$30 in checking account 2: " + bankAccList.get(1).depositCheck(-30) + ", and depositing $20 in savings account 2: " + bankAccList.get(1).depositSave(20));
        System.out.println("Depositing $150 in checking account 3: " + bankAccList.get(2).depositCheck(150) + ", and depositing -$50 in savings account 3: " + bankAccList.get(2).depositSave(-50));
        System.out.println("");
        printBankAccList(bankAccList);
        System.out.println("-----------------------------------------------------");
        System.out.println("Withdrawing -$50 in checking account 1: " + bankAccList.get(0).withdrawCheck(-50) + ", and withdrawing $15 in savings account 1: " + bankAccList.get(0).withdrawSave(15));
        System.out.println("Withdrawing $20 in checking account 2: " + bankAccList.get(1).withdrawCheck(20) + ", and withdrawing $60 in savings account 2: " + bankAccList.get(1).withdrawSave(60));
        System.out.println("Withdrawing $200 in checking account 3: " + bankAccList.get(2).withdrawCheck(200) + ", and withdrawing $25 in savings account 3: " + bankAccList.get(2).withdrawSave(25));
        System.out.println("");
        printBankAccList(bankAccList);
    }
    public static void printBankAccList(ArrayList<BankAcc> bankAccList) {
        System.out.println("-- Displaying all bank accounts --");
        for (BankAcc bankAcc : bankAccList) {
            bankAcc.display();
        }
        System.out.println("Total Number of bank accounts: " + BankAcc.getTotalBankAcc());
        System.out.printf("Total Bank Account Balance: $%.2f\n", BankAcc.getTotalBal());
    }
}