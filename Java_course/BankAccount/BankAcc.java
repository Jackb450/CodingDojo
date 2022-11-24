public class BankAcc {
    private double checkBal;
    private double saveBal;
    private long AccNum;
    private static int totalBankAcc = 0;
    private static double totalBal = 0;
    public BankAcc() {
        this.checkBal = 0;
        this.saveBal = 0;
        BankAcc.totalBankAcc++;
        this.AccNum = 100 - (BankAcc.totalBankAcc*7);
    }
    public boolean depositCheck(double deposit) {
        if (deposit < 0) {
            return false;
        } 
        this.checkBal += deposit;
        BankAcc.totalBal += deposit;
        return true;
    }
    public boolean depositSave(double deposit) {
        if (deposit < 0) {
            return false;
        }
        this.saveBal += deposit;
        BankAcc.totalBal += deposit;
        return true;
    }
    public boolean withdrawCheck(double withdrawal) {
        if (withdrawal < 0) {
            return false;
        } 
        else if (withdrawal > this.checkBal) {
            return false;
        }
        this.checkBal -= withdrawal;
        BankAcc.totalBal -= withdrawal;
        return true;
    }
    public boolean withdrawSave(double withdrawal) {
        if (withdrawal < 0) {
            return false;
        }
        else if (withdrawal > this.saveBal) {
            return false;
        }
        this.saveBal -= withdrawal;
        BankAcc.totalBal -= withdrawal;
        return true;
    }
    public long getAccNum() {
        return this.AccNum;
    }
    public double getCheckBal() {
        return this.checkBal;
    }
    public double getSaveBal() {
        return this.saveBal;
    }
    public static int getTotalBankAcc() {
        return BankAcc.totalBankAcc;
    }
    public static double getTotalBal() {
        return BankAcc.totalBal;
    }
    public void display() {
        System.out.printf("---- Bank Account Num: %d ------------\n", this.getAccNum());
        System.out.printf("Checking Balance: $%.2f || Savings Balance: $%.2f\n", this.getCheckBal(), this.getSaveBal());
    }
}