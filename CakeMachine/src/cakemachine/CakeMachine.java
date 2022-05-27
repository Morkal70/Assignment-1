/**Author: Matthew Toon - M1001886*/
package cakemachine;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;


public class CakeMachine {
    private static int menuOption = -1;
    private static String username, cakeToDelete, orderToDelete;
    private static ArrayList<String> recipeList = new ArrayList<String>();
    private static ArrayList<String> orderList = new ArrayList<String>();
    private static ArrayList<String> oldOrders = new ArrayList<String>();
    private static ArrayList<String> ordersDue = new ArrayList<String>();
    private static Scanner SC = new Scanner(System.in);
    private static Scanner recipeSC = new Scanner(System.in);
    private static Scanner deleteSC = new Scanner(System.in);
    private static Scanner orderSC = new Scanner(System.in);
    private static Scanner deleteOrderSC = new Scanner(System.in);

    public static void main(String[] args) {
        recipeTestData(); //Populates recipeList for testing.
        orderTestData(); //Populates oldOrders, and ordersDue for testing.
        mainMenu(); //Calls getName() to store username, then displays a looping menu.
    }
    private static void mainMenu() {
        if (username == null) {
            getName();
        }
        System.out.println("Welcome to Mclovin's Muffins, " + username + "!");
        while (menuOption != 0) {//The loop will only repeat if the selects a number that isn't 0.
            System.out.println("Select an option\n"
                    + "1. Add recipe \n"
                    + "2. Delete recipe\n"
                    + "3. Add order\n"
                    + "4. Delete order\n"
                    + "5. View old orders\n"
                    + "6. View orders due\n"
                    + "7. View current ingredients required\n"
                    + "0. Exit");

            menuOption = SC.nextInt();
            if (menuOption == 1) {//User navigates menu with numerical keys: numbers 1 through 7 call methods and...
                addRecipe();      //... 0 exits the program.
            } else if (menuOption == 2) {
               deleteRecipe();
            } else if (menuOption == 3) {
                addOrder();
            } else if (menuOption == 4) {
                deleteOrder();
            } else if (menuOption == 5) {
                printOldOrders();
            } else if (menuOption == 6) {
                printOrdersDue();
            } else if (menuOption == 7) {
                totalIngredients();
            } else if (menuOption == 0) {
                System.exit(0);
            } else {
                System.out.println("Please select an option from 1 through 7 to proceed, or 0 to exit");//User error message
            }//End of if statement.
        }//End of while loop.

    }//mainMenu()

    private static void recipeTestData() {// populates recipeList for testing
        recipeList.add("Vanilla");
        recipeList.add("125g butter, 125g caster sugar, 125g self raising flour, 1tsp baking powder, 2 eggs, 1tsp vanilla essence");
        recipeList.add("1. Preheat oven to 180C | 2. Mix ingredients in a large bowl | 3. Empty bowl into baking tin | 4. Cook for 30 minutes");
        recipeList.add("Chocolate");
        recipeList.add("100g cocoa powder, 125g butter, 125g caster sugar, 125g self raising flour, 1tsp baking powder, 2 eggs, 1tsp vanilla essence");
        recipeList.add("1. Preheat oven to 180C | 2. Mix ingredients in a large bowl | 3. Empty bowl into baking tin | 4. Cook for 30 minutes");
        recipeList.add("Red Velvet");
        recipeList.add("2tsp red food colouring, 100g cocoa powder, 125g butter, 125g caster sugar, 125g self raising flour, 1tsp baking powder, 2 eggs, 1tsp vanilla essence");
        recipeList.add("1. Preheat oven to 180C | 2. Mix ingredients in a large bowl | 3. Empty bowl into baking tin | 4. Cook for 30 minutes");
        recipeList.add("Bruce");
        recipeList.add("super special ingredient, 100g cocoa powder, 125g butter, 125g caster sugar, 125g self raising flour, 1tsp baking powder, 2 eggs, 1tsp vanilla essence");
        recipeList.add("1. Preheat oven to 180C | 2. Mix ingredients in a large bowl | 3. Empty bowl into baking tin | 4. Cook for 30 minutes");
        recipeList.add("Best Cake Ever");
        recipeList.add("classified, classified, classified, classified, classified");
        recipeList.add("1. Preheat oven to 180C | 2. Mix ingredients in a large bowl | 3. Empty bowl into baking tin | 4. Cook for 30 minutes");
    }
    
