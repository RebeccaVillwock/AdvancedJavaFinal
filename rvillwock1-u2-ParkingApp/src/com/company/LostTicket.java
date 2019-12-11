package com.company;

import java.time.LocalTime;

/**
 * This class calculates the cost of a lost ticket
 */
public class LostTicket implements FeeStrategy {
    private double lostTicketCharge = 25.00;

    /**
     * Even though it accepts the times the ticket entered and exited the garage it doesn't use them
     * In this garage all lost tickets cost the same basic fee
     * @param timeIn
     * @param timeOut
     * @return ticketFee
     */
    @Override
    public double getFee(LocalTime timeIn, LocalTime timeOut) {
        return lostTicketCharge;
    }
}
