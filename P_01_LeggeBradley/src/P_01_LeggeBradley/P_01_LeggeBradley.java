/*
 * Bradley Legge
 * 8/26/2019
 * Project 1
 * This program creates a temperature table Celsius to Fahrenheit as well as
 * Fahrenheit to Celsius.  It then asks the user to enter a range of values
 * and displays those values to the user.
*/
package P_01_LeggeBradley;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;

public class P_01_LeggeBradley
{
    // Create a DecimalFormat class to format output.
    public static DecimalFormat fmt = new DecimalFormat("0.0");
    // Create a static string to hold a file name.
    public static String filename;
   
    public static void main(String[] args)
    { 
       String userInput;        //store user input
       int choice;              //store user choice
       boolean exit = false;    //set exit to false.
       
       //display menu until user exits do while loop.
       do
       {
            userInput = JOptionPane.showInputDialog("Welcome to the temperature conversion program" +
                                                   "\nPlease choose from the menu below" +
                                                   "\n1: Fahrenheit to Celsius" +
                                                   "\n2: Celsius to Fahrenheit" +
                                                   "\n3: Fahrenheit range to Celsius" +
                                                   "\n4: Celsius range to Fahrenheit" +
                                                   "\n5: Fahrenheit to Celsius and Celsius to Fahrenheit" +
                                                   "\n6: Exit");
            choice = Integer.parseInt(userInput);
            
            //switch statement to control users choice.
            switch (choice)
            {
                case 1:
                    F2C();
                    break;
                case 2:
                    C2F();
                    break;
                case 3:
                    F2CRange();
                    break;
                case 4:
                    C2FRange();
                    break;
                case 5:
                    Combined();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Not a valid input!");
                    break;
            }
       } while(exit == false);
    }
   
    public static void F2C()
    {
        double fahrenheit;   // The Fahrenheit temperature
        double celsius;      // The Celsius temperature
        
        // Ask user to enter a filename to store info.
        filename = JOptionPane.showInputDialog("Enter a file name you wish to write to");

        // Display the table headings.
        System.out.println("Fahrenheit\tCelsius" +
                         "\n------------------------------");

        // Display the table.
        for (fahrenheit = 32; fahrenheit <= 212; fahrenheit++)
        {
            celsius = (5.0 / 9.0) * (fahrenheit - 32);
            System.out.println(fmt.format(fahrenheit) + 
                         "\t\t" +
                         fmt.format(celsius));
        }
        
        //try catch statement to determine if file exists.
        try
        { 
            //opens file.
            PrintWriter outputFile = new PrintWriter(filename + ".txt");

            // Display the table headings.
            outputFile.println("Fahrenheit\tCelsius\n" +
                               "------------------------------");

            // Display the table.
            for (fahrenheit = 32; fahrenheit <= 212; fahrenheit++)
            {
            celsius = (5.0 / 9.0) * (fahrenheit - 32);
            outputFile.println(fmt.format(fahrenheit) + 
                             "\t\t" +
                             fmt.format(celsius));
            }
            //closes file.
            outputFile.close();
        }
        catch (Exception ex)
        {   
            //displays if the file could not be opened.
            JOptionPane.showMessageDialog(null, "File no found.");
        }
    }
   
