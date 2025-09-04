import java.util.*;

class ATM {
    private double balance;
    private List<String> history = new ArrayList<>();

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        history.add("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            history.add("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void transfer(double amount, String toAccount) {
        if (amount <= balance) {
            balance -= amount;
            history.add("Transferred " + amount + " to " + toAccount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void showHistory() {
        System.out.println("\n--- Transaction History ---");
        for (String h : history) System.out.println(h);
        System.out.println("Current Balance: " + balance);
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM(1000);

        while (true) {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1: atm.showHistory(); break;
                case 2: System.out.print("Enter amount: "); atm.withdraw(sc.nextDouble()); break;
                case 3: System.out.print("Enter amount: "); atm.deposit(sc.nextDouble()); break;
                case 4: System.out.print("Enter amount: "); double amt = sc.nextDouble();
                        System.out.print("Enter account to transfer: "); String acc = sc.next();
                        atm.transfer(amt, acc); break;
                case 5: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
            sc.close();
        }
    }
}
