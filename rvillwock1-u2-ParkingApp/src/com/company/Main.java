package com.company;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;




public class Main {
//contemplate a garage class to hold prompts and time information
    public static void main(String[] args) {

        //the garage itself
        Garage garage = new Garage();

        //to hold time data
        LocalTime timeEnteredGarage;

        //to hold the current ticket
        Ticket currentTicket = new Ticket();

        Scanner keyboard = new Scanner(System.in);
        char userInput = '1';
        int userNumber;





        while(userInput == '1' || userInput == '2' || userInput == '3' ){
            //begin working with garage
            garage.displayOpeningMenu();
            userInput = keyboard.nextLine().charAt(0);

            //make sure the user enters a valid option
            while(!(userInput == '1' || userInput == '2' || userInput == '3')){
                System.out.println();
                System.out.println("That is not a valid choice");
                System.out.println();
                garage.displayOpeningMenu();
                userInput = keyboard.nextLine().charAt(0);
            }

            //user is checking in
            if(userInput == '1'){
                garage.displayCheckInMenu();
                userInput = keyboard.nextLine().charAt(0);

                //make sure user enters a valid option
                while(!(userInput == '1' || userInput == '2')){
                    System.out.println();
                    System.out.println("That is not a valid choice");
                    System.out.println();
                    garage.displayCheckInMenu();
                    userInput = keyboard.nextLine().charAt(0);
                }

                //user wants a regular ticket
                if(userInput == '1'){
                    garage.createMinMaxTicket();
                    garage.displayCheckInReceipt();
                }

                //user wants a special event ticket
                else if (userInput == '2') {
                    garage.createSpecialEventTicket();
                    garage.displayCheckInReceipt();
                }

            }

            //user is checking out
            else if(userInput == '2'){
                garage.displayCheckOutMenu();
                userInput = keyboard.nextLine().charAt(0);

                //if user has their ticket
                if(userInput == '1') {
                    garage.displayCheckOutWithTicket();
                    userNumber = Integer.parseInt(keyboard.nextLine());

                    //verify entered number matches ticket
                    while (!(userNumber == garage.getTicketNumber())) {
                        System.out.println();
                        System.out.println("That is not a valid Ticket ID");
                        //for programmer to cheat
                        System.out.println(garage.getTicketNumber());
                        System.out.println();
                        garage.leaveGarageWithTicket();
                        garage.displayCheckOutWithTicket();
                        userNumber = keyboard.nextInt();
                    }
                    garage.leaveGarageWithTicket();
                }

                //if user lost their ticket
                else if(userInput == '2'){
                    garage.leaveGarageWithOutTicket();
                }

            }

            //user is closing garage
            else if(userInput == '3'){
                garage.displayCloseGarage();
            }
        }


    }
}
