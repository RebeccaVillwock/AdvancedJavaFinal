package testForGarage;

import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;

public class MinMaxTest {
    double testFee;

    double firstThreeHours = 3.00;
    double eachAdditionalHour = 1.00;
    double maxCost = 15.00;
    @Test
    public void testGetFee() {
        //test fee for first 3 hours
        LocalTime timeIn = LocalTime.of(11,0);
        LocalTime timeOut = LocalTime.of(12, 0);

        if(timeOut.getHour() - timeIn.getHour() <= 3){
            testFee = firstThreeHours;
        }else if(timeOut.getHour() - timeIn.getHour() < 15){
            testFee = firstThreeHours + ((timeOut.getHour() - timeIn.getHour() - 3) * eachAdditionalHour);
        }else{
            testFee = maxCost;
        }
        assertEquals("Test cost didn't get minimum fee as result", testFee, firstThreeHours,0);

        //test fee for under max
        timeIn = LocalTime.of(11,0);
        timeOut = LocalTime.of(17, 0);
        if(timeOut.getHour() - timeIn.getHour() <= 3){
            testFee = firstThreeHours;
        }else if(timeOut.getHour() - timeIn.getHour() < 15){
            testFee = firstThreeHours + ((timeOut.getHour() - timeIn.getHour() - 3) * eachAdditionalHour);
        }else{
            testFee = maxCost;
        }
        assertEquals("Test cost wasn't the same as expected", testFee, 6.0, 0);

        //test for max fee
        timeIn = LocalTime.of(1,0);
        timeOut = LocalTime.of(17, 0);

        if(timeOut.getHour() - timeIn.getHour() <= 3){
            testFee = firstThreeHours;
        }else if(timeOut.getHour() - timeIn.getHour() < 15){
            testFee = firstThreeHours + ((timeOut.getHour() - timeIn.getHour() - 3) * eachAdditionalHour);
        }else{
            testFee = maxCost;
        }
        assertEquals("Test cost wasn't maximum fee", testFee, maxCost, 0);
    }

}