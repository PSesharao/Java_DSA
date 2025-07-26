
// https://docs.google.com/document/d/19QBr6ahoVh3himYXB6Fd0JscC6yhjV9qLyt2fGpdLhk/edit

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {

    int maxNonOverlappingSumStrictlyIncreasing( int[] arr ) {
        int n = arr.length ; 
        int[] prefix = new int[n] ;  
        int[] suffix = new int[n] ; 
        int[] max_suff = new int[n] ; 

        Arrays.fill(prefix , 0) ;
        Arrays.fill(suffix , 0) ;
        Arrays.fill(max_suff , 0) ;

        prefix[0] = arr[0] ; 
        for( int i=1 ; i<n ; i++ )
            prefix[i] = Math.max( arr[i] + prefix[i-1] , arr[i] ) ; 

        suffix[n-1] = arr[n-1] ; 
        for( int i=n-2 ; i>=0 ; i-- ){

            if( arr[i+1] > arr[i] )
                suffix[i] = Math.max( arr[i] + suffix[i+1] , arr[i] ) ; 
            else 
                suffix[i] = arr[i] ; 
        }

        max_suff[n-1] = suffix[n-1] ;
        for( int i=n-2 ; i>=0 ; i-- )
            max_suff[i] = Math.max( max_suff[i+1] , suffix[i] ) ; 

        int ans = 0 ; 
        for( int i=0 ; i<n-1 ; i++ )
            ans = Math.max( prefix[i] + max_suff[i+1] , ans ) ;
        return ans ;        
    }
}

class JavaMain {

    private static FastReader in;
    private static FastWriter out ;

    public static void main(String[] args) throws IOException  {
        initialize(); 
        Solution sol = new Solution() ; 
        int arr[] = { -2 , -1 , 10 } ; 
        int ans = sol.maxNonOverlappingSumStrictlyIncreasing(arr) ;
        out.println( ans ) ; 
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
