package com.example.demo.generics;

import java.util.Arrays;

public class QuickSortGenerics<T extends Comparable<T>> {

    public void quickSort(T[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);

            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private int partition(T[] array, int left, int right) {
        T pivot = array[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, right);
        return i + 1;
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] intArray = {10, 7, 8, 9, 1, 5};
        QuickSortGenerics<Integer> sorter = new QuickSortGenerics<>();
        System.out.println("Array original: " + Arrays.toString(intArray));

        sorter.quickSort(intArray, 0, intArray.length - 1);
        System.out.println("Array ordenado: " + Arrays.toString(intArray));

        String[] stringArray = {"manzana", "pera", "kiwi", "naranja", "uva"};
        QuickSortGenerics<String> stringSorter = new QuickSortGenerics<>();
        System.out.println("\nArray original: " + Arrays.toString(stringArray));

        stringSorter.quickSort(stringArray, 0, stringArray.length - 1);
        System.out.println("Array ordenado: " + Arrays.toString(stringArray));
    }
}

