// https://www.desiqna.in/15241/atlassian-sde-interview-coding-problem-2023

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

    public static int maxSum( int A[] , int k ) {
        int N = A.length ; 
        int ans = 0 ;
        Map<Integer , Integer> map = new HashMap<>() ;
        int prev_pref_sum = 0 ; // represents pref[j-1] ongoing 
        int cur_pref_sum = 0 ; //  represents pref[j] ongoing 
        for(int i=0 ; i<N ; i++){
            cur_pref_sum += A[i] ; 
            if( map.containsKey(A[i]+k) || map.containsKey(A[i]-k) ) {
                int last_pref_sum ; // represents pref[i-1]
                if(map.containsKey(A[i]+k))
                    last_pref_sum = map.get(A[i]+k) ; 
                else
                    last_pref_sum = map.get(A[i]-k) ; 
                map.get(A[i]) ; 
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
        int arr[] = { 1 , 5  , -5 , 8 , 8 , 8 , 10 , 15 };
        int k = 5 ; 
        out.println( maxSum(arr , k ) ) ; // 135
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
