// https://www.desiqna.in/16087/media-net-oa-sde1-ctc-28-l

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {
    public int maxSumSelection( int arr[] , int k ) {

        int max_sum = 0 ;

        int N = arr.length ; 
        int pre_fix_sum[] = new int[N] ; 
        int suffix_sum[] = new int[N] ;

        pre_fix_sum[0] = arr[0] ; 
        for( int i=1 ; i<N ; i++ )
            pre_fix_sum[i] += pre_fix_sum[i-1] + arr[i] ; 

        suffix_sum[N-1] = arr[N-1] ; 
        for( int i=N-2 ; i>=0 ; i-- )
            suffix_sum[i] += suffix_sum[i+1] + arr[i] ; 

        
        for( int i=0 ; i<=k ; i++ ) {
            int l = i-1 , r = N-k+i ;
            int curr  ; 
            if(l == -1)
                curr = suffix_sum[r] ; 
            else if(r == N )
                curr = pre_fix_sum[l] ; 
            else curr = pre_fix_sum[l] + suffix_sum[r] ; 
            max_sum = Math.max(curr , max_sum ) ; 
        }

        return max_sum ; 
    }
}


    // brute force
    private static int findMaxSum_bf( int arr[] , int k ) {
        
        int N = arr.length ; 
        int max_sum = minVal ; 

        for(int s=0 ; s<=k ; s++) {         // s --> represents how many elements that we have taken from the left part
            int curr_sum = 0 ;

            // left side part sum
            for( int l=0 ; l<s ; l++ )
                curr_sum += arr[l] ; 

            // right side part sum
            for( int r=N-k+s ; r<N ; r++ )
                curr_sum += arr[r] ; 

            max_sum = Math.max(curr_sum , max_sum ) ; 
        }

        return max_sum ; 
    }


    // best approach
    private static int findMaxSum_op( int arr[] , int k ) {

        int N = arr.length ; 
        int max_sum = minVal ; 

        int [] pref_sum = new int[N] ; 
        int [] suff_sum = new int[N] ; 

        Arrays.fill(pref_sum , 0 ) ; 
        Arrays.fill(suff_sum , 0 ) ; 

        pref_sum[0] = arr[0] ; 

        for( int l=1 ; l<N ; l++ )
            pref_sum[l] = pref_sum[l-1]+ arr[l] ;

        suff_sum[N-1] = arr[N-1] ; 

        for( int r=N-2 ; r>=0 ; r-- )
            suff_sum[r] = suff_sum[r+1] + arr[r] ;

        for( int s=0 ; s<=k ; s++ ) { 

            int l = s-1 , r = N-k+s ; 
            int left_sum , right_sum  ;

            if(l == -1)
                left_sum = 0 ; 
            else
                left_sum = pref_sum[l] ; 

            if(r == N)
                right_sum = 0 ;
            else
                right_sum = suff_sum[r] ; 

            int curr_sum = left_sum + right_sum ; 
            max_sum = Math.max(curr_sum , max_sum ) ; 
        }

        return max_sum ; 

    }

class JavaMain {

    private static FastReader in;
    private static FastWriter out ;

    public static void main(String[] args) throws IOException  {

        initialize(); 

        Solution sol = new Solution() ; 
        
        int nums[] = {5, -2, 3, 1, 2} , k =3  ; 

        out.println(sol.maxSumSelection( nums , k  )) ;  
        
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
