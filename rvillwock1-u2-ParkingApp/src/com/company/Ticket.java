package com.company;
import java.time.LocalTime;
import java.util.Random;
/**
 * This class holds all basic ticket information and assigns the time the user enters and exits the garage as well as the ticketID
 * */
public class Ticket {


     private LocalTime timeIn;
     private LocalTime timeOut;
     private int randIntForHour;
     private int numForMin = 0;


    private Random randNum = new Random();
    private int ticketNumber;
    private boolean specialEvent;


    //constructors

    /**
     * This is the basic constructor
     * @author Rebecca Villwock
     */
    public Ticket(){
        ticketNumber = randNum.nextInt(9000) + 1000;
        //time person enters garage
        randIntForHour = randNum.nextInt(12) + 1;

        timeIn = LocalTime.of(randIntForHour, numForMin);

        //weather or not it is a special event
        specialEvent = false;

    }

    /**
     * this constructor is for special event tickets
     * @param specialEvent
     */
    public Ticket(boolean specialEvent){
        //automatically assign a ticket number when a ticket is created
        ticketNumber = randNum.nextInt(9000) + 1000;

        randIntForHour = randNum.nextInt(12) + 1;
        timeIn = LocalTime.of(randIntForHour,numForMin);

        //weather or not it is a special event
        this.specialEvent = specialEvent;
    }

    /**
     * This constructor can be used to create tickets after they have been stored in a file
     * @param ticketNumber
     * @param timeIn
     * @param specialEvent
     */
    public Ticket(int ticketNumber, LocalTime timeIn, boolean specialEvent){
        this.ticketNumber = ticketNumber;
        this.timeIn = timeIn;

        //weather or not it is a special event
        this.specialEvent = specialEvent;

    }


    public void setTicketNumber(){
        //if ticket number already present this method will return a new ticket number
        ticketNumber = randNum.nextInt(9000) + 1000;
    }

    /**
     * allows user to work with the tickets entrance time
     * @return timeIn
     */
    public LocalTime getTimeIn(){
        return timeIn;
    }

    public void setTimeOut(){
        randIntForHour = randNum.nextInt(12) + 12;
        timeOut = LocalTime.of(randIntForHour, numForMin);
    }

    /**
     * allows user to work with the tickets exit time
     * @return timeOut
     */
    public LocalTime getTimeOut(){
        return timeOut;
    }

    /**
     * allows user to work with the ticket id number
     * @return ticketNumber;
     */
    public int getTicketNumber(){
        return ticketNumber;
    }

    /**
     * allows user to tell the ticket its for a special event after it has been created.
     * @param specialEvent
     */
    public void setSpecialEvent(boolean specialEvent){ this.specialEvent = specialEvent; }

    /**
     * allows user to work with the special event variable
     * works best for looping purposes
     * @return specialEvent
     */
    public boolean getSpecialEvent(){
        return specialEvent;
    }

    /**
     * allows user to see and work with the integer equivalent to the hours the ticket was in the garage
     * @return hoursInGarage
     */
    public int getHoursInGarage(){
        return timeOut.getHour() - timeIn.getHour();
    }

    /**
     * allows user to get the string equivalent of the hour ticket entered garage in 12 hour format
     * @return timeInHourString
     */
    public String displayTimeInHour() {
        if(timeIn.getHour() == 0){
            return "12AM";
        }else if(timeIn.getHour() == 12){
            return "12PM";
        }else{
            return timeIn.getHour() + "AM";
        }
    }

    /**
     * allows user to get the string equivalent of the hour ticket entered garage in 12 hour format
     * @return timeOutHourString
     */
    public String displayTimeOutHour(){
        //subtract 12 to convert to 12 hour clock
        int hour = timeOut.getHour() - 12;
        if(hour == 0){
            return "12PM";
        }else{
            return hour + "PM";
        }
    }




}
