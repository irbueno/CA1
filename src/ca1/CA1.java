package ca1;

//@author IBueno
//GitHub repository: https://github.com/irbueno/CA1
//Note: Since I was unable to fully write a code with file reading/writing 
//I decided to write the below as a manually input program via scanner
//Note 2: The many scanners are due to errors in the input loop

//Adding scanner for data input
import java.util.Scanner;

public class CA1 {

    public static void main(String[] args)
    {
        //Adding scanners for data input
        Scanner name = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        Scanner loop = new Scanner(System.in);
        String next;
        
        do{        
            try{
                //Asking for customer name input
                System.out.print("Enter name: ");
                String customerName = customerNameCheck(name);
            
                //Asking for customer total purchase input
                System.out.print("Enter total purchase: ");
                double customerTotalPurchase = customerTotalPurchaseCheck(scan);

                //Asking for customer class input
                System.out.print("Enter class: ");
                int customerClass = customerClassCheck(scan); 

                //Asking for customer last purchase year input
                System.out.print("Enter last purchase year: ");
                int customerLastPurchaseYear = customerLastPurchaseYearCheck(scan);
                
                //Calculating discount
                double customerFinalValue = customerDiscountCalculator(customerTotalPurchase,customerClass,customerLastPurchaseYear);
                
                //Return names & final value
                System.out.println("\nName: " +customerName +"\nFinal Value: " +customerFinalValue);
            }
            catch(java.util.InputMismatchException e){
                System.out.print("\nError: Please enter numbers only");
            }
            //Ask for another data entry or end program
            System.out.print("\nCalculate another entry?(Y/N): ");
            next = loop.nextLine();
            System.out.println(" ");
        
        }while(!next.equals("n"));            
    }
    
    //Filter valid customer name input (unfinished method)
    public static String customerNameCheck(Scanner name)
    {
        String customerName = name.nextLine();
        while(customerName == null)
        {
            System.out.println("!Invalid name! First name must be letters only");
            System.out.print("Enter name: ");
            customerName = name.nextLine();
        }
        return customerName;
    }    
    
    //Filter valid customer total purchase input
    public static double customerTotalPurchaseCheck(Scanner scan)
    {
        double customerTotalPurchase = scan.nextDouble();
        while(customerTotalPurchase < 1)
        {
            System.out.println("!Invalid amount! Purchase must be a positive amount");
            System.out.print("Enter total purchase: ");
            customerTotalPurchase = scan.nextDouble(); 
        }
        return customerTotalPurchase;
    }  
    
    //Filter valid customer class input
    public static int customerClassCheck(Scanner scan)
    {
        int customerClass = scan.nextInt();
        while(customerClass != 1)
        {    
            switch(customerClass)
            {
                case 2: return customerClass;
                case 3: return customerClass;
                default:
                    System.out.println("!Invalid class! Class must be either 1, 2 or 3");
            }
            System.out.print("Enter class: ");
            customerClass = scan.nextInt();
        }
        return customerClass;
    }

    //Filter valid customer last purchase year input
    public static int customerLastPurchaseYearCheck(Scanner scan)
    {
        int customerLastPurchaseYear = scan.nextInt();
        while(customerLastPurchaseYear > 2024)
        {
            System.out.println("!Invalid year! Year must be current year or earlier");
            System.out.print("Enter last purchase year: ");
            customerLastPurchaseYear = scan.nextInt();
        }
        return customerLastPurchaseYear;
    }

    //Calculate discount
    public static double customerDiscountCalculator(double customerTotalPurchase,int customerClass,int customerLastPurchaseYear)
    {    
        double customerFinalValue;
        switch(customerClass)
        {
            case 1: 
                  //Class 1 - 30% discount
                if(customerLastPurchaseYear == 2024)
                {
                    customerFinalValue = customerTotalPurchase*0.7;
                    return customerFinalValue;
                } //Class 1 - 20% discount
                else if(customerLastPurchaseYear < 2024 && customerLastPurchaseYear > 2018)
                {
                    customerFinalValue = customerTotalPurchase*0.8;
                    return customerFinalValue;
                } //Class 1 - 10% discount
                else if (customerLastPurchaseYear < 2024-5)
                {
                    customerFinalValue = customerTotalPurchase*0.9;
                    return customerFinalValue;
                }
            case 2:
                  //Class 2 - 15% discount
                if(customerLastPurchaseYear == 2024)
                {
                    customerFinalValue = customerTotalPurchase*0.85;
                    return customerFinalValue;
                } //Class 2 - 13% discount
                else if(customerLastPurchaseYear < 2024 && customerLastPurchaseYear > 2018)
                {
                    customerFinalValue = customerTotalPurchase*0.87;
                    return customerFinalValue;
                } //Class 2 - 5% discount
                else if (customerLastPurchaseYear < 2024-5)
                {
                    customerFinalValue = customerTotalPurchase*0.95;
                    return customerFinalValue;
                }
            case 3:
                  //Class 3 - 3% discount
                if(customerLastPurchaseYear == 2024)
                {
                    customerFinalValue = customerTotalPurchase*0.97;
                    return customerFinalValue;
                } //Class 3 - 0% discount
            default:
                    customerFinalValue = customerTotalPurchase;
                    return customerFinalValue;
        }
    }
}
