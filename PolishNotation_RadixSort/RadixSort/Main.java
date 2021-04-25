package PolishNotation_RadixSort.RadixSort;

public class Main {
    public static void main(String[] args) {
        int[] test = {1000, 4, 25, 319, 88, 51, 3430, 8471, 701, 1, 2989, 657, 713};

        System.out.println(RadixSort.orderRadixSort(test));
        System.out.println(RadixSort.descendingRadixSort(test));

    }
}
