// https://www.geeksforgeeks.org/count-quadruplets-with-sum-k-from-given-array/

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

    public static int findNumberOfQuadraplets1( int A[] , int sum )  {

        int N = A.length ; 
        int count = 0 ; 
        // All possible first elements
        for(int i=0 ; i<N-3 ; i++  ){

            // All possible second element
            for(int j= i+1 ; j<N-2 ; j++ ){

                Map<Integer, Integer> map = new HashMap<>();

                // All possible third and fourth elements
                for( int k = j+1; k<N ; k++ ){

                    int freq = map.getOrDefault( A[k] , 0 ) ; 
                    map.put( A[k] , freq + 1 ) ; 

                }

                for( int k = j+1; k<N ; k++ ){

                    int req = sum - (A[i] + A[j] + A[k]) ; 
                    count += map.getOrDefault( req , 0 ) ; 

                    if( req == A[k] )
                        count -- ; 
                }
            }
        }

        return count /2 ; 

    }

    public static int findNumberOfQuadraplets( int A[] , int sum ) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int N = A.length ; 
        int count = 0 ; 
        

        for(int i=0 ; i<N-1 ; i++ ){

            // for last 2 elements 
            for(int j=i+1 ; j<N ; j++ ){

                int req = sum - (A[i] +  A[j]) ;
                if( req > 0 ) // only for +ve elements 
                    count += map.getOrDefault(req , 0 ) ;  
            }

            // for first 2 elements 
            for(int j=0 ; j<i ; j++ ){

                int s = (A[i] +  A[j]) ; 
                if( s < sum  ) {
                    int freq = map.getOrDefault( s , 0 ) ; 
                    map.put(s , freq + 1 ) ; 
                }
            }
        }

        return count ; 

    }

    public static void main(String[] args) throws IOException  {
        initialize(); 
        Solution sol = new Solution() ; 
        // String name = in.nextLine() ; 
        int arr[] = { 4, 5, 3, 1, 2, 4 }; 
        out.println( findNumberOfQuadraplets(arr , 13 ) ) ; 
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
