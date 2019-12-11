package com.company;

import java.time.LocalTime;

/**
 * this class creates the fee strategy
 */
public class FeeStrategyFactoryImpl implements FeeStrategyFactory {

    /**
     * this class accepts a string and based on the string it creates the correct fee strategy
     * @param feeStrategyName
     * @return feeStrategy
     */
    @Override
    public FeeStrategy makeFeeStrategy(String feeStrategyName) {
        if(feeStrategyName == "LostTicket"){
            FeeStrategy lostTicket = new LostTicket();
            return lostTicket;
        }else if(feeStrategyName == "SpecialEvent"){
            FeeStrategy specialEvent = new SpecialEvent();
            return specialEvent;
        }else if(feeStrategyName == "MinMax"){
            FeeStrategy minMax = new MinMax();
            return minMax;
        }else{
            FeeStrategy defaultStrategy = new LostTicket();
            return defaultStrategy;
        }
    }
}
