/*
Student: David Powell
Course: CIT-239
Date: 2/7/15
Program: Programing Project 1, Days Elapsed
 */
/*
Instructions:
This programming assignment involes writing a Java application which inputs a 
date from the user, and calculates how many days have elapsed from January 1 of 
that year to the date specified. The user enters the date from the console, as 
a string of characters in the format: MM DD YYYY.
*/
package programing.project.pkg1;

//add scanner utility
import java.util.Scanner;

public class ProgramingProject1 {
    
    public static void main(String[] args) {
        //create scanner
        Scanner input = new Scanner(System.in);
        
        //gather input
        System.out.println("This program calculates how many days have passeed\nfrom January 1 to the date specified.\n");
        System.out.print("Enter the specified date in the following format (MM/DD/YYYY): ");
        String date = input.nextLine();
        
        //move date to an array
        String[] dateArray = date.split("/");
        
        //convert string array to int array
        int numArray[] = new int[dateArray.length];
        for (int i = 0; i < dateArray.length; i++)
        {
            try
            {
                numArray[i] = Integer.valueOf(dateArray[i]);
            } catch (NumberFormatException nfe) {};            
        }
                
        //assign values to variables
        int month = numArray[0];
        int day = numArray[1];
        int year = numArray[2];
        
        //check for valid input
        if (month > 0 || month < 13)
        {
            if (year > 0)
            {
                //method to calculate days in each month entered
                boolean leapYear = isLeapYear(year);
                boolean daysCheck = checkDays(day, month, leapYear);
                if (leapYear == true && daysCheck == true)
                {
                    //leapyear true
                    int daysMonth = calcMonthsTrue(month);
                    int daysTotal = calcDaysTrue(daysMonth, day, month);
                    displayStats(daysTotal, month, day, year);
                }
                else if (leapYear == false && daysCheck == true)
                {
                    //leapyear false
                    int daysMonth = calcMonthsFalse(month);
                    int daysTotal = calcDaysFalse(daysMonth, day, month);
                    displayStats(daysTotal, month, day, year);
                }
                else
                {
                    System.out.println("You entered day " + dateArray[1]);
                    System.out.println("Enter a valid day in the correct format.");
                }
            }
            else
            {
                System.out.println("You entered year " + dateArray[2]);
                System.out.println("Enter a valid year in the correct format.");
            }
        }
        else
        {
            System.out.println("You entered month " + dateArray[0]);
            System.out.println("Enter a valid month in the correct format.");
        }
        
        
        //test if it works 
        //System.out.println("The date entered is: ");
        //System.out.println(daysMonth);
        
    }
    //write method
    public static boolean isLeapYear(int year)
    {        
        if (year % 4 == 0) //check if divisable by 4
            {
                if (year % 100 == 0) //check if divisable by 100
                    {
                        if (year % 400 == 0) //check if divisable by 400
                        {   
                            //its a leap year
                            return true;
                        }
                        else
                        {   
                            //its not a leap year
                            return false;
                        }
                    }
                    else
                    {   
                        //its a leap year
                        return true;
                    }
            }
                else
                {   
                    //its not a leap year
                    return false;
                }
    }
    
    public static int calcMonthsTrue(int month)
    {
        int sumDays = 0;
        int daysArray[] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i <= month; i++)
        {
            sumDays = sumDays + daysArray[i];
        }
        return sumDays;
    }
    
    public static int calcMonthsFalse(int month)
    {
        int sumDays = 0;
        int daysArray[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i <= month; i++)
        {
            sumDays = sumDays + daysArray[i];
        }
        return sumDays;
    }
    
    public static boolean checkDays(int day, int month, boolean leapYear)
    {
        if (leapYear == true)
        {
            int daysArray[] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (daysArray[month] >= day)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            int daysArray[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (daysArray[month] >= day)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        
    }
    
    public static int calcDaysTrue(int daysMonth, int day, int month)
    {
        int daysArray[] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int total = daysMonth - (daysArray[month] - day);
        return total;
    }
    
    public static int calcDaysFalse(int daysMonth, int day, int month)
    {
        int daysArray[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int total = daysMonth - (daysArray[month] - day);
        return total;
    }
    
    public static void displayStats(int total, int month, int day, int year)
    {
        System.out.println("The date entered is: ");
        System.out.println(month + "/" + day + "/" + year);
        System.out.println("It's been " + total + " days since January 1st.");
    }
}
