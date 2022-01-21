import java.util.*;

public class Atm {

    static Scanner sc = new Scanner(System.in);
    static String Admin_Name = "SARP";
    static String Admin_Password = "2006";
    static int Admin_Attempt = 1;

    static int At[] = new int[4];
    static int At1[] = new int[4];
    static int Atmamount;
    static int Amount = 0;

    static String User_Name = "sabari";
    static String User_Password = "2021";
    static int User_Attempt = 1;

    // Admin Login

    public static void Admin_Login() {
        while (Admin_Attempt <= 3) {
            System.out.print("\033[H\033[2J");
            System.out.println("Welcome Admin");
            System.out.println();
            System.out.println("Enter Admin Name: ");
            String Adname = sc.next();
            sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.println("Enter Admin Password: ");
            String Adpass = sc.next();
            sc.nextLine();

            // check Adname , Adpass and Admin_Name , Admin_Password are equal

            if (Admin_Name.equals(Adname) && Admin_Password.equals(Adpass)) {
                Admin();
            } else {
                Admin_Attempt = Admin_Attempt + 1;
            }
            if (Admin_Attempt == 4) {
                System.out.println("Your Account Has Been Locked ! ");
                main(null);
            }

        }
    }

    // user login

    public static void User_Login() {

        while (User_Attempt <= 3) {
            System.out.print("\033[H\033[2J");
            System.out.println("Welcome User");
            System.out.println();
            System.out.println("Enter User Name: ");
            String Usname = sc.next();
            sc.nextLine();
            //System.out.print("\033[H\033[2J");
            System.out.println("Enter User Password: ");
            String Uspass = sc.next();
            sc.nextLine();

            // check user_name , user_password and usname , uspass are equal

            if (User_Name.equals(Usname) && User_Password.equals(Uspass)) {
                User();
                //break;
            } else {
                System.out.println("1 attempt over");
                User_Attempt = User_Attempt + 1;
            }
            
            }
            if (User_Attempt == 4) {
                System.out.println("Your Account Has Been Locked ! ");
                main(null);

        }
    }

    // Admin Panel

    public static void Admin() {
        int i = 1;
        System.out.print("\033[H\033[2J");

        while (i != 0) {
            System.out.println();
            System.out.println("Welcome Admin " + Admin_Name);
            System.out.println();
            System.out.println("1.Deposit");
            System.out.println();
            System.out.println("2.Check Balance");
            System.out.println();
            System.out.println("3.Exit");
            int a = sc.nextInt();

            switch (a) {
                case 1:

                    // Deposit
                    System.out.print("\033[H\033[2J");

                    System.out.print("Enter the amount in 2000 : ");
                    int x = sc.nextInt();
                    At[0] += x * 2000;
                    System.out.print("Enter the amount in 500 : ");
                    x = sc.nextInt();
                    At[1] += x * 500;
                    System.out.print("Enter the amount in 200 : ");
                    x = sc.nextInt();
                    At[2] += x * 200;
                    System.out.print("Enter the amount in 100 : ");
                    x = sc.nextInt();
                    At[3] += x * 100;

                    System.out.println();

                    int Atmamount = At[0] + At[1] + At[2] + At[3];
                    System.out.println("Total Amount = " + Atmamount);
                    System.out.print("Your Amount Have Been Deposited Successfully");
                    System.out.println();

                    break;

                case 2:

                    // Atm Balance
                    System.out.print("\033[H\033[2J");
                    System.out.println();

                    System.out.println("2000 count : " + (At[0] / 2000) + " Amount Present : " + At[0]);
                    System.out.println("500 count : " + (At[1] / 500) + " Amount Present : " + At[1]);
                    System.out.println("200 count : " + (At[2] / 200) + " Amount Present : " + At[2]);
                    System.out.println("100 count : " + (At[3] / 100) + " Amount Present : " + At[3]);
                    System.out.println("ATM Balance : " + (At[0] + At[1] + At[2] + At[3]));
                    break;

                case 3:

                    // Return to Main Function

                    System.out.print("\033[H\033[2J");
                    main(null);
                    break;

                default:

                    // None of the case Matches

                    System.out.println("Enter The Valid Case ! ");

            }
        }
    }

