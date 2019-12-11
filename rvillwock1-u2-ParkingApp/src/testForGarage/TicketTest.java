package testForGarage;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;

public class TicketTest {


    LocalTime timeOut = LocalTime.of(21, 00);
    LocalTime timeIn = LocalTime.of(12, 00);
    @Test
    public void testGetHoursInGarage() {
        int hours = timeOut.getHour() - timeIn.getHour();
        assertEquals("Hours in garage don't match", hours, 9);
    }

    @Test
    public void testDisplayTimeInHour() {
        String timeInHour;
        if(timeIn.getHour() == 0){
            timeInHour = "12AM";
        }else if(timeIn.getHour() == 12){
            timeInHour = "12PM";
        }else{
            timeInHour = timeIn.getHour() + "AM";
        }
        assertEquals("Time inHour string not generating properly", timeInHour, "12PM");
    }

    @Test
    public void testDisplayTimeOutHour() {
        String timeOutHour;
        //subtract 12 to convert to 12 hour clock
        int hour = timeOut.getHour() - 12;
        if(hour == 0){
            timeOutHour = "12PM";
        }else{
            timeOutHour = hour + "PM";
        }
        assertEquals("Time outHour string not generating properly", timeOutHour, "9PM");
    }
}