package org.example;

public class Main {
    public static void main(String[] args) {
        Serie2 s2 = new Serie2();
        s2.setValorinicial(0);

        System.out.println("---------Serie 2 valor inicial 0.-----------");
        for(int i=0;i<=4;i++){
            System.out.println(s2.siguiente());
        }

        System.out.println("---------Serie 2 valor inicial 1.-----------");
        s2.setValorinicial(1);
        for(int i=0;i<=10;i++){
            System.out.println(s2.siguiente());
        }



        Serie3 s3 = new Serie3();

        System.out.println("---------Serie 3 valor inicial 0.-----------");
        for(int i=0;i<=10;i++){
            System.out.println(s3.siguiente());
        }

        System.out.println("---------Serie 3 valor inicial 3.-----------");
        s3.setValorinicial(3);
        for(int i=0;i<=10;i++){
            System.out.println(s3.siguiente());
        }
    }



}