package com.example.demo.integradores.progressiveSeries;

public class ProgressiveSeries {
    private int currentValue;
    private int increment;

    public ProgressiveSeries(int increment) {
        if (increment <= 0) { throw new IllegalArgumentException("Numero negativo"); }
        this.increment = increment;
        this.currentValue = 0;
    }

    public int nextValue() {
        this.currentValue += this.increment;
        return this.currentValue;
    }

    public void reset() {
        this.currentValue = 0;
    }

    public void setInitialValue(int initialValue) {
        this.currentValue = initialValue;
    }


    public static void main(String[] args) {
        SeriesOfTwo seriesOfTwo = new SeriesOfTwo();
        System.out.println(seriesOfTwo.nextValue());
        System.out.println(seriesOfTwo.nextValue());
        System.out.println(seriesOfTwo.nextValue());
        seriesOfTwo.setInitialValue(1);
        System.out.println(seriesOfTwo.nextValue());

        System.out.println("");
        SeriesOfThree seriesOfThree = new SeriesOfThree();
        System.out.println(seriesOfThree.nextValue());
        System.out.println(seriesOfThree.nextValue());
        System.out.println(seriesOfThree.nextValue());
        seriesOfThree.reset();
        System.out.println(seriesOfThree.nextValue());
    }
}
