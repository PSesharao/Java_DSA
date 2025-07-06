// https://docs.google.com/document/d/1D4g82GgNWVDpAhk5TaMT65yNbqFtFrbj87jbGvw7_Q4/edit?tab=t.0

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


    private static boolean increasingSubSequenceOfSize3( int arr[] ) {
        int N = arr.length ; 
        int min_prefix[] = new int[N] ;
        int max_suffix[] = new int[N] ;

        min_prefix[0] = arr[0] ; 
        for(int i=1; i<N ; i++){
            min_prefix[i] = Math.min(min_prefix[i-1] , arr[i]) ; 
        }

        max_suffix[N-1] = arr[N-1] ;
        for(int i=N-2 ; i>=0 ; i-- ){
            max_suffix[i] = Math.max(max_suffix[i+1] , arr[i] ) ;
        }

        // i can always be the 
        // middle of the sub sequence
        for(int i=1 ; i<N-1 ; i++ ){   
            if( (min_prefix[i-1] < arr[i]) && (arr[i] < max_suffix[i+1]) )
                return true ;
        }

        return false ; 
    }

    private static boolean increasingSubSequenceOfSize3_( int arr[] ) {
        
        int N = arr.length ; 
        for(int i=0 ; i<N ; i++){
            int count = 1 ;
            int t = arr[i] ;
            for(int j=i+1 ; j<N ; j++){
                if( arr[j] > t ) {
                    count ++ ; 
                    t = arr[j] ; 
                }
                if(count == 3)
                    return true ; 
            }
        }
        return false ; 
    }


    public static void main(String[] args) throws IOException {
        initialize();  
        int arr[] = {18, 5, 4, 3, 2, 1, 8, 10} ; // true 
        // int arr[] = {5 , 4 , 3 , 2 , 1,  8} ; // false
        boolean ans = increasingSubSequenceOfSize3(arr) ;
        out.println(ans) ;
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
