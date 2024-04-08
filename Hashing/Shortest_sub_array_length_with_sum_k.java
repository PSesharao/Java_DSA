// https://docs.google.com/document/d/1HwqRB-dQZXKlHlpn-2KLqyrWDbYEZ4gD7uskSEQUUcM/edit

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

    public static int findShortestSubArrayWithSumK( int A[] , int k ) {

        int N = A.length ; 
        int ans = MAX ; 

        Map<Integer , Integer > map = new HashMap<>() ; 
        
        for(int i=0 ; i<N ; i++ ){

            int req = k - A[i] ; 

            if(map.containsKey(req)){

                int j = map.get(req) ; 
                int cur_len = (i - j) + 1 ; 
                ans = Math.min(ans , cur_len ) ; 
            }

            map.put(A[i] , i ) ; // Irrespective of anything 
            // we should always update with largest index as we want min length
        }

        return ans ; 
    }

    public static int findLongestSubArrayWithSumK( int A[] , int k ) {

        int N = A.length ; 
        int ans = -1 ; 

        Map<Integer , Integer > map = new HashMap<>() ; 
        
        for(int i=0 ; i<N ; i++ ){

            int req = k - A[i] ; 

            if(map.containsKey(req)){

                int j = map.get(req) ; 
                int cur_len = (i - j) + 1 ; 
                ans = Math.max(ans , cur_len ) ; 
            }

            if(! map.containsKey(A[i]))
                map.put(A[i] , i ) ; // We'll only insert if it is new key to the map
        }

        return ans ; 
    }

    public static void main(String[] args) throws IOException  {
        initialize(); 
        Solution sol = new Solution() ; 
        // String name = in.nextLine() ; 
        int arr[] = { 7 , 5 , 6 ,7, 8, 10, 4 ,3, 2, 1 }; 
        int k = 8 ;
        out.println( findLongestSubArrayWithSumK(arr , k ) ) ; 
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
