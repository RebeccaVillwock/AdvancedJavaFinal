package testForGarage;

import com.company.*;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;

public class GarageTest {


    //int ticketNumber, LocalTime timeIn, boolean specialEvent

    LocalTime timeIn =  LocalTime.of(11,0);
    LocalTime timeOut = LocalTime.of(13,0);
    @Test
    public void leaveGarageWithTicket() {
        double expectedMinMaxRevenue = 3.00;
        double expectedTotalRevenue = 23.00;
        double expectedSpecialEventRevenue = 20.00;
        double minMaxRevenue = 0;
        double totalRevenue = 0;
        double specialEventRevenue = 0;

        //test for minMax ticket and minMaxRevenue
        Ticket ticket = new Ticket(1111, timeIn, false);
        if(ticket.getSpecialEvent()){
            FeeStrategy feeStrategy = new MinMax();
            minMaxRevenue += feeStrategy.getFee(ticket.getTimeIn(), timeOut);
            totalRevenue += feeStrategy.getFee(ticket.getTimeIn(), timeOut);
            assertEquals("Didn't get the proper minMaxRevenue back", minMaxRevenue, expectedMinMaxRevenue, 0);
        }else{
            FeeStrategy feeStrategy = new SpecialEvent();
            specialEventRevenue += feeStrategy.getFee(ticket.getTimeIn(), ticket.getTimeOut());
            totalRevenue += feeStrategy.getFee(ticket.getTimeIn(), ticket.getTimeOut());
        }


        //test for specialEvent ticket specialEventRevenue then verifies totalRevenue
        ticket = new Ticket(1112, timeIn, true);
        if(ticket.getSpecialEvent()){
            FeeStrategy feeStrategy = new MinMax();
            minMaxRevenue += feeStrategy.getFee(ticket.getTimeIn(), timeOut);
            totalRevenue += feeStrategy.getFee(ticket.getTimeIn(), timeOut);
        }else{
            FeeStrategy feeStrategy = new SpecialEvent();
            specialEventRevenue += feeStrategy.getFee(ticket.getTimeIn(), ticket.getTimeOut());
            totalRevenue += feeStrategy.getFee(ticket.getTimeIn(), ticket.getTimeOut());
        }
        assertEquals("Didn't get the proper specialEventRevenue", specialEventRevenue, expectedSpecialEventRevenue, 0);
        assertEquals("Didn't get the proper totalRevenue back", totalRevenue, expectedTotalRevenue, 0);
    }

    @Test
    public void leaveGarageWithOutTicket() {
        double expectedLostTicketRevenue = 25.00;
        double expectedTotalRevenue = 25.00;

        double lostTicketRevenue = 0;
        double totalRevenue = 0;

        FeeStrategy feeStrategy = new LostTicket();

        Ticket ticket = new Ticket();
        lostTicketRevenue += feeStrategy.getFee(ticket.getTimeIn(), ticket.getTimeOut());
        totalRevenue += feeStrategy.getFee(ticket.getTimeIn(), ticket.getTimeOut());

        assertEquals("Didn't get the proper lostTicketRevenue", lostTicketRevenue, expectedLostTicketRevenue, 0);
        assertEquals("Didn't get the proper totalRevenue", totalRevenue, expectedTotalRevenue, 0);

    }
}