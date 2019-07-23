public class Fibonacci {
    public static void main(String[] args) {
        int c ;
        c = 0 ;
        In in = new In("rosalind_fibo.txt");
        String number = in.readLine() ;
        int n = Integer.parseInt(number) ;


        if (n==0){
            c = 0 ;
        }
        if (n==1){
            c = 0 ;
        }

        int a = 1 ; int b = 1 ; int counter = 3 ;
        while (counter<=n) {
            c = a + b ;
            a = b ;
            b = c ;
            counter++ ;
        }
        StdOut.print(c);
    }
}
