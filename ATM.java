public class ATM {
    private int balance;
    private int pin;

    public ATM(int balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    public void displayMenu() {
        System.out.println("1: Check Balance");
        System.out.println("2: Deposit");
        System.out.println("3: Withdraw");
        System.out.println("4: Change Pin");
        System.out.println("5: Exit");
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        if (balance < amount) {
            System.out.println("Insufficient Funds!");
            return;
        }
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public boolean validatePin(int pin) {
        return this.pin == pin;
    }

    public void changePin(int newPin) {
        pin = newPin;
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1000, 1234);
        System.out.print("Enter the Pin: ");
        int pin = Integer.parseInt(System.console().readLine());
        if (atm.validatePin(pin)) {
            int option = 0;
            while (option != 5) {
                atm.displayMenu();
                option = Integer.parseInt(System.console().readLine());
                switch (option) {
                    case 1:
                        System.out.println("Balance: " + atm.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter Amount: ");
                        int depositAmount = Integer.parseInt(System.console().readLine());
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter Amount: ");
                        int withdrawAmount = Integer.parseInt(System.console().readLine());
                        atm.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.print("Enter New Pin: ");
                        int newPin = Integer.parseInt(System.console().readLine());
                        atm.changePin(newPin);
                        break;
                    case 5:
                        System.out.println("Thank You for using ATM!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        } else {
            System.out.println("Invalid PIN!");
        }
    }
}


