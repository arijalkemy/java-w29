package org;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World!");
        printForEach();
        printStreamArray();
        ejemplo1();
        ejemplo2();
    }



    public static void printForEach(){
        List<String> names = getStringAray();
        for (String name : names){
            System.out.println(name);
        }
    }

    public static void printStreamArray(){
        List<String> names = getStringAray();

        names.stream().forEach(System.out::println);
    }

    private static List<String> getStringAray() {
        List<String> names = new ArrayList<>();
        names.add("A");
        names.add("B");
        names.add("C");
        return names;
    }

    public static void  ejemplo1(){

        System.out.println("Usando stream");
        Stream.of("a", "b", "c").map(country->country.toUpperCase()).forEach(System.out::println);
    }

    public static void  ejemplo2(){

        System.out.println("Usando stream 2 ");
        List <String> countries = Stream.of("a", "b", "c").map(country->country.toUpperCase()).collect(Collectors.toList());
        countries.forEach(System.out::println);
    }

}
