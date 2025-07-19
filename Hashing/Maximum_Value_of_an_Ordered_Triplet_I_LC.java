// https://leetcode.com/contest/weekly-contest-365/problems/maximum-value-of-an-ordered-triplet-i/
// https://leetcode.com/contest/weekly-contest-365/problems/maximum-value-of-an-ordered-triplet-ii/
// https://docs.google.com/document/d/10mhea8Ojo3maAkVpYeTKle3sanTz5ESSdXtYPo0p0Fg/edit?tab=t.0

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {

}

class JavaMain {

    private static FastReader in ;
    private static FastWriter out ;
    private static final int minVal = Integer.MIN_VALUE + 10 ; 
    private static final int maxVal = Integer.MAX_VALUE - 10 ;

    public static long maximumTripletValue(int[] nums) {
        
        long ans = 0 ; 
        int N = nums.length ; 
        //long pref[] = new long[N] ; 
        long pref_k_1 ; 
        long max_till_k = Math.max( nums[0] , nums[1] ) ; 
        //pref[1] = nums[0] - nums[1] ; 
        pref_k_1 = nums[0] - nums[1] ;

        for(int k=2 ; k<N ; k++ ){

            ans = Math.max( ans , pref_k_1 * nums[k] ) ;
            pref_k_1 = Math.max( pref_k_1 , max_till_k- nums[k] ) ; 

            max_till_k = Math.max( max_till_k , nums[k] ) ; 

        }

        return ans ; 
    }


    private static int maximumTripletValue_( int A[] ) {

        int N = A.length ; 
        if(N < 3)
            return 0 ; 

        int prefix[] = new int[N] ; 
        Arrays.fill( prefix , 0 ) ;
        prefix[1] = A[0] - A[1] ; 

        for(int x=2 ; x<N ; x++ ){
            int pair_diff = minVal ;
            for(int y=0 ; y<x ; y++)
                pair_diff = Math.max( pair_diff , A[y]-A[x] ) ; 
            prefix[x] = Math.max( prefix[x-1] , pair_diff ) ; 
        }

        int ans = minVal ; 

        for(int k=2 ; k<N ; k++) {
            ans = Math.max(ans , prefix[k-1]*A[k] ) ; 
        }

        return ans ;      

    }



    public static void main(String[] args) throws IOException  {
        initialize(); 
        int arr[] = { 1,10,3,4,19 } ;
        long ans = maximumTripletValue(arr) ; 
        out.println(ans) ; // 133
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
