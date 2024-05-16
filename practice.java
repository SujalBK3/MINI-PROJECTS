import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ATM
{
    float amount;
    Scanner sc = new Scanner(System.in);
    
    public float checkBalance(float checkBalance)
    {
        System.out.print("THE BALANCE IN THE BANK ACCOUNT : ");
        return checkBalance;
    }

    public float deposit(int no, float deposit, List<Account> account)
    {
        account.get(no - 1).balance = account.get(no - 1).balance + deposit;
        System.out.print("THE BALANCE IN THE BANK ACCOUNT : ");
        return account.get(no - 1).balance;
    }

    public void withdraw(int no , List <Account> account, List <Account> transaction)
    {
        while(true)
        {
            System.out.print("ENTER AMOUNT TO BE WITHDRAWN : ");
            float withdraw = sc.nextFloat();
            sc.nextLine();
            if(withdraw < 0 || withdraw > account.get(no - 1).balance)
            {
                System.out.println("INVALID AMOUNT ENTERED. ENTER A VALID AMOUNT.");
            }
            else
            {
                account.get(no - 1).balance = account.get(no - 1).balance - withdraw;
                transaction.add(new Account("ACCOUNT" + no, "nil", "WITHDRAW", account.get(no - 1).balance, withdraw));
                System.out.println("THE BALANCE IN THE ACCOUNT : " + account.get(no - 1).balance);
                break;
            }
        }
    }



    public void transfer(int no, int no1, List<Account> account, List<Account> transaction)
    {
        while(true)
        {
            System.out.print("ENTER AMOUNT TO BE TRANSFERRED : ");
            amount = sc.nextFloat();
            sc.nextLine();
            if(amount < 0 || amount > account.get(no - 1).balance)
            {
                    System.out.println("INVALID AMOUNT ENTERED. ENTER A VALID AMOUNT.");
            }
            else
            {
                break;
            }
        }
        account.get(no - 1).balance = account.get(no - 1).balance - amount;
        account.get(no1 - 1).balance = account.get(no1 - 1).balance + amount;
        transaction.add(new Account("ACCOUNT" + no, "ACCOUNT" + no1, "TRANSFER",account.get(no - 1).balance , amount));
        System.out.println("THE BALANCE IN ACCOUNT" + no + " : " + account.get(no - 1).balance );
        // System.out.println("THE BALANCE IN ACCOUNT" + no1 + " : " + account.get(no1 - 1).balance);

    }

    public void update(int no, List<Account> account)
    {
        while(true)
        {
            System.out.println(" PRESS 1 FOR NAME \n PRESS 2 FOR AGE \n PRESS 3 FOR EMAIL-ID \n PRESS 4 FOR PIN \n PRESS 5 FOR EXIT ");
            System.out.print("OPTION : ");
            int option = sc.nextInt();
            sc.nextLine();
            if(option == 1)
            {
                System.out.println("CURRENT NAME : " + account.get(no - 1).name);
                System.out.print("ENTER NEW NAME : ");
                String name = sc.nextLine();
                account.get(no - 1).name = name;
                System.out.println("NEW NAME UPDATED.");
            }

            else if(option == 2)
            {
                while(true)
                {
                    System.out.println("CURRENT AGE : " + account.get(no - 1).age);
                    System.out.print("ENTER NEW AGE : ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    if(age < 0)
                    {
                        System.out.println("INVALID AGE ENTERED. ENTER A VALID AGE.");
                    }
                    else
                    {
                        account.get(no - 1).age = age;
                        System.out.println("NEW AGE UPDATED.");
                        break;
                    }
                }
            }

            else if(option == 3)
            {
                System.out.println("CURRENT EMAIL-ID : " + account.get(no - 1).emailID);
                System.out.print("ENTER NEW EMAIL-ID : ");
                String emailID = sc.nextLine();
                account.get(no - 1).emailID = emailID;
                System.out.println("NEW EMAIL-ID UPDATED.");
            }

            else if(option == 4)
            {
                while(true)
                {
                    System.out.print("ENTER ACCOUNT PIN : ");
                    int pin = sc.nextInt();
                    sc.nextLine();
                    if(pin == account.get(no - 1).pin)
                    {
                        while(true)
                        {
                            System.out.print("ENTER NEW PIN : ");
                            int pin1 = Integer.parseInt(sc.nextLine());
                            if(pin1 == pin)
                            {
                                System.out.println("NEW PIN CANNOT BE SAME AS THE PREVIOUS PIN.");
                            }
                            else
                            {
                                account.get(no - 1).pin = pin1;
                                System.out.println("NEW PIN UPDATED.");
                                break;
                            }
                        }
                        break;
                    }
                    else
                    {
                        System.out.println("INCORRECT ACCOUNT PIN. ENTER CORRECT PIN.");
                    }
                }
            }

            else if(option == 5)
            {
                break;
            }

            else
            {
                System.out.println("INVALID OPTION SELECTED. SELECT A VALID OPTION.");
            }
        }


    }

    public void exit()
    {
        System.out.println("YOU ARE BEING EXITED.");
    }
}

class Account
{
    String name;
    int age;
    int pin;
    String emailID;
    float balance;
    float amount;
    String account1;
    String account2;
    String type;


    List<Account> account = new ArrayList<>();
    List<Integer> accName = new ArrayList<>();
    List<Account> transaction = new ArrayList<>();

    public Account(String name, int age, int pin, String emailID, float balance)
    {
        this.name = name;
        this.age = age;
        this.pin = pin;
        this.emailID = emailID;
        this.balance = balance;
    }

    public Account(String account1, String account2, String type, float balance, float amount)
    {
        this.account1 = account1;
        this.account2 = account2;
        this.type = type;
        this.balance = balance;
        this.amount = amount;
    }

    public String toString()
    {
        return "NAME = " + name + "\n AGE = " + age + "\n EMAIL-ID = " + emailID + "\n BALANCE = " + balance;
    }
    public void accName(int i)
    {
        accName.add(i);
    }

    public static void main(String arg[])
    {
        String name = null;
        int age = 0;
        int pin = 0;
        int i = 1;
        int no = 0;
        int no1 = 0;
        String emailID = null;
        float balance = 0;
        float deposit = 0;
        int option = 0;
        int option1 = 0;
        boolean value = true;
        ATM atm = new ATM();

        Account acc = new Account(name, age, pin, emailID, balance);

        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.print(" PRESS 1 FOR CREATING AN ACCOUNT \n PRESS 2 FOR SELECTING AN ACCOUNT \n ");
            System.out.print("OPTION : ");
            option = sc.nextInt();
            sc.nextLine();
            if(option == 1)
            {
                System.out.print("ENTER NAME : ");
                name =  sc.nextLine();
                while(true)
                {
                    System.out.print("ENTER AGE : ");
                    age = sc.nextInt();
                    // sc.nextLine();
                    if(age < 0)
                    {
                        System.out.println("INVALID AGE ENTERED. PLEASE ENTER A VALID AGE.");
                    }
                    else
                    {
                        break;
                    }
                }
                sc.nextLine();
                System.out.print("ENTER ACCOUNT PIN : ");
                pin = Integer.parseInt( sc.nextLine());
                System.out.print("ENTER EMAIL-ID : ");
                emailID = sc.nextLine();
                while(true)
                {
                    System.out.print("DEPOSIT MONEY : ");
                    balance = sc.nextFloat();
                    sc.nextLine();
                    if(balance < 0)
                    {
                        System.out.print("INVALID AMOUNT ENTERED. ENTER A VALID MONEY.");
                    }
                    else
                    {
                        break;
                    }
                }
            
                acc.account.add(new Account(name, age, pin, emailID, balance));
                acc.accName(i);
                i++;

                // break;
            }
            else if (option == 2)
            {
                if(acc.accName.size() != 0)
                {
                    while(true)
                    {
                        System.out.print("ENTER ACCOUNT NO (FORMAT : 1, 2...) : ");
                        no = sc.nextInt();
                        sc.nextLine();
                        if(no > 0)
                        { 
                            if(!acc.accName.contains(no))
                            {
                                System.out.println("ACCOUNT DOES NOT EXIST.");
                            }
                            else
                            {
                                break;
                            }
                        } 
                        else
                        {
                            System.out.print("ACCOUNT DOES NOT EXIST.");
                        }  
                    }
                }
                else
                {
                    System.out.println("NO ACCOUNT EXISTS. CREATE AN ACCOUNT FIRST.");
                    continue;
                }
                break;
                
            }
            else
            {
                System.out.println("INVALID OPTION SELECTED. PLEASE SELECT A VALID OPTION.");
                
            }
        }

        while(true)
        {
            if(value == true)
            {
                System.out.print("ENTER ACCOUNT PIN : ");
                int accPin = sc.nextInt();
                sc.nextLine();
                if(accPin == acc.account.get(no - 1).pin)
                {
                    while(true)
                    {
                        System.out.println(" PRESS 1 FOR CHECKING BALANCE \n PRESS 2 FOR DEPOSITING MONEY \n PRESS 3 FOR WITHDRAWING MONEY \n PRESS 4 FOR TRANSFERRING MONEY \n PRESS 5 FOR CHECKING ACCOUNT DETAILS \n PRESS 6 FOR UPDATING ACCOUNT DETAILS \n PRESS 7 FOR CHECKING TRANSACTION HISTORY \n PRESS 8 FOR SWITCHING ACCOUNT \n PRESS 9 FOR EXIT ");
                        System.out.print("OPTION : ");
                        option1 = sc.nextInt();
                        sc.nextLine();
                        if(option1 == 1)
                        {
                            System.out.println(atm.checkBalance(acc.account.get(no - 1).balance));

                        }

                        else if(option1 == 2)
                        {
                            while(true)
                            {
                                System.out.print("ENTER THE AMOUNT TO BE DEPOSITED : ");
                                deposit = sc.nextFloat();
                                sc.nextLine();
                                if(deposit < 0)
                                {
                                    System.out.println("INVALID AMOUNT ENTERED. ENTER A VALID AMOUNT.");
                                }
                                else
                                {
                                    break;
                                }
                            }
                            System.out.println(atm.deposit(no, deposit, acc.account));
                            acc.transaction.add(new Account("ACCOUNT" + no , "nil" , "DEPOSIT", acc.account.get(no - 1).balance, deposit ));
                        }

                        else if(option1 == 3)
                        {
                            atm.withdraw(no, acc.account, acc.transaction);
                        }

                        else if(option1 == 4)
                        {
                            while(true)
                            {
                                System.out.print("TRANSFER MONEY TO THIS ACCOUNT : ");
                                no1 = sc.nextInt();
                                sc.nextLine();
                                if(no1 != no)
                                {
                                    if(no1 > 0)
                                    {
                                        if(!acc.accName.contains(no1))
                                        {
                                            System.out.println("ACCOUNT DOES NOT EXIST.");
                                        }
                                        else
                                        {
                                            
                                            break;
                                        }
                                    }
                                    else
                                    {
                                    System.out.println("ACCOUNT DOES NOT EXIST."); 
                                    }
                                }
                                else
                                {
                                    System.out.println("CANNOT SELECT SAME ACCOUNT FOR TRANSFERRING MONEY.");
                                }
                            }
                            atm.transfer(no, no1, acc.account , acc.transaction);
                            
                        }

                        else if(option1 == 5)
                        {
                           System.out.println("NAME : " + acc.account.get(no - 1).name);
                           System.out.println("AGE : " + acc.account.get(no - 1).age);
                           System.out.println("EMAIL-ID : " + acc.account.get(no - 1).emailID);
                        }

                        else if(option1 == 6)
                        {
                            atm.update(no, acc.account);
                        }

                        else if(option1 == 7)
                        {
                            if(acc.transaction.size() == 0)
                            {
                                   System.out.println("NO TRANSACTION HISTORY AVAILABALE.");
                            }
                            else
                            {
                                for(int j = acc.transaction.size() - 1; j >= 0; j--)
                                {
                                    if(acc.transaction.get(j).type.equals("TRANSFER") && (acc.transaction.get(j).account1.equals("ACCOUNT" + no) || acc.transaction.get(j).account2.equals("ACCOUNT" + no)) )
                                    {
                                        System.out.println("TRANSACTION TYPE : " + acc.transaction.get(j).type + ", ACCOUNT FROM WHICH MONEY IS TRANSFERRED : " + acc.transaction.get(j).account1 + 
                                        ", ACCOUNT TO WHICH MONEY IS TRANSFERRED : " + acc.transaction.get(j).account2 
                                          + ", AMOUNT TRANSFERRED : " + acc.transaction.get(j).amount + ", AVAILABLE BALANCE : " + acc.transaction.get(j).balance);
                                    }
                                    else if(acc.transaction.get(j).type.equals("DEPOSIT") && acc.transaction.get(j).account1.equals("ACCOUNT" + no))
                                    {
                                        System.out.println("TRANSACTION TYPE : " + acc.transaction.get(j).type + ", ACCOUNT TO WHICH MONEY IS DEPOSITED : " + acc.transaction.get(j).account1 + ", AMOUNT DEPOSITED : " + acc.transaction.get(j).amount + ", AVAILABLE BALANCE : " + acc.transaction.get(j).balance );
                                    }
                                    else if(acc.transaction.get(j).type.equals("WITHDRAW") && acc.transaction.get(j).account1.equals("ACCOUNT" + no))
                                    {
                                        System.out.println("TRANSACTION TYPE : " + acc.transaction.get(j).type + ", ACCOUNT FROM WHICH MONEY IS WITHDRAWN : " + acc.transaction.get(j).account1 + ", AMOUNT WITHDRAWN : " + acc.transaction.get(j).amount + ", AVAILABLE BALANCE : " + acc.transaction.get(j).balance);
                                    }
                                    else if(j == 0)
                                    {
                                        System.out.println("NO TRANSACTION HISTORY AVAILABLE.");
                                    }
                                    
                                }
                            }
                        
                        }

                        else if(option1 == 8)
                        {
                            while(true)
                            {
                                System.out.print("ENTER ACCOUNT NO (FORMAT : 1, 2...) : ");
                                no = sc.nextInt();
                                sc.nextLine();
                                if(no > 0)
                                { 
                                    if(!acc.accName.contains(no))
                                    {
                                        System.out.println("ACCOUNT DOES NOT EXIST.");
                                    }
                                    else
                                    {
                                        break;
                                    }
                                } 
                                else
                                {
                                    System.out.println("ACCOUNT DOES NOT EXIST.");
                                }
                                
                            }
                            break;

                        }

                    else if (option1 == 9)
                    {
                        atm.exit();
                        value = false;
                        break;
                    }

                    else
                    {
                        System.out.println("INVALID OPTION SELECTED. SELECT A VALID OPTION.");
                    }
                }

            }
            else
            {
                System.out.println("INCORRECT ACCOUNT PIN. ENTER CORRECT ACCOUNT PIN.");
            }
            }
            else if(value == false)
            {
                break;
            }
           
        }
    }

}

