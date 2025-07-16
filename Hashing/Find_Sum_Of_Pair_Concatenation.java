// https://docs.google.com/document/d/1taIf64o4VlUOsPXqt8wG--OpsOSo-xyWE0MupwLf4Ck/edit?tab=t.0

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

    private static int getDigitCount(int num ) {

        int count =0 ;
        while(num >0 ){
            count ++ ; 
            num/=10 ; 
        }
        return count ; 

    }

    private static int findSumOfPairConcatenation( int A[] ) {

        int N = A.length ; 
        if(N == 0)
            return 0 ;

        int ans = 0 ;
        int sum = 0 ; // represents the sum till before index j

        sum += A[0] ;
        // we are starting j from 1 as to make pair we need to have atleast 1 number before
        for(int j=1 ; j<N ; j++ ) 
        {
            int l = getDigitCount(A[j]) ;
            ans += ( sum * Math.pow(10 , l) ) + (A[j] * j); // j represents no of numbers before j (0 based indexing)
            sum += A[j] ;
        }
        return ans ; 
    }

    public static void main(String[] args) throws IOException  {
        initialize(); 
        // Solution sol = new Solution() ; 
        
        int A[] = {10 , 20 , 30 } ;  
        out.println(findSumOfPairConcatenation(A)) ; 
        close() ; 
    }

    
    private static void initialize() throws IOException , FileNotFoundException{
        in = new FastReader();
        out = new FastWriter();
    }

    private static void close() throws IOException  {
        in.close();
        out.close();
    }
}
