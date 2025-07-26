
// https://docs.google.com/document/d/19QBr6ahoVh3himYXB6Fd0JscC6yhjV9qLyt2fGpdLhk/edit

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {

    int maxNonOverlappingSum( int[] arr ) {
        
        int n = arr.length ; 
        int[] prefix = new int[n] ;  
        int[] suffix = new int[n] ;     
        Arrays.fill(prefix , 0) ;
        Arrays.fill(suffix , 0) ;
        prefix[0] = arr[0] ; 
        suffix[n-1] = arr[n-1] ; 

        for(int i=1 ; i<n ; i++ )
            prefix[i] = Math.max( arr[i] + prefix[i-1] , arr[i] ) ; 

        for(int i=n-2 ; i>=0 ; i-- )
            suffix[i] = Math.max( arr[i] + suffix[i+1] , arr[i] ) ; 

        int ans = 0 ; 

        for(int i=0 ; i<n-1 ; i++ ){

            int max_suff = Integer.MIN_VALUE ;
            
            for(int j=i+1 ; j<n ; j++ )
                max_suff = Math.max( suffix[j] , max_suff ) ; 

            ans = Math.max(prefix[i] + max_suff , ans ) ;

        }

        return ans ;        
    }


    int maxNonOverlappingSum2_better ( int[] arr ) {
        
        int n = arr.length ; 
        int[] prefix = new int[n] ;  
        int[] suffix = new int[n] ; 
        int[] max_suff = new int[n] ; 

        Arrays.fill(prefix , 0) ;
        Arrays.fill(suffix , 0) ;
        Arrays.fill(max_suff , 0) ;
        prefix[0] = arr[0] ; 
        suffix[n-1] = arr[n-1] ; 
        max_suff[n-1] = suffix[n-1] ;

        for(int i=1 ; i<n ; i++ )
            prefix[i] = Math.max( arr[i] + prefix[i-1] , arr[i] ) ; 

        for(int i=n-2 ; i>=0 ; i-- )
            suffix[i] = Math.max( arr[i] + suffix[i+1] , arr[i] ) ; 

        for(int i=n-2 ; i>=0 ; i-- )
            max_suff[i] = Math.max(max_suff[i+1] , suffix[i] ) ; 

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
        int arr[] = { 5 , -8 , 1 , 1 , 5 } ; // o/p : 12 
        int ans = sol.maxNonOverlappingSum2_better( arr ) ;
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
