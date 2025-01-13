package org.example.model;

public class SeriesOfTwo extends Prototype {

    /**
     * Attibutes
     */
    private int actualValue = 0;

    /**
     * Constructor
     */
    public SeriesOfTwo() {
    }

    @Override
    public Number value() {
        return actualValue += 2;
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
