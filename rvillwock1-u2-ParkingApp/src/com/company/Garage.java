package com.company;

import java.util.ArrayList;

/**
 * The garage class is where the fee strategy, and tickets are created.
 * It also calculates the revenue from each type of ticket and how many of them there where.
 * All of the display options are written here
 * @author Rebecca Villwock
 */
public class Garage {
    private FeeStrategyFactory feeFactory = new FeeStrategyFactoryImpl();
    private FeeStrategy feeStrategy;

    private Ticket ticket = new Ticket();

    //money collected through out the day
    private double minMaxRevenue;
    private double lostTicketRevenue;
    private double specialEventRevenue;
    private double totalRevenue;

    //number of cars money was collected from
    private int numMinMaxTickets = 0;
    private int numSpecialEventTickets = 0;
    private int numLostTickets = 0;


    //constructors
    public void createMinMaxTicket(){
        ticket = new Ticket();
    }
    public void createSpecialEventTicket(){
        ticket = new Ticket(true);
    }

    //used to calculate and update appropriate variables and display exit tickets
    public void leaveGarageWithTicket(){
        ticket.setTimeOut();
        if(ticket.getSpecialEvent() == false){
            feeStrategy = feeFactory.makeFeeStrategy("MinMax");
            //increase revenue and add tally to ticket count
            minMaxRevenue += feeStrategy.getFee(ticket.getTimeIn(), ticket.getTimeOut());
            totalRevenue += feeStrategy.getFee(ticket.getTimeIn(), ticket.getTimeOut());
            numMinMaxTickets++;
            displayMinMaxCheckOut();

        }else{
           feeStrategy = feeFactory.makeFeeStrategy("SpecialEvent");
           //increase revenue and add tally to ticket count
            specialEventRevenue += feeStrategy.getFee(ticket.getTimeIn(), ticket.getTimeOut());
            totalRevenue += feeStrategy.getFee(ticket.getTimeIn(), ticket.getTimeOut());
            numSpecialEventTickets++;
            displaySpecialEventCheckOut();

        }
    }
    public void leaveGarageWithOutTicket(){
        ticket.setTimeOut();
        feeStrategy = feeFactory.makeFeeStrategy("LostTicket");
        //increase revenue and add tally to ticket count
        lostTicketRevenue += feeStrategy.getFee(ticket.getTimeIn(), ticket.getTimeOut());
        totalRevenue += feeStrategy.getFee(ticket.getTimeIn(), ticket.getTimeOut());
        numLostTickets++;
        displayLostTicketCheckOut();
    }





    public void isSpecialEvent(){
        ticket.setSpecialEvent(true);
    }

    /**
     * allows user to see the ticket number with out seeing how it is retrieved
     * helps prevent coupling
     * @return ticketNumber
     */
    public int getTicketNumber(){
         return ticket.getTicketNumber();
    }


    //display menu methods
    //input
    public void displayOpeningMenu(){
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("1 - Check-In");
        System.out.println("2 - Check-Out");
        System.out.println("3 - Close Garage");
        System.out.print("=>");
    }
    public void displayChoiceMenu(){
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("1 - Check-In");
        System.out.println("2 - Check-Out");
        System.out.println("3 - Close Garage");
        System.out.print("=>");
    }
    public void displayCheckInMenu(){
        System.out.println("Best Value Parking Garage");
        System.out.println("Check-In");
        System.out.println("=========================");
        System.out.println("1 - Ticket");
        System.out.println("2 - Special Event");
        System.out.print("=>");
    }
    public void displayCheckOutMenu(){
        System.out.println("Best Value Parking Garage");
        System.out.println("Check-Out");
        System.out.println("=========================");
        System.out.println("1 - Ticket");
        System.out.println("2 - Lost Ticket");
        System.out.print("=>");
    }
    public void displayCheckOutWithTicket(){
        System.out.println("Best Value Parking Garage");
        System.out.println("Check-Out - Ticket");
        System.out.println("=========================");
        System.out.print("Ticket Number =>");
    }

    //output

    public void displayCheckInReceipt(){
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("Ticket for a vehicle id " + ticket.getTicketNumber());
        System.out.println();
        System.out.println(ticket.getTimeIn());
        System.out.println();
    }
    public void displayMinMaxCheckOut(){
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("Ticket for a vehicle id " + ticket.getTicketNumber());
        System.out.println();
        System.out.println(ticket.getHoursInGarage() + " hours parked " + ticket.displayTimeInHour() + " - " + ticket.displayTimeOutHour());
        //calculates and prints ticket fee
        System.out.println("$" + feeStrategy.getFee(ticket.getTimeIn(), ticket.getTimeOut()) + "0");
        System.out.println();
    }
    public void displaySpecialEventCheckOut(){
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("Ticket for a vehicle id " + ticket.getTicketNumber());
        System.out.println();
        System.out.println("Special Event");
        //calculates and prints ticket fee
        System.out.println("$" + feeStrategy.getFee(ticket.getTimeIn(), ticket.getTimeOut()) + "0");
        System.out.println();

    }
    public void displayLostTicketCheckOut(){
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("Ticket for a vehicle id " + ticket.getTicketNumber());
        System.out.println();
        System.out.println("Lost Ticket");
        //calculates and prints ticket fee
        System.out.println("$" + feeStrategy.getFee(ticket.getTimeIn(), ticket.getTimeOut()) + "0");
        System.out.println();

    }
    public void displayCloseGarage(){
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("Activity to date");
        System.out.println();
        System.out.println("$" + minMaxRevenue + "0 was collected from " + numMinMaxTickets + " Check Ins");
        System.out.println("$" + specialEventRevenue + "0 was collected from " + numSpecialEventTickets + " Special Events");
        System.out.println("$" + lostTicketRevenue + "0 was collected from " + numLostTickets + " Lost Tickets");
        System.out.println();
        System.out.println("$" + totalRevenue + "0 was collected overall");
    }


}
