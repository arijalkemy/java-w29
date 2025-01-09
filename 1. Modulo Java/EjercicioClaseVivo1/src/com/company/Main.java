package com.company;

public class Main {

    public static void main(String[] args) {
	    String []cities = {
	            "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asuncion",
                "Sao Paulo",
                "Lima",
                "Santiago de chile",
				"Lisboa",
				"Tokio"
	    };

	    int [][]temperatures = {
	    		{-2, 33},
				{-3, 32},
				{-8, 27},
				{4, 37},
				{6, 42},
				{5, 43},
				{0, 39},
				{-7, 26},
				{-1, 31},
				{-10, 35},
		};

	    int tempMax = temperatures[0][0];
	    int tempMin = temperatures[0][0];
	    String cityMax = "";
	    String cityMin = "";

	    for (int i = 0; i < cities.length; i+=1) {
	    	if (temperatures[i][0] < tempMin) {
				tempMin = temperatures[i][0];
	    		cityMin = cities[i];
			}

	    	if (temperatures[i][1] > tempMax) {
				tempMax = temperatures[i][1];
	    		cityMax = cities[i];
			}
		}

		System.out.println("La ciudad con menor temperatura fue " + cityMin + " con " + tempMin);
		System.out.println("La ciudad con meyor temperatura fue " + cityMax + " con " + tempMax);
    }
}
