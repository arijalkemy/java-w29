package org.example.model;

public class SeriesOfThree extends Prototype {
    /**
     * Attibutes
     */
    private int actualValue = 0;

    /**
     * Constructor
     */
    public SeriesOfThree() {
    }

    @Override
    public Number value() {
        return actualValue += 3;
    }

    @Override
    public void restartNumber() {
        actualValue = 0;
    }

    @Override
    public void initialSeriesNumber(Number number) {
        actualValue = (Integer) number;
    }
}
