package com.company;

import java.time.LocalTime;

/**
 * this lets the program work with any strategy for calculating the fee with out knowing which one its using
 */
public interface FeeStrategy {
    double getFee(LocalTime timeIn, LocalTime timeOut);
}
