// https://www.desiqna.in/16227/uber-oa-sde-1-ctc-65-l-jan-2024#google_vignette

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

    private static int findSumOfAllConcatenation( int A[] ) {

        int N = A.length ; 
        int digit_count[] = new int[7] ; 
        Arrays.fill(digit_count , 0 ) ; 
        int sum = 0 ; 
        int ans =0 ; 
        for( int i=0 ; i<N ; i++ )
            sum += A[i] ; 

        for(int i=0 ; i<N ; i++ ){
            int count = getDigitCount(A[i]) ; 
            digit_count[count] ++ ; 
        }

        for( int i=0 ; i<N ; i++ ){

            int num = A[i] ;
            int d = 1 ; 
            while(d <= 6 ){
                int freq = digit_count[d] ; 
                ans += num * freq* (Math.pow(10 , d )) ; 
                d++ ; 
            }

            ans += sum ; 
        }

        return ans ; 
    }

    public static void main(String[] args) throws IOException  {
        initialize(); 
        // Solution sol = new Solution() ; 
        
        int A[] = {10 , 2 } ;  
        out.println(findSumOfAllConcatenation(A)) ; 
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
