// https://www.codechef.com/START66B/problems/GOODBINSTR

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {

}



class JavaMain {

    private static FastReader in;
    private static FastWriter out ;
    private static final int minVal = Integer.MIN_VALUE + 10 ; 
    private static final int maxVal = Integer.MAX_VALUE - 10 ;

    public static int goodBinaryStrings(int[] A) {
        int N = A.length ; 
        if( A[0] == A[N-1] )
            return N-2 ; 
        else 
            return 2 ;  
    }

    public static void main(String[] args) throws IOException {
        initialize();  
        int arr[] = {1,1,1,1,0} ;
        int ans = goodBinaryStrings(arr) ; // 2
        out.println(ans) ;
        close() ; 
    }

    
    private static void initialize() throws IOException , FileNotFoundException {
        in = new FastReader();
        out = new FastWriter();
    }

    private static void close() throws IOException  {
        in.close();
        out.close();
    }
}
