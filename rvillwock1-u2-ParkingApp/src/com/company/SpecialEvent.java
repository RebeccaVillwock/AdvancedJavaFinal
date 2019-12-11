package com.company;

import java.time.LocalTime;

/**
 * this class is used to calculate the cost of a specialEvent ticket
 */
public class SpecialEvent implements FeeStrategy {

    private double specialEventCharge = 20.00;

    /**
     * Even though it accepts the times the ticket entered and exited the garage it doesn't use them
     * all special events in this garage have the same basic fee
     * @param timeIn
     * @param timeOut
     * @return ticketFee
     */
    @Override
    public double getFee(LocalTime timeIn, LocalTime timeOut) {
        return specialEventCharge;
    }
}