    // Withdraw function
    public static void Width_draw(int Widthdraw_Amount) {
        int initial[] = { 0, 0, 0, 0 };
        int temp = Widthdraw_Amount;
        int presentCount1[] = { At[0] / 2000, At[1] / 500, At[2] / 200, At[3] / 100 };// ATM Balance
        int presentCount[] = new int[4];
        for (int i = 0; i < 4; i++) {
            presentCount[i] = presentCount1[i];
        }
        if (Widthdraw_Amount % 10 == 0 && Widthdraw_Amount % 100 == 0) {
            while (Widthdraw_Amount >= 2000 && presentCount[0] > 0)// Withdraw Amount is greater than 2000
            {
                Widthdraw_Amount -= 2000;
                presentCount[0]--;
                initial[0]++;
            }
            while (Widthdraw_Amount >= 500 && presentCount[1] > 0)// Withdraw Amount is greater than 500
            {
                Widthdraw_Amount -= 500;
                presentCount[1]--;
                initial[1]++;
            }
            while (Widthdraw_Amount >= 200 && presentCount[2] > 0) // Withdraw Amount is greater than 200
            {
                Widthdraw_Amount -= 200;
                presentCount[2]--;
                initial[2]++;
            }
            while (Widthdraw_Amount >= 100 && presentCount[3] > 0) // Withdraw Amount is greater than 100
            {
                Widthdraw_Amount -= 100;
                presentCount[3]--;
                initial[3]++;
            }

            if (Widthdraw_Amount == 0) {
                At[0] = presentCount[0] * 2000;
                At[1] = presentCount[1] * 500;
                At[2] = presentCount[2] * 200;
                At[3] = presentCount[3] * 100;
                Amount -= temp;//
                System.out.println("Widthdraw Successfully !");
            } else {
                System.out.println("! Sorry for the inconvinience !");
            }
        }
    }

    // User Panel

    public static void User() {
        int i = 1;
        System.out.print("\033[H\033[2J");

        while (i != 0) {
            System.out.println("Welcome User " + User_Name);
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.Check Balance");
            System.out.println("4.Mini Statement");
            System.out.println("5.Change Pin");
            System.out.println("6.Exit");

            int a = sc.nextInt();

            switch (a) {
                case 1:

                    // Deposit
                    System.out.print("\033[H\033[2J");

                    System.out.print("Enter the amount in 2000 : ");
                    int x = sc.nextInt();
                    At[0] += x * 2000;
                    System.out.print("Enter the amount in 500 : ");
                    x = sc.nextInt();
                    At[1] += x * 500;
                    System.out.print("Enter the amount in 200 : ");
                    x = sc.nextInt();
                    At[2] += x * 200;
                    System.out.print("Enter the amount in 100 : ");
                    x = sc.nextInt();
                    At[3] += x * 100;

                    System.out.println();

                    int Amount = At[0] + At[1] + At[2] + At[3];
                    System.out.println("Total Amount = " + Amount);
                    System.out.println("Your Cash Has Been Deposited Sucessfully");
                    break;

                case 2:

                    // withdraw
                    System.out.print("\033[H\033[2J");

                    System.out.print("Enter Amount To Be Withdrawn : ");
                    int Withdraw = sc.nextInt();
                    if (Withdraw <= (At[0] + At[1] + At[2] + At[3])) {
                        if (Withdraw <= javasec.Amount) {
                            Width_draw(Withdraw);
                        } else {
                            System.out.println("Insufficient Amount In your Account !");
                        }
                    } else {
                        System.out.println("InSufficient Amount in ATM !");
                    }
                    break;

                case 3:

                    // Check Balance
                    System.out.print("\033[H\033[2J");

                    System.out.println("2000 count : " + (At1[0] / 2000) + " Amount Present : " + At1[0]);
                    System.out.println("500 count : " + (At1[1] / 500) + " Amount Present : " + At1[1]);
                    System.out.println("200 count : " + (At1[2] / 200) + " Amount Present : " + At1[2]);
                    System.out.println("100 count : " + (At1[3] / 100) + " Amount Present : " + At1[3]);
                    System.out.println("User Balance : " + javasec.Amount);
                    break;

                case 4:

                    // Mini Statement
                    System.out.print("\033[H\033[2J");

                    System.out.println("User Balance : " + javasec.Amount);
                    Date date = new Date();
                    System.out.println(date.toString());
                    break;

                case 5:

                    // Change Pin
                    System.out.print("\033[H\033[2J");

                    System.out.print("Enter the New Pin : ");
                    String New_Pin = sc.nextLine();
                    User_Password = New_Pin;
                    System.out.println("Your Pin has been Changed !");
                    break;

                case 6:

                    // Back To Main Function

                    System.out.print("\033[H\033[2J");
                    main(null);
                    break;

                default:

                    // None Of The Case Matches

                    System.out.println("! Enter the valid case !");
                    break;

            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to ATM");
        System.out.println("1.Admin");
        System.out.println("2.User");
        System.out.println("4.Exit");
        System.out.println("Choose the operation you want to perform:");

        int n = sc.nextInt();
        switch (n) {

            // Go to Admin Login
            case 1:
                Admin_Login();
                break;

            // Go to User Login
            case 2:
                User_Login();
                break;

            // Exit from main function
            case 3:
                System.out.print("\033[H\033[2J");
                System.out.print("\033[H\033[2J");
                System.out.println("Exit successfully");
                break;

            // None of the cases matches
            default:
                System.out.println("! Enter the valid cases !");
                break;
        }

    }

}