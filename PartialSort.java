/**
*Returns the k smallest elements of a sorted array A.
*
*Sample dataset: 10
*4 -6 7 8 -9 100 12 13 56 17
*3
*
*Output: -9 -6 4
*
*/

public class PartialSort {


    public static void sort(int vals[], int low, int high) { // Quicksort

        if (low>=high){
            return ;
        }

        int middle = low + (high-low) / 2 ; // Select the middle record
        int pivot = vals[middle] ; // Set the pivot to be the middle record

        int i = low, j = high ;
        while (i<=j){
            while (vals[i] < pivot){ // Move the left bound until it reaches a value greater than the pivot
                i++ ;
            }
            while(vals[j]>pivot){ // Move the right bound until it reaches a value less than the pivot
                j-- ;
            }
            if(i<=j){ // When bounds intersect, swap the selected values
                int temp = vals[i] ;
                vals[i] = vals[j] ;
                vals[j] = temp ;
                i++ ; j-- ;
            }
        }
        if(low<j){
            sort(vals, low, j) ; // Perform Quicksort on the left sublist
        }
        if(high>i){
            sort(vals, i, high) ; // Perform Quicksort on the right sublist
        }
    }
    public static void main(String[] args) {
        In in = new In("rosalind_ps.txt") ;
        int n = in.readInt() ;
        int vals[] = new int[n] ;
        for (int i = 0; i < n; i++) {
            vals[i] = in.readInt() ; // Create an array of the values
        }

        sort(vals, 0, vals.length-1) ; // Perform Quicksort using first record as low, last record as high
        int x = in.readInt() ;
        for(int m=0; m<x; m++) {
            StdOut.print(vals[m] + " "); // Print out the 'x' smallest values
        }
    }
}
