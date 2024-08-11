
// https://docs.google.com/document/d/19QBr6ahoVh3himYXB6Fd0JscC6yhjV9qLyt2fGpdLhk/edit

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {

    
    int[] largestSubArraySumAtEndingEachIndex( int[] arr ) {
        
        int n = arr.length ; 
        int[] prefix = new int[n] ;     
        Arrays.fill(prefix , 0);
        prefix[0] = arr[0] ; 

        for(int i=1 ; i<n ; i++ )
            prefix[i] = Math.max( arr[i] + prefix[i-1] , arr[i] ) ; 
        
        return prefix ; 
    }

}

class JavaMain {

    private static FastReader in;
    private static FastWriter out ;

    public static void main(String[] args) throws IOException  {
        initialize(); 
        Solution sol = new Solution() ; 
        int arr[] = { 5 , -8 , 1 , 1 , 5 } ; 
        int[] ans = sol.largestSubArraySumAtEndingEachIndex( arr ) ;
        out.println( Arrays.toString(ans) ) ; 
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
