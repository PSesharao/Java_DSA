// https://www.desiqna.in/15920/microsoft-oa-september-2023-freshers-hiring-sde1-set-115

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {
    // public int findNumberOfTriplets( int arr[] ) {

    //     int N = arr.length ; 
    //     int pref[N] ; 


    // }
}


class JavaMain {

    private static FastReader in;
    private static FastWriter out ;
    private static final int MAX = (int) 1e9 ; 

    public static int findMinimumRehabiliationCost( int A[] , int x , int y ) {

        int N = A.length ; 
        int ans = MAX ; 
        int prefix[] = new int[N] ; 
        Arrays.fill(prefix , 0 ) ; 

        for(int i=0 ; i<N ; i++ ){

            if( i-y >=0 )
                prefix[i] = A[i] + prefix[i-y] ; 
            else 
                prefix[i] = A[i] ; 
        }

        for(int i=0 ; i<N ; i++ ){

            if( i - x*y >=0 ){
                int curr_cost = prefix[i] - prefix[ i - x*y ] ; 
                ans = Math.min(curr_cost , ans ) ; 
            }
        }

        return ans ; 

    }


    public static void main(String[] args) throws IOException  {
        initialize(); 
        Solution sol = new Solution() ; 
        // String name = in.nextLine() ; 
        int A[] = { 1 ,5 ,8, 1 ,4 ,5, 8 }; 
        out.println( findMinimumRehabiliationCost(A , 2 , 2 ) ) ; 
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