    public static void F2CRange()
    {
        double fahrenheit;   // The Fahrenheit temperature
        double celsius;      // The Celsius temperature
        String input;        // Stores user input
        int startVal = 0;        // User starting value
        int endVal = 0;          // User ending value
        boolean exit = false;   //sets exit to false

        // Ask user to enter a filename to store info.
        filename = JOptionPane.showInputDialog("Enter a file name you wish to write to");
        while(!exit)
        {
                input = JOptionPane.showInputDialog("Enter a range of Fahrenheit values " +
                                                "to be converted to Celsius." +
                                                "\nStarting value:");           //TODO user validation
                try
                {
                    startVal = Integer.parseInt(input);

                    input = JOptionPane.showInputDialog("Enter a range of Fahrenheit values " +
                                                "to be converted to Celsius." +
                                                "\nEnding value:");           //TODO user validation
                    try
                    {
                        endVal = Integer.parseInt(input);

                        // Display the table headings.
                        System.out.println("Fahrenheit\tCelsius" +
                                           "\n------------------------------");

                        // Display the table.
                        for (fahrenheit = startVal; fahrenheit <= endVal; fahrenheit++)
                        {
                            celsius = (5.0 / 9.0) * (fahrenheit - 32);
                            System.out.println(fmt.format(fahrenheit) + 
                                                "\t\t" + fmt.format(celsius));
                        }
                        exit = true;
                    }
                    catch(NumberFormatException e)
                    {
                        JOptionPane.showMessageDialog(null, "Invalid Input!");
                    }
                }
                catch(NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(null, "Invalid Input!");
                }
        }

        try
        {
            PrintWriter outputFile = new PrintWriter(filename + ".txt");

            // Display the table headings.
            outputFile.println("Fahrenheit\tCelsius" +
                               "\n------------------------------");

            // Display the table.
            for (fahrenheit = startVal; fahrenheit <= endVal; fahrenheit++)
            {
                celsius = (5.0 / 9.0) * (fahrenheit - 32);
                outputFile.println(fmt.format(fahrenheit) + 
                "\t\t" + fmt.format(celsius));
            }
            outputFile.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "File no found.");
        }
}
   
    public static void C2F()
    {
        double fahrenheit;   // The Fahrenheit temperature
        double celsius;      // The Celsius temperature
        
        // Ask user to enter a filename to store info.
        filename = JOptionPane.showInputDialog("Enter a file name you wish to write to");
        
        // Display the table headings.
        System.out.println("Celsius\t\tFahrenheit" +
                     "\n------------------------------");

        // Display the table.
        for (celsius = 0; celsius <= 100; celsius++)
        {
            fahrenheit = (9.0 / 5.0) * celsius + 32;
            System.out.println(fmt.format(celsius) +
                        "\t\t" + 
                        fmt.format(fahrenheit));
        }

        try
        { 
            //opens file.
            PrintWriter outputFile = new PrintWriter(filename + ".txt");  

            // Display the table headings.
            outputFile.println("Celsius\t\tFahrenheit" +
                         "\n------------------------------");

            // Display the table.
            for (celsius = 0; celsius <= 100; celsius++)
            {
                fahrenheit = (9.0 / 5.0) * celsius + 32;
                outputFile.println(fmt.format(celsius) +
                            "\t\t" + 
                            fmt.format(fahrenheit));
            }
            //closes file.
            outputFile.close();
        }
        catch(Exception ex)
        {   
            //displays if the file could not be opened.
            JOptionPane.showMessageDialog(null, "File no found.");
        }
    }
   
    public static void C2FRange()
    {
        double fahrenheit;   // The Fahrenheit temperature
        double celsius;      // The Celsius temperature
        String input;        // Stores user input
        int startVal = 0;        // User starting value
        int endVal = 0;          // User ending value
        boolean exit = false;

        filename = JOptionPane.showInputDialog("Enter a file name you wish to write to");
        while(!exit)
        {
            input = JOptionPane.showInputDialog("Enter a range of Celsius values " +
                                        "to be converted to Fahrenheit." +
                                        "\nStarting value:");           //TODO user validation
            try
            {
                startVal = Integer.parseInt(input);

                input = JOptionPane.showInputDialog("Enter a range of Celsius values " +
                                          "to be converted to Fahrenheit." +
                                          "\nEnding value:");             //TODO user validation
                try
                {
                    endVal = Integer.parseInt(input);

                    // Display the table headings.
                     System.out.println("Celsius\t\tFahrenheit" +
                                        "\n------------------------------");

                    // Display the table.
                    for (celsius = startVal; celsius <= endVal; celsius++)
                    {
                        fahrenheit = (9.0 / 5.0) * celsius + 32;
                        System.out.println(fmt.format(celsius) +
                        "\t\t" + fmt.format(fahrenheit));
                    }
                    exit = true;
                }
                catch(NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(null, "Invalid Input!");
                }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Invaild Input!");
            }
        }

        try
        {
            PrintWriter outputFile = new PrintWriter(filename + ".txt");

            // Display the table headings.
            outputFile.println("Celsius\t\tFahrenheit" +
                               "\n------------------------------");

            // Display the table.
            for (celsius = startVal; celsius <= endVal; celsius++)
            {
                fahrenheit = (9.0 / 5.0) * celsius + 32;
                outputFile.println(fmt.format(celsius) +
                "\t\t" + fmt.format(fahrenheit));
            }
                outputFile.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "File no found.");
        }
    }   
    
    public static void Combined()
    {
        double fahrenheit;   // The Fahrenheit temperature
        double celsius;      // The Celsius temperature
        
        // Ask user to enter a filename to store info.
        filename = JOptionPane.showInputDialog("Enter a file name you wish to write to");

        // Display the table headings.
        System.out.println("Fahrenheit\tCelsius" +
                         "\n------------------------------");

        // Display the table.
        for (fahrenheit = 32; fahrenheit <= 212; fahrenheit++)
        {
            celsius = (5.0 / 9.0) * (fahrenheit - 32);
            System.out.println(fmt.format(fahrenheit) + 
                         "\t\t" +
                         fmt.format(celsius));
        }
        
        // Display the table headings.
        System.out.println("Celsius\t\tFahrenheit" +
                     "\n------------------------------");

        // Display the table.
        for (celsius = 0; celsius <= 100; celsius++)
        {
            fahrenheit = (9.0 / 5.0) * celsius + 32;
            System.out.println(fmt.format(celsius) +
                        "\t\t" + 
                        fmt.format(fahrenheit));
        }
        
        //try catch statement to determine if file exists.
        try
        { 
            //opens file.
            PrintWriter outputFile = new PrintWriter(filename + ".txt");

            // Display the table headings.
            outputFile.println("Fahrenheit\tCelsius\n" +
                               "------------------------------");

            // Display the table.
            for (fahrenheit = 32; fahrenheit <= 212; fahrenheit++)
            {
            celsius = (5.0 / 9.0) * (fahrenheit - 32);
            outputFile.println(fmt.format(fahrenheit) + 
                             "\t\t" +
                             fmt.format(celsius));
            }
            
            // Display the table headings.
            outputFile.println("Celsius\t\tFahrenheit" +
                         "\n------------------------------");

            // Display the table.
            for (celsius = 0; celsius <= 100; celsius++)
            {
                fahrenheit = (9.0 / 5.0) * celsius + 32;
                outputFile.println(fmt.format(celsius) +
                            "\t\t" + 
                            fmt.format(fahrenheit));
            }
            //closes file.
            outputFile.close();
        }
        catch (Exception ex)
        {   
            //displays if the file could not be opened.
            JOptionPane.showMessageDialog(null, "File no found.");
        }
    }
}
