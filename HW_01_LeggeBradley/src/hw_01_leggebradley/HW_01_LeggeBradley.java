/*
 * Bradley Legge
 * 8/26/2019
 * Homework 1 - Student Info
 * This program asks the user to input their name and the courses they are taking.
   The program will then display the users name and courses as well as the amount of
   class they are able to miss in JOption pane window.
 */
package hw_01_leggebradley;
import javax.swing.JOptionPane;

public class HW_01_LeggeBradley 
{
    public static void main(String[] args) 
    {
        String name;        //users name
        String userInput;   //user input
        int courseHours;    //holds how many course hours user is taking
        int daysPerWeek;    //holds how many days user has course
        int weeks;          //holds how many weeks the user takes course
        double daysToMiss;     //holds the days allowed to be missed
        double hours;       //hours allowed to be missed
        String courseName;  //holds name of course        
        int numOfClasses;   //holds amount of class users is taking
        
        //asks user to enter their name and stores it.
        name = JOptionPane.showInputDialog("What is your name? (First Last)");
       
        //asks user how many class they are taking and stores it.
        userInput = JOptionPane.showInputDialog("How many classes are you taking? ");
        numOfClasses = Integer.parseInt(userInput);     //parse string to int
        //while loop to force user to enter a number larger than 0.
        while(numOfClasses < 0)
        {
            userInput = JOptionPane.showInputDialog("Please enter a number greater than 0." +
                                        "\nHow many classes are you taking? ");
            numOfClasses = Integer.parseInt(userInput);     //parse string to int
        }
        
        //for loop to call methods for each class user is taking.
        for(int i = 0; i < numOfClasses; i++)
        {
            courseName = courses(i+1);     //calls courses method
            
                    //ask user how many hours the course meets.
            userInput = JOptionPane.showInputDialog("How many hours does this course meet per day? ");
            courseHours = Integer.parseInt(userInput);  //parse string to int
            //while loop to force user to enter a number larger than 0.
           
            while(courseHours <= 0)
            {
                userInput = JOptionPane.showInputDialog("Please enter a number greater than 0." +
                                            "\nHow many hours does this course meet per day? ");
                courseHours = Integer.parseInt(userInput);  //parse string to int
            }   

            //ask user how many days the course meets.
            userInput = JOptionPane.showInputDialog("How many days does this course meet per week? ");
            daysPerWeek = Integer.parseInt(userInput);  //parse string to int
            //while loop to force user to enter a number larger than 0.
            while(daysPerWeek <= 0)
            {
                //ask user how many days the course meets.
                userInput = JOptionPane.showInputDialog("Please enter a number greater than 0." +
                                            "\nHow many days does this course meet per week? ");
                daysPerWeek = Integer.parseInt(userInput);  //parse string to int
            }

            //ask user how many weeks course takes to complete
            userInput = JOptionPane.showInputDialog("How many weeks does this course meet? ");
            weeks = Integer.parseInt(userInput);    //parse string to int
            //while loop to force user to enter a number larger than 0.
            while(weeks <= 0)
            {
                userInput = JOptionPane.showInputDialog("Please enter a number greater than 0." +
                                            "\nHow many weeks does this course meet? ");
                weeks = Integer.parseInt(userInput);    //parse string to int   
            }

            //calculates the amount of hours allowed to be missed.
            hours = (courseHours * daysPerWeek * weeks) * .20;

            //calculates the amount of days to be missed.
            daysToMiss = hours / courseHours;
           
            //rounds days up to next whole number.
            daysToMiss = Math.ceil(daysToMiss);
            
            //convert the double daysToMiss round up to integer.
            int test = (int)daysToMiss;

                    //displays the input entered from user in JOption Pane.
                    JOptionPane.showMessageDialog(null, "Hello " + name + "." +
                                                    "\n---------------------------------" +
                                                    "\nCourse name: " + courseName +
                                                    "\nCourse weeks: " + weeks +
                                                    "\nHours you can miss: " + hours +
                                                    "\nDays you can miss: " + test); 
            }
    }
    
    public static String courses(int i)
    {
        String courseName;      //holds course name
        
        //asks user to input the course name.
        courseName = JOptionPane.showInputDialog("Course " + i +
                                                "\nWhat is the course name: " +
                                                "\nEx. CSC-150-001 Advanced Java");
        
        //returns the course name to main method.
        return courseName;
    }
}