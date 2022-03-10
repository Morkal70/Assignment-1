package poolcalculatorusethisone;

import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author M1001886
 */
public class PoolCalculatorUseTHISONE {

    private static final double PI = 3.14; //PI in all caps to make it a "constant".
    private static double length, width, radius,
            shallowDepth, deepDepth,
            internalSurfaceArea, volume,
            hypotenuse, averageDepth,
            deepSurface, shallowSurface,
            sideSurface, bottomSurface, hypDepth; //All numerical variables declared as "double" to accomodate decimal places.
    
    private static String username;
    private static int menuOption = -1; //Menu doesn't work without this declared as -1
    private static Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
       displayMenu();
       rectangleInternalSurfaceArea();
       rectangleVolume();
       circleInternalSurfaceArea();
       circleVolume();
    }

    private static void displayMenu() {
        if (username == null){
            getName();
        }
        System.out.println("Welcome to the Pool Volume Calculator!\n");// "/n" creates new line 
        //getName();
        while (menuOption != 0) {
            System.out.println("Select an option\n"
                    + "1. Re-enter name\n"
                    + "2. Rectangular pool\n"
                    + "3. Circular pool\n"
                    + "0. Exit"); // + signs concatenate strings

            menuOption = SC.nextInt();

            if (menuOption == 1) {
                SC.nextLine();
                getName();
                //break;
            } else if (menuOption == 2) {
                rectangleInternalSurfaceArea();
                rectangleVolume();
                break;
            } else if (menuOption == 3) {
                circleInternalSurfaceArea();
                circleVolume();
                break;
            } else if (menuOption == 0) {
                System.exit(0);
            } else {
                System.out.println("Please select option 1, 2 or 3 to proceed, or 0 to exit");
            }// end of IF statement
        }//end of while loop

        //display menu
    }

    private static void getName() {
        System.out.println("Please enter your name");
        username = SC.nextLine();
        System.out.println("Your username: " + username);
        //add validation later to check correct input

    }

    private static void rectangleInternalSurfaceArea() { 
        System.out.println("Please enter the length in metres");
        length = SC.nextDouble();
        System.out.println("Please enter the width in metres");
        width = SC.nextDouble();
        System.out.println("Please enter the shallow depth in metres");
        shallowDepth = SC.nextDouble();
        System.out.println("Please enter the deep depth in metres");
        deepDepth = SC.nextDouble();
        
        if(shallowDepth == deepDepth){
            averageDepth = shallowDepth; 
        } else if (shallowDepth != deepDepth) {
            averageDepth = (shallowDepth + deepDepth) / 2;
        } else {
            System.out.println("Something's wrong");
        }       
        
        hypDepth = deepDepth - shallowDepth;
        hypotenuse = Math.sqrt((Math.pow(length, 2)) + (Math.pow(hypDepth, 2)));
        //System.out.println("TEST 1: this is the value of hypot" + hypotenuse);
        
        shallowSurface = shallowDepth * width;
        deepSurface = deepDepth * width;
        sideSurface = averageDepth * length;
        bottomSurface = width * hypotenuse;
        internalSurfaceArea = shallowSurface + deepSurface + (sideSurface * 2) + bottomSurface;
        //System.out.println("The internal surface area of your rectangular pool is: " + internalSurfaceArea + "m²");
    }

    private static void rectangleVolume() {
//        System.out.println("Please enter the length in metres"); removed these lines so the user doens't need to input twice
//        length = SC.nextDouble();
//        System.out.println("Please enter the width in metres");
//        width = SC.nextDouble();
//        System.out.println("Please enter the shallow depth in metres");
//        shallowDepth = SC.nextDouble();
//        System.out.println("Please enter the deep depth in metres");
//        deepDepth = SC.nextDouble();
//        averageDepth = (shallowDepth + deepDepth) / 2;
        volume = averageDepth * length * width;
        //System.out.println("The volume of your rectangular pool is: " + volume + " litres\n");
        printOutput();
        restartMenu();
    }

    private static void circleInternalSurfaceArea() {
        System.out.println("Please enter the radius in metres");
        radius = SC.nextDouble();
        System.out.println("Please enter the shallow depth in metres");
        shallowDepth = SC.nextDouble();
        System.out.println("Please enter the deep depth in metres");
        deepDepth = SC.nextDouble();
        
         if(shallowDepth == deepDepth){
            averageDepth = shallowDepth; 
        } else if (shallowDepth != deepDepth) {
            averageDepth = (shallowDepth + deepDepth) / 2;
        } else {
            System.out.println("Something's wrong");
        }       
        bottomSurface = PI * (Math.pow(radius, 2));
        sideSurface = 2 * PI * radius * averageDepth;
        internalSurfaceArea = bottomSurface + sideSurface;
        //System.out.println("The internal surface area of your circular pool is: " + internalSurfaceArea + " m²");
        //System.out.println("TEST 1: this is the value of circle area" + bottomSurface); 
        
        
    }

    private static void circleVolume() {
        volume = bottomSurface * averageDepth;
        //System.out.println("The volume of your circular pool is: " + volume + "litres\n");
        printOutput();
        restartMenu();
    }

    private static void printOutput() {
//        printFiller();
        System.out.println ("----------------------------------------------------------\n"
                + "Username: " + username + "\n"
                + "Pool internal surface area: " + internalSurfaceArea + " m²\n"
                + "Pool volume: " + volume  + " litres \n"
                + "Thank you for using the Pool Volume Calculator!\n"
                + "----------------------------------------------------------\n"
        );

    }
    private static void restartMenu() {
        System.out.println("Would you like to return to the main menu?\n");
        while (menuOption != -1) {
            System.out.println("Select an option\n"
                    + "1. Main menu\n"
                    + "0. Exit");

            menuOption = SC.nextInt();

            if (menuOption == 1) {
                displayMenu();}
            else if (menuOption == 0) {
                System.exit(0); }
            else {
                System.out.println("Please select option 1 to return to the main menu, or 0 to exit");
            }// end of IF statement
        }//end of while loop
    }
}
