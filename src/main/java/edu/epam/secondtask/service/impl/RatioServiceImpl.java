package edu.epam.secondtask.service.impl;

import edu.epam.secondtask.entity.Ratio;
import edu.epam.secondtask.service.RatioService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class RatioServiceImpl implements RatioService {
    static Logger logger = LogManager.getLogger(RatioServiceImpl.class);
    @Override
    public void reduce(Ratio ratio) {
        Double numerator = ratio.getNumerator();
        Double denominator = ratio.getDenominator();
        if (numerator % denominator == 0 || denominator % numerator == 0) {
            if (numerator >= denominator) {
                ratio.setNumerator(numerator / denominator);
                ratio.setDenominator(denominator / denominator);
            } else {
                ratio.setNumerator(numerator / numerator);
                ratio.setDenominator(denominator / numerator);
            }
            return;
        }
        for (int i = 0; i < ratio.getNumerator() / 2; i++) {
            if (denominator % i == 0 && numerator % i == 0) {
                denominator /= i;
                numerator /= i;
            }
        }
    }
}
