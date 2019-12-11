package com.company;

import java.time.LocalTime;

/**
 * this class allows the user to have more than one factory in case the company wants to add new options
 */
public interface FeeStrategyFactory {
    FeeStrategy makeFeeStrategy(String feeStrategyName);
}
