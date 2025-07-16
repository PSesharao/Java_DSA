// https://www.desiqna.in/16227/uber-oa-sde-1-ctc-65-l-jan-2024#google_vignette
// https://docs.google.com/document/d/1XZoJmdgOItz1I6m8xnmSWCSPMvhj34Rv8fb_Hj0GyY0/edit?tab=t.0

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
        if(N ==0 )
            return 0 ;

        int sum = 0;
        for(int i=0 ; i<N ; i++)
            sum+= A[i];

        int len_freq[] = new int[7] ;// as the max possible len of num does not exceed 6
        Arrays.fill(len_freq , 0);

        for(int i=0 ; i<N ; i++){
            int l = getDigitCount(A[i]) ;
            len_freq[l]++ ;
        }

        // precalculate the power sum as this would need to be multipled with every number 
        int pow_sum = 0 ; 
        for(int j=1 ; j<=6 ; j++)
            // 10 raised to j(len of num) multiplied with it's frequency. 
            pow_sum += len_freq[j]*Math.pow( 10 , j ) ; 

        return ( sum * pow_sum ) + (N*sum) ; 
   }

    private static int findSumOfAllConcatenation_( int A[] ) {

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
        out.println(findSumOfAllConcatenation(A)) ; // 1344
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
