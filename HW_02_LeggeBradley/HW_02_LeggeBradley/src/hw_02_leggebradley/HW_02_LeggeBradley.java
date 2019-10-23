/*
 * Bradley Legge
 * 9/9/2019
 * Homework 2
 * This program uses a switch statement to call three different methods.  Inside
 * these methods each one uses a do-while, while, and for loops.
 */
package hw_02_leggebradley;
import java.util.Scanner;
public class HW_02_LeggeBradley 
{

    public static void main(String[] args) 
    {
        String choice;             //Holds user input           
        boolean exit = false;   //Sets do while loop exit to false.
        
        //Creates new scanner class.
        Scanner keyboard = new Scanner(System.in);
        
        do      //do while loop to run menu loop until user exits.
        {
            //displays a menu for user to choose from.
            System.out.println("Please choose from the menu below" +
                               "\n1. while loop" +
                               "\n2. do-while loop" + 
                               "\n3. for loop" +
                               "\n4. Exit");
            System.out.print("Enter 1-4: ");
            choice = keyboard.nextLine();
            System.out.println();
            
            //switch statement to jump to methods based on user choice.
            switch(choice)
            {
                case "1":
                    whileLoop();    //method call
                    break;
                case "2":
                    doWhileLoop();  //method call
                    break;
                case "3":
                    forLoop();      //method call   
                    break;
                case "4":
                    exit = true;    //exit loop and terminates program.
                    break;
                default:
                    //if user enters anything other than 1-4 ask to try again.
                    System.out.println("Invalid choice!");
                            
            }
        } while(exit == false); 
    }
    
    public static void whileLoop()
    {
        String choice;      //holds user choice of yes/no
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Do you wish to enter the while loop (yes/no)? > ");
        choice = keyboard.nextLine().toLowerCase();
        
        //while loop runs as long as user enters yes.
        while (choice.equals("yes"))
        {
            System.out.println("Hello from inside the while loop.");
            System.out.print("Do you wish to stay in the while loop (yes/no)? > ");
            choice = keyboard.nextLine().toLowerCase();
        }
        
        //tells user they are outside of while loop.
        System.out.println("You are outside the while loop!");
        System.out.println("");
    }
    
    public static void doWhileLoop()
    {
        String choice;      //holds user input
        
        Scanner keyboard = new Scanner(System.in);
        
        //do-while runs as long as user enters yes.
        do
        {
            System.out.println("Hello from inside the do while loop.");
            System.out.print("Do you wish to stay inside this loop (yes/no) > ");
            choice = keyboard.nextLine().toLowerCase();
        }while(choice.equals("yes"));
        
        //tells user they are outside of while loop.
        System.out.println("You are outside the do-while loop!");
        System.out.println("");
    }
    
    public static void forLoop()
    {
        //get user input.
        int loopAmount;
        
        Scanner keyboard = new Scanner(System.in);
        
        //ask user how many times for loop will run
        System.out.print("How many times do you wish to run through this loop? > ");
        loopAmount = keyboard.nextInt();
        
        //print how many times the loop will run.
        System.out.println("This loop will run " + loopAmount + " times.");
        
        for(int i = 1; i <= loopAmount; i ++)
        {
            System.out.println("Hello from inside the for loop.");
        }
        
        //tells user they are outside of while loop.
        System.out.println("You are outside the for loop!");
        System.out.println("");
    }
}
