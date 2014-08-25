import java.util.Random;


public class Sorting implements SortingInterface {

    @Override
    public <T extends Comparable<T>> void bubblesort(T[] arr) {
        for (int i = arr.length; i >= 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    @Override
    public <T extends Comparable<T>> void insertionsort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T nextToInsert = arr[i];
            insertInOrder(nextToInsert, arr, 0, i - 1);
        }
    }
    
    /**
     * This is a helper method for insertion sort
     * @param next the next element to manipulate
     * @param arr the array
     * @param first the first index
     * @param last the last index
     */
    private <T extends Comparable<T>> void insertInOrder(T next, T[] arr, int first, int last) {
        int index = last;
        while ((index >= first) && (next.compareTo(arr[index]) <= 0)) {
            arr[index + 1] = arr[index];
            index--;
        }
        arr[index + 1] = next;
    }

    @Override
    public <T extends Comparable<T>> void selectionsort(T[] arr) {
        T min;
        int minInd = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            min = arr[j];
            minInd = j;
            for (int i = j + 1; i < arr.length; i++) {
                if (min.compareTo(arr[i]) > 0) {
                    min = arr[i];
                    minInd = i;
                }
            }
            swap(arr, j, minInd);
        }
    }

    @Override
    public <T extends Comparable<T>> void quicksort(T[] arr, Random r) {
        quicksort(arr, 0, arr.length - 1, r);
    }
    
    /**
     * This is a helper method for quicksort
     * @param arr the array to sort
     * @param first the first index of the array
     * @param last the last index of the array
     * @param r the random generator to find a pivot with
     */
    private <T extends Comparable<T>> void quicksort(T[] arr, int first, int last, Random r) {
        if (last > first) {
            int newPInd = partition(arr, first, last, r.nextInt(last - first) + first);
            quicksort(arr, first, newPInd - 1, r);
            quicksort(arr, newPInd + 1, last, r);
        }
    }
    
    /**
     * This method handles partitioning for quicksort
     * @param arr the original array
     * @param first the first index
     * @param last the last index
     * @param pivotInd the index of the pivot
     * @return the new index of the pivot
     */
    private <T extends Comparable<T>> int partition(T[] arr, int first, int last, int pivotInd) {
        T pivot = arr[pivotInd];
        swap(arr, pivotInd, last);
        int ind = first;
        for (int i = first; i < last; i++) {
            if (arr[i].compareTo(pivot) <= 0) {
                swap(arr, i, ind);
                ind++;
            }
        }
        swap(arr, last, ind);
        return ind;
    }

    @Override
    public <T extends Comparable<T>> T[] mergesort(T[] arr) {
        if (arr.length > 1) {
            T[] left = (T[]) new Comparable[arr.length / 2];
            T[] right = (T[]) new Comparable[arr.length - arr.length / 2];
            for (int i = 0; i < arr.length / 2; i++) {
                left[i] = arr[i];
            }
            for (int i = 0; i < right.length; i++) {
                right[i] = arr[arr.length / 2 + i];
            }
            mergesort(left);
            mergesort(right);
            arr = merge(arr, left, right);
        }
        return arr;
    }
    
    /**
     * This method handles the merging part of merge sort
     * @param arr the array to merge in to
     * @param left the left array
     * @param right the right array
     * @return the merged array
     */
    private <T extends Comparable<T>> T[] merge(T[] arr, T[] left, T[] right) {
        int indL = 0;
        int indR = 0;
        //T[] temp = (T[]) new Object[arr.length];
        int index = 0;
        while (indL < left.length && indR < right.length) {
            if (left[indL].compareTo(right[indR]) <= 0) {
                arr[index++] = left[indL++];
            } else {
                arr[index++] = right[indR++];
            }
        }
        
        if (indL == left.length) {
            for (int i = indR; i < right.length; i++) {
                arr[index++] = right[i];
            }
        } else if (indR == right.length) {
            for (int i = indL; i < left.length; i++) {
                arr[index++] = left[i];
            }
        }
        return arr;
    }

    @Override
    public int[] radixsort(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        
        int maxDigit = findMaxDigit(arr);
        for (int i = 0; i < maxDigit; i++) {
            int[][] bucket = new int[10][arr.length];
            int[] counter = new int[10];
            for (int j = 0; j < temp.length; j++) {
                int digit = Math.abs((int) ((temp[j] / Math.pow(10, i)) % 10));
                bucket[digit][counter[digit]++] = temp[j];
            }
            int index = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < counter[j]; k++) {
                    temp[index++] = bucket[j][k];
                }
            }
        }
        return temp;
    }
    
    /**
     * This method finds the maximum number of digits for the largest number in an array
     * @param arr the array to search
     * @return the number of digits the max number has
     */
    private int findMaxDigit(int[] arr) {
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) > max) {
                max = Math.abs(arr[i]);
            }
        }
        return 1 + (int) Math.log10(max);
    }
    
    /**
     * This method swaps two elements of an array
     * @param arr the array the elements are in
     * @param ind1 the index of one value
     * @param ind2 the index of another value
     */
    private <T extends Comparable<T>> void swap(T[] arr, int ind1, int ind2) {
        T temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }
    

}