    private static void orderTestData() {// populates ordersDue for testing
        ordersDue.add("Duncan");
        ordersDue.add("contact details");
        ordersDue.add("delivery address");
        ordersDue.add("2023-05-27"); //order date
        ordersDue.add("2023-05-30"); //delivery date
        ordersDue.add("Vanilla");
        ordersDue.add("large");
        ordersDue.add("heart");
        ordersDue.add("Duncan2");
        ordersDue.add("contact details");
        ordersDue.add("delivery address");
        ordersDue.add("2023-05-27"); //order date
        ordersDue.add("2023-05-30"); //delivery date
        ordersDue.add("Chocolate");
        ordersDue.add("large");
        ordersDue.add("heart");
        ordersDue.add("Duncan3");
        ordersDue.add("contact details");
        ordersDue.add("delivery address");
        ordersDue.add("2023-05-21"); //order date
        ordersDue.add("2023-05-24"); //delivery date
        ordersDue.add("Red Velvet");
        ordersDue.add("large");
        ordersDue.add("heart");
        ordersDue.add("Duncan4");
        ordersDue.add("contact details");
        ordersDue.add("delivery address");
        ordersDue.add("2023-05-21"); //order date
        ordersDue.add("2023-05-24"); //delivery date
        ordersDue.add("Bruce");
        ordersDue.add("large");
        ordersDue.add("heart");
        ordersDue.add("Duncan5");
        ordersDue.add("contact details");
        ordersDue.add("delivery address");
        ordersDue.add("2023-05-21"); //order date
        ordersDue.add("2023-05-24"); //delivery date
        ordersDue.add("Best Cake Ever");
        ordersDue.add("large");
        ordersDue.add("heart");
        ordersDue.add("Duncan6");
        ordersDue.add("contact details");
        ordersDue.add("delivery address");
        ordersDue.add("2023-05-21"); //order date
        ordersDue.add("2023-05-24"); //delivery date
        ordersDue.add("Vanilla");
        ordersDue.add("large");
        ordersDue.add("heart");
        
        oldOrders.add("Cher1");
        oldOrders.add("contact details");
        oldOrders.add("delivery address");
        oldOrders.add("2022-05-12"); //order date
        oldOrders.add("2022-05-15"); //delivery date
        oldOrders.add("Vanilla");
        oldOrders.add("large");
        oldOrders.add("heart");
        oldOrders.add("Cher2");
        oldOrders.add("contact details");
        oldOrders.add("delivery address");
        oldOrders.add("2022-05-12"); //order date
        oldOrders.add("2022-05-15"); //delivery date
        oldOrders.add("Chocolate");
        oldOrders.add("large");
        oldOrders.add("heart");
        oldOrders.add("Cher3");
        oldOrders.add("contact details");
        oldOrders.add("delivery address");
        oldOrders.add("2022-05-12"); //order date
        oldOrders.add("2022-05-15"); //delivery date
        oldOrders.add("Red Velvet");
        oldOrders.add("large");
        oldOrders.add("heart");
    }
    
    private static void getName() { //Prompts user for name, then prints text containing their input.
        System.out.println("Please enter your name.");
        username = SC.nextLine();
//        System.out.println("Your username: " + username);
    }

