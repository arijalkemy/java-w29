package org.example.model;

public abstract class Prototype<T extends Number> {
    /**
     * Constructor
     */
    public Prototype() {
    }

    /**
     * Returns the next number in the series
     * @return number
     */
    public abstract T value();

    /**
     * Restart the series
     */
    public abstract void restartNumber();

    /**
     * Restart initial numer of serie
     * @param number initial value
     */
    public abstract void initialSeriesNumber(T number);
}