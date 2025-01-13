package org.example;

import org.example.model.SeriesOfThree;
import org.example.model.SeriesOfTwo;

public class Main {
    public static void main(String[] args) {
        SeriesOfTwo seriesOfTwo = new SeriesOfTwo();
        SeriesOfThree seriesOfThree = new SeriesOfThree();

        // First scenario
        for(int i = 0; i < 4; i++)
            System.out.println(seriesOfTwo.value());

        System.out.println('\n');
        // Second scenario
        seriesOfTwo.initialSeriesNumber(1);
        for(int i = 0; i < 4; i++)
            System.out.println(seriesOfTwo.value());

        System.out.println('\n');
        // Third scenario
        for(int i = 0; i < 4; i++)
            System.out.println(seriesOfThree.value());
    }
}