    private static void addRecipe(){ //Adds first user input to index 0, second to index 1 and third to index 2, then...
                                     //...prints list for confirmation.
        System.out.println("Please enter the name of the cake.");
        recipeList.add(recipeSC.nextLine());
        System.out.println("Please enter the ingredients.");
        recipeList.add(recipeSC.nextLine());
        System.out.println("Please enter the instructions.");
        recipeList.add(recipeSC.nextLine());
//        System.out.println(recipeList);//Displays recipeList so status of input can be confirmed
        System.out.println("All recipes: \n");
        for (int i = 0; i < recipeList.size(); i++) {
            System.out.println(recipeList.get(i));
            if (i % 3 == 2) { //Adds a string of hyphens to separate each order
                System.out.println("---------------------------------------------------------------------------");
            }
        }
    }

    private static void deleteRecipe() { //Deletes a full recipe if user inputs matches any indices
        System.out.println("Please enter the name of the cake to delete.");
        cakeToDelete = deleteSC.nextLine();
        for (int i = 0; i < recipeList.size(); i++) {//For loop that iterates through recipeList
            if (recipeList.get(i).contains(cakeToDelete)) {//removes a full recipe if condition is met
                recipeList.remove(i);
                recipeList.remove(i);
                recipeList.remove(i);
                for (int j = 0; j < recipeList.size(); j++) {
                    if (j == 0){
                        System.out.println(cakeToDelete + " has been removed from the recipe list.\n");
                        System.out.println("The recipe list now contains:\n");
                    }
                    System.out.println(recipeList.get(j));
                    if (j % 3 == 2) { //Adds a string of hyphens to separate each recipe
                    System.out.println("---------------------------------------------------------------------------");
                    }
                }
            }
        }//System.out.println("Recipe list: " + recipeList);//Displays recipeList for testing.
    }

    private static void addOrder(){ //Adds 8 values into orderList, which are then moved to ordersDue or oldOrders...
                                    //based on the delivery date value
        System.out.println("Please enter the client's name.");
        orderList.add(orderSC.nextLine());
        System.out.println("Please enter the client's contact details.");
        orderList.add(orderSC.nextLine());
        System.out.println("Please enter the delivery address.");
        orderList.add(orderSC.nextLine());
        LocalDate orderDate = LocalDate.now();
        orderList.add(String.valueOf(orderDate)); //automatically adds today's date as string to list
        LocalDate orderDatePlusThree = orderDate.plusDays(3);//Adds 3 days to today's date to generate delivery date
        orderList.add(String.valueOf(orderDatePlusThree));
        System.out.println("Please enter the type of cake.");
        orderList.add(orderSC.nextLine());
        System.out.println("Please enter the cake size.");
        orderList.add(orderSC.nextLine());
        System.out.println("Please enter the cake shape.");
        orderList.add(orderSC.nextLine());
//        System.out.println("orderList: " + orderList);// For checking the contents of orderList

        String deliveryDate = orderList.get(4); //stores index 4 inside new string
        LocalDate date = LocalDate.parse(deliveryDate); //converts deliveryDate string to date object
        LocalDate today = LocalDate.now(); // Stores today's date, for comparisons with deliveryDate
        if (date.compareTo(today) >= 0) {
//            System.out.println("delivery date occurs AFTER today's date");//For checking which statement has been executed
            ordersDue.add(orderList.get(0));
            ordersDue.add(orderList.get(1));
            ordersDue.add(orderList.get(2));
            ordersDue.add(orderList.get(3));
            ordersDue.add(orderList.get(4));
            ordersDue.add(orderList.get(5));
            ordersDue.add(orderList.get(6));
            ordersDue.add(orderList.get(7));//Adds 8 elements (1 full order) to the ordersDue list
            orderList.removeAll(orderList);//Clears orderList by removing all elements
            System.out.println("orderList: " + orderList);//For confirming successful removal
            System.out.println("ordersDue: " + ordersDue);//For confirming the results of the if statement

        } else if (date.compareTo(today) < 0) {
            System.out.println("delivery date occurs BEFORE today's date");//For checking which statement has been executed
            oldOrders.add(orderList.get(0));
            oldOrders.add(orderList.get(1));
            oldOrders.add(orderList.get(2));
            oldOrders.add(orderList.get(3));
            oldOrders.add(orderList.get(4));
            oldOrders.add(orderList.get(5));
            oldOrders.add(orderList.get(6));
            oldOrders.add(orderList.get(7));//Adds 8 elements (1 full order) to the oldOrders list
            orderList.removeAll(orderList);//Clears orderList by removing all elements
            System.out.println("orderList: "+ orderList);
            System.out.println("oldOrders: "+ oldOrders);//For confirming the results of the if statement
        } else {
            System.out.println("Something went wrong");//For identifying comparison errors
        }//The elseif statement is functionally useless because the automated date entry is set to present day and...
         //... future values only. Inclusion facilitates future update that allows manual date entry.
    }
    private static void deleteOrder(){//Deletes a full order if user inputs matches any indices
        System.out.println("Please enter the name of the client to delete their order.");
        orderToDelete = deleteOrderSC.nextLine();
        for (int i = 0; i < ordersDue.size(); i++) {//For loop that iterates through ordersDue
            if (ordersDue.get(i).contains(orderToDelete)) {//removes a full order if condition is met
                ordersDue.remove(i);
                ordersDue.remove(i);
                ordersDue.remove(i);
                ordersDue.remove(i);
                ordersDue.remove(i);
                ordersDue.remove(i);
                ordersDue.remove(i);
                ordersDue.remove(i);
            }
        } 
        System.out.println("ordersDue: " + ordersDue);//Displays ordersDue once for loop has ended, to confirm any changes.
    }

