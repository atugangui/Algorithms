/**
*For each array A[1..n], output three different indices 1≤p<q<r≤n such that 
*A[p]+A[q]+A[r]=0 if exist, and "-1" otherwise.
*
*Sample dataset: 4 5
*2 -3 4 10 5
*8 -6 4 -2 -8
*-5 2 3 2 -4
*2 4 -5 6 8
*
*Output: -1
*1 2 4
*1 2 3
*-1
*/

import java.util.Arrays;
import java.util.Comparator;
import java.io.FileNotFoundException;

public class ThreeSum {

    public static void sort(int arr[][])
    {
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(final int[] val1,
                               final int[] val2) {
                if (val1[0] > val2[0])
                    return 1;
                else
                    return -1;
            }
        });
    }

    public static void triple(int vals, int[][] arr) {
        sort(arr);
        for(int i = 0; i < vals-1; i++) {
            int a = arr[i][0];
            int orig = i+1;
            int end = vals-1;
            while(orig < end) {
                int b = arr[orig][0];
                int c = arr[end][0];
                if((a+b+c) == 0 ) {
                    int[] answer = {arr[i][1] + 1, arr[orig][1] + 1, arr[end][1] + 1};
                    Arrays.sort(answer);
                    StdOut.println(answer[0] + " " + answer[1] + " " + answer[2]);
                    return;
                }
                else if ((a+b+c) > 0) { end--;}
                else {orig++; }
            }

        }
        StdOut.println(-1);
    }

    public static void main(String[] args) throws FileNotFoundException {
        In in = new In("rosalind_3sum.txt");
        int rows = in.readInt();
        int vals = in.readInt();
        for(int i = 0; i < rows; i++) {
            int[][] arr = new int[vals][2];
            for (int j = 0; j < vals; j++) {
                arr[j][0] = in.readInt();
                arr[j][1] = j;
            }
            triple(vals, arr);
        }
    }
}
