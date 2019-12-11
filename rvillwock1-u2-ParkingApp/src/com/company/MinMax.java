package com.company;
import java.time.LocalTime;
import java.util.Random;

/**
 * this class calculates the ticket fee based on an hourly rate
 * there is a minimum or maximum amount the ticket could cost
 * @author Rebecca Villwock
 */
public class MinMax implements FeeStrategy {
    private double firstThreeHours = 3.00;
    private double eachAdditionalHour = 1.00;
    private double maxCost = 15.00;

    /**
     * accepts the time the ticket entered and exits the garage and calculates the fee
     * @param timeIn
     * @param timeOut
     * @return ticketFee
     */
    @Override
    public double getFee(LocalTime timeIn, LocalTime timeOut) {
        //get time in garage then put through loop to determine and return appropriate cost
        //first 3 hours $5
        //every additional hour + $1
        //max of $15
        if(timeOut.getHour() - timeIn.getHour() <= 3){
            return firstThreeHours;
        }else if(timeOut.getHour() - timeIn.getHour() < 15){
            return firstThreeHours + ((timeOut.getHour() - timeIn.getHour() - 3) * eachAdditionalHour);
        }else{
            return maxCost;
        }
    }
}