    private static void printOldOrders() {//Prints all elements stored in oldOrders
        System.out.println("Old orders:");
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < oldOrders.size(); i++) {
            System.out.println(oldOrders.get(i));
            if (i % 8 == 7) { //Adds a string of hyphens to separate each order
                System.out.println("---------------------------------------------------------------------------");
            }
        }
    }

    private static void printOrdersDue(){//Prints all elements stored in ordersDue
        System.out.println("Orders due:");
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < ordersDue.size(); i++) {
            System.out.println(ordersDue.get(i));
            if (i % 8 == 7) {//Adds a string of hyphens to separate each order
                System.out.println("---------------------------------------------------------------------------");
            }
        }
    }

    private static void totalIngredients(){
//        for (int i = 0; i < ordersDue.size()-1; i++){
//            System.out.println(ordersDue.size());
//            System.out.println(ordersDue.toString()+i);
//            if (ordersDue.get(i).contains("Vanilla")){
//                i++;
//                System.out.println(recipeList);
//                System.out.println("-----------------------------------------------------------------------");
//            }
//        }
//Failed implementation #1


//        int index = 0;
//        for (String lineOfCake : ordersDue){
//            System.out.println(lineOfCake);
//            if (lineOfCake.contains(ordersDue.get(0))){
//                index = recipeList.indexOf(recipeList);
//                System.out.println(recipeList.get(1));
//                System.out.println("-----------------------------------------------------------------------");
//            }
//Failed implementation #2, prints Ingredients1 as many times as there are orders, rather than a new Ingredient set each time


        System.out.println("The ingredients for due orders are as follows:\n");
        int k = 0;
        for (int i = 0; i < ordersDue.size(); i++) {//Iterates through ordersDue
            for (int j = 0;  j < recipeList.size(); j++ ) {//Iterates through recipeList
                if (ordersDue.get(i).contains(recipeList.get(j))) {
                    k++;// Tracks the number of orders
                    System.out.println("Order " + k + ": " + recipeList.get(j));
                    j++;//Increments by one again, so that the ingredients are printed and not the name
                    System.out.println(recipeList.get(j));//Prints the ingredients for 1 cake
                    System.out.println("---------------------------------------------------------------------------");
                } 
            }
        }
    }
}
 