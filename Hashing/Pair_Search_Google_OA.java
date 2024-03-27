// https://www.desiqna.in/13820/google-oa-sde2-jan-2023

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {
    public int pairSearch( int[] arr ) {

        Map<Integer , Integer > freq = 
        new HashMap<>() ; 
        int N = arr.length -1 ; 

        int count = 0 ;
        for(int i=1 ; i<= N ; i++ ){   // 1 based indexing

            // Assume that you are at index j now , you need to know 
            // how may i's exists before j , matching the condtion.

            int curr_freq = freq.getOrDefault( arr[arr[arr[i]]] , 0 ) ; 

            count += curr_freq ; 

            // Updating frequency for the future j 
            freq.put(arr[arr[arr[i]]]  , curr_freq+1 ) ; 

        }

        return count ; 

    }
}

class JavaMain {

    private static FastReader in;
    private static FastWriter out ;

    public static void main(String[] args) throws IOException  {

        initialize(); 

        Solution sol = new Solution() ; 

        //int size = in.nextInt() ;
        
        // int nums[] = new int[size] ;
        int arr[] = { 0 , 4 , 2 , 1 , 2 } ; // 1 based indexing
 
        out.println(sol.pairSearch( arr )) ;  
        
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
