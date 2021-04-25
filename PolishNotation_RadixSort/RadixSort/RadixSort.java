package PolishNotation_RadixSort.RadixSort;

import java.util.*;

public class RadixSort {

    public static int getItNo(int[] list) {
        int max = list[0];

        for (int i = 1; i < list.length;  i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        int it = 0;
        while (max != 0) {
            it++;
            max /= 10;
        }

        return it;
    }

    // 1
    public static Deque<Integer> orderRadixSort(int[] list) {
        int it = getItNo(list);
        List<Deque<Integer>> helpQ = new ArrayList<>(10);
        Deque<Integer> result = new ArrayDeque<>();

        for (int i = 0; i < list.length; i++) {
            result.offer(list[i]);
        }

        int div = 1;

        for (int i = 0; i < 10; i++) {
            Deque<Integer> newRow  = new LinkedList<>();
            helpQ.add(newRow);
        }

        while (it > 0) {
            for (int j = 0; j < list.length; j++) {
                int elem = result.poll();
                int get = (elem / div) % 10;
                helpQ.get(get).offer(elem);
            }


            int noElem = 0;
            for (int k = 0; k < 10; k++) {
                while (!helpQ.get(k).isEmpty()) {
                    result.offer(helpQ.get(k).poll());
                }

            }

            div *= 10;
            it--;
        }

        return result;
    }

    // 2
    public static Deque<Integer> descendingRadixSort(int[] list) {
        int it = getItNo(list);
        List<Deque<Integer>> helpQ = new ArrayList<>(10);
        Deque<Integer> result = new ArrayDeque<>();

        for (int i = 0; i < list.length; i++) {
            result.offer(list[i]);
        }

        int div = 1;

        for (int i = 0; i < 10; i++) {
            Deque<Integer> newRow  = new LinkedList<>();
            helpQ.add(newRow);
        }

        while (it > 0) {
            for (int j = 0; j < list.length; j++) {
                int elem = result.poll();
                int get = (elem / div) % 10;
                helpQ.get(get).push(elem);
            }


            int noElem = 0;
            for (int k = 0; k < 10; k++) {
                while (!helpQ.get(k).isEmpty()) {
                    result.push(helpQ.get(k).pop());
                }
            }

            div *= 10;
            it--;
        }

        return result;
    }
}
