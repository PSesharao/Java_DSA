
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
        int[] suffix1 = new int[n] ; 
        int[] suffix2 = new int[n] ; 
        int[] max_suff = new int[n] ; 

        Arrays.fill(prefix , 0) ;
        Arrays.fill(suffix1 , 0) ;
        Arrays.fill(suffix2 , 0) ;
        Arrays.fill(max_suff , 0) ;

        prefix[0] = arr[0] ; 
        
    

        for(int i=1 ; i<n ; i++ )
            prefix[i] = Math.max( arr[i] + prefix[i-1] , arr[i] ) ; 

        suffix1[n-1] = arr[n-1] ; 
        suffix2[n-1] = arr[n-1] ; 
        for(int i=n-2 ; i>=0 ; i-- ){

            if( arr[i] < arr[i+1] )
                suffix1[i] = arr[i] + suffix1[i+1] ; 
            else 
                suffix1[i] = arr[i] ; 

            suffix2[i] = Math.max( suffix1[i] , arr[i] ) ; // This is the step to 
            // check if streak sum is better or the current element 
            //(-ve elements scenario like [-2 , -1 , 10] )
            
        }

        max_suff[n-1] = suffix2[n-1] ;
        for(int i=n-2 ; i>=0 ; i-- )
            max_suff[i] = Math.max(max_suff[i+1] , suffix2[i] ) ; 

        int ans = 0 ; 

        for(int i=0 ; i<n-1 ; i++ )
            ans = Math.max(prefix[i] + max_suff[i+1] , ans ) ;

        
        return ans ;        
    }


}

class JavaMain {

    private static FastReader in;
    private static FastWriter out ;

    public static void main(String[] args) throws IOException  {
        initialize(); 
        Solution sol = new Solution() ; 
        int arr[] = { 8, -800, 5 , 10 , 1  } ; 
        int ans = sol.maxNonOverlappingSumStrictlyIncreasing( arr ) ;
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
