// https://www.desiqna.in/16087/media-net-oa-sde1-ctc-28-l

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

    private static int countNoOfPairs(int arr[] , int target ){
    
        if(target % 2 == 1)
            return 0 ;

        int N = arr.length;
        int val = target/2 ;
        int val_count = 0 ; 
        int val_less_count = 0 ;

        for(int i=0 ; i<N ; i++){
            if(  Math.abs(arr[i]) < val )
                val_count ++ ; 
            if( Math.abs(arr[i]) == val )
                val_less_count ++ ; 
        }

        return (val_count*(val_count-1)/2) + (val_count*val_less_count) ; 
    }

    public static void main(String[] args) throws IOException  {
        initialize(); 
        // Solution sol = new Solution() ; 
        int nums[] = {2, -2, 1, 0, 3} ; 
        int target = 4 ; 
        // out.println(sol.maxSumSelection( nums , k  )) ;  
        int ans = countNoOfPairs(nums , target ) ;
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
