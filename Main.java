import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Map<String, User> map = new HashMap<>();
    static Map<String, Banker> map2 = new HashMap<>();

    public static void main(String[] args) {

            User user1 = new User("akash", 12, "qtrno p-30/12", "akash1910", "akash1910", 5000, 1234);
            map.put("akash1910", user1);
            User user2 = new User("suhash", 12, "qtrno p-30/10", "suhash1910", "suhash1910", 5000, 1232);
            map.put("suhash1910", user2);
            User user3 = new User("aalu", 12, "qTrno p-30/16", "aalu1910", "aalu1910", 5000, 1432);
            map.put("aalu1910", user3);
            User user4 = new User("laalu", 12, "qtrno p-30/15", "laalu1910", "laalu1910", 5000, 1334);
            map.put("laalu1910", user4);
            Banker banker1 = new Banker("janak", 44, "janak22", "janak22");
            map2.put("janak22", banker1);
            Banker banker2 = new Banker("kashvi", 48, "kaashvi33", "kaashvi33");
            map2.put("kaashvi33", banker2);
            MainMenu();
        }
    public static void registerUser() {
        try {
            Scanner sc = new Scanner(System.in);
            User user = new User();
            System.out.println("Enter your name:");
            user.setName(sc.next());
            System.out.println("Enter your age:");
            user.setAge(sc.nextInt());
            System.out.println("Enter your address:");
            user.setAddress(sc.next());
            System.out.println("Enter your account name:");
            user.setAccName(sc.next());
            System.out.println("Enter your account password:");
            user.setPassword(sc.next());
            System.out.println("Enter your account pin");
            user.setPin(sc.nextInt());
            map.put(user.getAccName(), user);
            System.out.println("you have been succesfully registered to the system");
        }catch(Exception e){
            System.out.println("please enter the details correctly");
        }
    }
    public static void loginUSer() {
        try {
            String pass, uname;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your account name:");
            uname = sc.nextLine();
            //for (String key : map.keySet()) {
            if (map.containsKey(uname)) {
                System.out.println("enter your password:");
                pass = sc.nextLine();
                if (pass.equals(map.get(uname).getAccName())) {
                    System.out.println("login succesfull");
                    System.out.println("****************************************");
                    int q = 1;
                    do {
                        Scanner k = new Scanner(System.in);
                        System.out.println("WELCOME TO LOGIN PAGE " + map.get(uname).getAccName());
                        System.out.println("****************************************");
                        System.out.println("select from the options\n");
                        System.out.println("1.SHOW ACCOUNT BALANCE");
                        System.out.println("2.DEPOSIT AMOUNT");
                        System.out.println("3.WITHDRAW AMOUNT");
                        System.out.println("4.TRANSFER AMOUNT");
                        System.out.println("5.GENERATE PIN");
                        System.out.println("6.LOGOUT");
                        System.out.println("enter your choice");
                        int z = k.nextInt();
                        switch (z) {
                            case 1: {
                                System.out.println("you selected to show account balance");
                                System.out.println("enter pin:");
                                int lo = k.nextInt();
                                if (map.get(uname).getPin() == lo) {
                                    System.out.println("ur account has Rs" + map.get(uname).getBalance());
                                } else System.out.println("incorrect pin");
                                break;
                            }
                            case 2: {
                                System.out.println("you selected to deposit amount ");
                                System.out.println("enter the amount you want to deposit:");
                                double g = sc.nextDouble();
                                System.out.println("enter pin:");
                                int lo = k.nextInt();
                                if (map.get(uname).getPin() == lo) {
                                    map.get(uname).setBalance(g + map.get(uname).getBalance());
                                    System.out.println("Rs" + g + " deposited succesfully");
                                    System.out.println("account balance: Rs" + map.get(uname).getBalance());
                                } else System.out.println("incorrect pin");
                                break;
                            }
                            case 3: {
                                System.out.println("you selected to withdraw amount");
                                System.out.println("enter the amount you want to withdraw");
                                double g = sc.nextDouble();
                                System.out.println("enter pin:");
                                int lo = k.nextInt();
                                if (map.get(uname).getPin() == lo) {
                                    if (g > (map.get(uname).getBalance())) {
                                        System.out.println("you dont have enough amount in your account");
                                        System.out.println("account balance: Rs" + map.get(uname).getBalance());
                                    } else {
                                        System.out.println("Rs" + g + " withdrawn succesfully");
                                        map.get(uname).setBalance(map.get(uname).getBalance() - g);
                                        System.out.println("account balance: Rs" + map.get(uname).getBalance());
                                    }
                                } else System.out.println("incorrect pin");
                                break;

                            }
                            case 4: {
                                System.out.println("you selected to transfer amount");
                                System.out.println("enter the account name to which you want to transfer money:");
                                String g = sc.next();
                                System.out.println("enter the amount to be transferred:");
                                double amt = sc.nextDouble();
                                System.out.println("enter your pin");
                                int c = sc.nextInt();
                                if (map.get(uname).getPin() == c) {
                                    if(map.get(uname).getBalance()<amt){
                                        System.out.println("you dont have enough amount in your account");
                                        System.out.println("amount balance :Rs"+map.get(uname).getBalance());
                                    }
                                    else {
                                        map.get(uname).setBalance(map.get(uname).getBalance() - amt);
                                        map.get(g).setBalance(map.get(g).getBalance() + amt);
                                        System.out.println("money transferred succesfully");
                                        System.out.println("account balance :Rs" + map.get(uname).getBalance());
                                    }
                                } else System.out.println("invalid pin");
                                break;
                            }
                            case 5: {
                                System.out.println("you selected to generate new pin");
                                Random rand = new Random();
                                int king = rand.nextInt(10000);
                                System.out.println("your pin is :" + king);
                                map.get(uname).setPin(king);
                                break;

                            }
                            case 6:{
                                System.out.println("logging you out");
                                MainMenu();
                                break;
                            }
                            default: {
                                System.out.println("invalid choice");

                            }
                        }
                        System.out.println("do you wish to continue[1-yes/2-no]");
                        int g = sc.nextInt();
                        if (g == 2) {
                            q++;
                            System.out.println("logging you out");
                            System.out.println("taking you back to main menu");
                        }


                    } while (q == 1);
                } else System.out.println("login unsuccesfull");
            } else System.out.println("you need to register first");
        }catch (Exception e){
            System.out.println("please enter the details correctly");
        }
    }

    public static void banker() {
        try {
            Scanner k = new Scanner(System.in);
            System.out.println("*********************************************");
            System.out.println("enter your employee ID:");
            String kd = k.next();
            if (map2.containsKey(kd)) {
                System.out.println("enter password:");
                String kb = k.next();
                if (map2.get(kd).getPass().equals(kb)) {
                    System.out.println("banker login succesful");
                    System.out.println("****************************************");
                    int w = 1;
                    do {
                        System.out.println("select from the given options:");
                        System.out.println("****************************************");
                        System.out.println("1.SHOW ALL ACCOUNTS");
                        System.out.println("2.SHOW SPECIFIC ACCOUNT DETAILS");
                        System.out.println("3.TERMINATE ACCOUNT");
                        System.out.println("4.LOGOUT");
                        System.out.println("enter your choice:");
                        int l = k.nextInt();
                        switch (l) {
                            case 1: {
                                System.out.println("you selected tp diplay all accounts");
                                for (Map.Entry<String, User> z : map.entrySet()) {
                                    System.out.println(z.getKey());
                                }
                                break;
                            }
                            case 2: {
                                System.out.println("you selected to display specific account");
                                System.out.println("enter account name to get details:");
                                String uname = k.next();
                                System.out.println("displaying details for " + uname);
                                System.out.println("account name:  " + map.get(uname).getAccName());
                                System.out.println("name:          " + map.get(uname).getName());
                                System.out.println("age:           " + map.get(uname).getAge());
                                System.out.println("address:       " + map.get(uname).getAddress());
                                System.out.println("balance:       " + map.get(uname).getBalance());
                                break;
                            }
                            case 3: {
                                System.out.println("you selected to terminate account");
                                System.out.println("enter account name to delete:");
                                String a = k.next();
                                map.remove(a);

                                break;
                            }
                            case 4:{
                                System.out.println("logging you out");
                                MainMenu();
                                break;
                            }
                            default: {
                                System.out.println("invalid choice");

                            }
                        }
                        System.out.println("do you wish to continue[1-yes/2-no]");
                        int g = k.nextInt();
                        if (g == 2) {
                            w++;
                            System.out.println("logging you out");
                            System.out.println("taking you back to main menu");
                        }

                    } while (w == 1);
                } else {
                    System.out.println("incorrect password");
                }
            }
        }catch(Exception e){
            System.out.println("please enter the details correctly");
        }
    }
    public static void MainMenu(){
       try{
        int k = 1;
        do {
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Welcome to Manohar bank");
                System.out.println("Select options from the tab");
                System.out.println("***************************************");
                System.out.println("1.REGISTER");
                System.out.println("2.USER LOGIN");
                System.out.println("3.CUSTOMER CARE");
                System.out.println("4.BANKER LOGIN");
                System.out.println("5.CLOSE APPLICATION");
                System.out.println("***************************************");
                System.out.println("enter your choice:");
                int n = sc.nextInt();
                switch (n) {
                    case 1: {
                        System.out.println("Welcome to register page");
                        registerUser();
                        break;
                    }
                    case 2: {
                        System.out.println("Welcome to login page");
                        loginUSer();

                        break;
                    }
                    case 3: {
                        System.out.println("Welcome to customer care");
                        System.out.println("call on the following numbers to avail customer care services");
                        System.out.println("+91 7038618205");
                        System.out.println("+91 8830542768");
                        break;
                    }
                    case 4: {
                        System.out.println("Welcome to banker login");
                        banker();
                        break;
                    }
                    case 5:{
                        System.out.println("closing application........");
                        System.exit(0);
                    }
                    default:
                        System.out.println("enter from the choices provided to you");
                }
                System.out.println("do you wish to continue[1-yes/2-no]");
                int g = sc.nextInt();
                if (g == 2) {
                    k++;
                    System.out.println("you opted to close the application");
                    System.exit(0);
                }
            }
        } while (k == 1);
    }catch(Exception e){
        System.out.println("pls enter the details correctly");
    }
}

    }

