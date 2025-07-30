// https://docs.google.com/document/d/1Y64Xw5WeW6-UYXXuu75_w7_AQU9tlqYdvhGfHc7-XqU/edit?tab=t.0

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

    public static int maxSum( int A[] ) {
        int N = A.length ; 
        int ans = 0 ;
        Map<Integer , Integer> map = new HashMap<>() ;
        int prev_pref_sum = 0 ; // represents pref[j-1] ongoing 
        int cur_pref_sum = 0 ; //  represents pref[j] ongoing 
        for(int i=0 ; i<N ; i++){
            cur_pref_sum += A[i] ; 
            if( map.containsKey(A[i]) ) {
                int last_pref_sum = map.get(A[i]) ; // represents pref[i-1]
                ans = Math.max(cur_pref_sum - last_pref_sum , ans ) ; 
                if( prev_pref_sum < last_pref_sum )
                    map.put(A[i] , prev_pref_sum ) ; // update key 
            }else // If we do not place it in else block 
                map.put(A[i] , prev_pref_sum ) ; // it'll always override above set value.
            prev_pref_sum = cur_pref_sum ; 
        }
        return ans ;   
    }


    public static void main(String[] args) throws IOException  {
        initialize(); 
        Solution sol = new Solution() ; 
        // String name = in.nextLine() ; 
        int arr[] = { 15 , -10 , 15 , 100 , 15 , -1000 , 15  }; 
        out.println( maxSum(arr) ) ; // 135
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
