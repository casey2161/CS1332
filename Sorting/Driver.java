import java.util.Random;
import java.util.Scanner;


public class Driver {
    
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.println("Enter the size of the random array or 0 to quit");
        int size = Integer.parseInt(in.nextLine());
        while (size > 0) {
            int[] randomArray = new int[size];
            Integer[] randomArray1 = new Integer[size];
            Random gen = new Random();
            for (int i = 0; i < size; i++) {
                randomArray[i] = Math.abs(gen.nextInt());
                randomArray1[i] = (Integer) randomArray[i];
            }
            Sorting s = new Sorting();
            double time;
            long start = System.nanoTime();
            int[] sorted = s.radixsort(randomArray);
            time = (System.nanoTime() - start) / 1000d;
            System.out.println("The unsorted array is: " + string(randomArray));
            System.out.println("The sorted array is: " + string(sorted));
            System.out.println("It took radix sort " + time + " seconds");
            
            Integer[] temp  = clone(randomArray1);
            start = System.nanoTime();
            s.bubblesort(temp);
            time = (System.nanoTime() - start) / 1000d;
            System.out.println("It took bubble sort " + time + " seconds");
            
            temp  = clone(randomArray1);
            start = System.nanoTime();
            s.insertionsort(temp);
            time = (System.nanoTime() - start) / 1000d;
            System.out.println("It took insertion sort " + time + " seconds");
            
            temp  = clone(randomArray1);
            start = System.nanoTime();
            s.selectionsort(temp);
            time = (System.nanoTime() - start) / 1000d;
            System.out.println("It took selection sort " + time + " seconds");
            
            temp  = clone(randomArray1);
            start = System.nanoTime();
            s.mergesort(temp);
            time = (System.nanoTime() - start) / 1000d;
            System.out.println("It took merge sort " + time + " seconds");
            
            temp  = clone(randomArray1);
            start = System.nanoTime();
            s.quicksort(temp, new Random());
            time = (System.nanoTime() - start) / 1000d;
            System.out.println("It took quick sort " + time + " seconds");
            System.out.println("Enter the size of the random array or 0 to quit");
            
            size = Integer.parseInt(in.nextLine());
        }
        in.close();
    }

    /**
     * This method clones an Integer[].
     * This is used to allow the sorts their own copy of the array
     * @param randomArray1 the array to clone
     * @return a new array with the same values as the one given
     */
    private static Integer[] clone(Integer[] randomArray1) {
        Integer[] array = new Integer[randomArray1.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = randomArray1[i];
        }
        return array;
    }
    
    /**
     * This is a simple helper method that creates
     * a nice String for an int[]
     * @param array the int[] to make a string for
     * @return a nicely formatted string
     */
    private static String string(int[] array) {
        String ret = "";
        for (int i = 0; i < array.length - 1; i++) {
            ret += array[i] + ", ";
        }
        ret += array[array.length - 1];
        return ret;
    }
}
