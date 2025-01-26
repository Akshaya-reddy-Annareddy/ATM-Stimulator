import java.util.*;
public class ATM {
    static int pin = 4545;
    static double bankbal = 50000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bank obj = new Bank();

        while (true) {
            System.out.println("1. Bank balance enquiry\n2. Cash withdrawal\n3. Pin change\nEnter E to stop");

            System.out.print("Select one option: ");
            String opt = sc.nextLine();

            if (opt.equals("E")) {
                System.out.println("Thank you!");
                break;
            }

            switch (opt) {
                case "1":
                    System.out.print("Enter pin: ");
                    int userpin1 = sc.nextInt();
                    sc.nextLine();
                    if (userpin1 == pin) {
                        obj.checkbalance();
                    } else {
                        System.out.println("Wrong pin");
                    }
                    break;
                case "2":
                    System.out.print("Enter pin: ");
                    int userpin2 = sc.nextInt();
                    sc.nextLine();
                    if (userpin2 == pin) {
                        obj.withdraw();
                    } else {
                        System.out.println("Wrong pin");
                    }
                    break;
                case "3":
                    System.out.print("Enter pin: ");
                    int userpin3 = sc.nextInt();
                    sc.nextLine();
                    if (userpin3 == pin) {
                        System.out.print("Enter new pin: ");
                        int newPin = sc.nextInt();
                        sc.nextLine();
                        obj.pinchange(newPin);
                    } else {
                        System.out.println("Wrong pin");
                    }
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }

        sc.close();
    }
}

class Bank {
    Scanner sc = new Scanner(System.in);
    public void withdraw() {
        if (ATM.bankbal > 0) {
            System.out.print("Enter cash to withdraw: ");
            int wdcash = sc.nextInt();
            sc.nextLine();
            if (wdcash <= ATM.bankbal) {
                ATM.bankbal -= wdcash;
                System.out.println("Withdrawal successful. Please take the money.");
                System.out.println("Remaining balance: " + ATM.bankbal);
            } else {
                System.out.println("Not sufficient balance in your account");
            }
        } else {
            System.out.println("Your account doesn't have money");
        }
    }

    public void checkbalance() {
        System.out.println("Your bank balance is: " + ATM.bankbal);
    }

    public void pinchange(int x) {
        ATM.pin = x;
        System.out.println("Updated pin: " + ATM.pin);
    }
}
