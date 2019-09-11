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
        String userInput;
        int choice;
        boolean exit = false;
        
        Scanner keyboard = new Scanner(System.in);
        
        do 
        {
            System.out.println("Please choose from the menu below" +
                               "\n1. while loop" +
                               "\n2. do-while loop" + 
                               "\n3. for loop" +
                               "\n4. Exit");
            System.out.print("Enter 1-4: ");
            choice = keyboard.nextInt();
            
            switch(choice)
            {
                case 1:
                    whileLoop();
                    break;
                case 2:
                    doWhileLoop();
                    break;
                case 3:
                    forLoop();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.print("Invalid choice! Please enter 1-4!");
                    choice = keyboard.nextInt();
                            
            }
        } while(exit == false); 
    }
    
    public static void whileLoop()
    {
        int choice = 1;
        
        Scanner keyboard = new Scanner(System.in);
        
        while (choice == 1)
        {
            System.out.println("Hello from inside the while loop.");
            System.out.println("Press 1 to stay inside this loop.");
            choice = keyboard.nextInt();
        }
        
    }
    
    public static void doWhileLoop()
    {
        int choice = 1;
        
        Scanner keyboard = new Scanner(System.in);
        
        do
        {
            System.out.println("Hello from inside the do while loop.");
            System.out.println("Press 1 to stay inside this loop.");
            choice = keyboard.nextInt();
        }while(choice == 1);
    }
    
    public static void forLoop()
    {
        for(int i = 0; i <= 5; i ++)
        {
            System.out.println("Hello from inside the for loop.");
            System.out.println("This loop will run 5 times.");
        }
    }
    
}
