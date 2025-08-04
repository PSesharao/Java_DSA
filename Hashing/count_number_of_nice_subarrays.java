// https://leetcode.com/problems/count-number-of-nice-subarrays/

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
    private static final int minVal = Integer.MIN_VALUE + 10 ; 
    private static final int maxVal = Integer.MAX_VALUE - 10 ;

    public static int numberOfSubarrays(int[] nums, int k) {
        int N = nums.length ; 
        int A[] = new int[N] ; // for storing binary values 0 even 1 odd
        for(int i=0 ; i<N ; i++)
            A[i] = nums[i] %2 ;

        Map<Integer , Integer> map = new HashMap<>() ; 
        int ans = 0;
        int pref_sum = 0 ;
        for(int i=0 ; i<N ; i++){

            pref_sum += A[i] ; 

            if(pref_sum == k )
                ans ++ ; 

            if(map.containsKey(pref_sum-k))
                ans += map.get(pref_sum-k);

            map.put(pref_sum , map.getOrDefault(pref_sum , 0) + 1) ;
        }
        return ans ; 
    }

    public static void main(String[] args) throws IOException {
        initialize();  
        int arr[] = {2,2,2,1,2,2,1,2,2,2} ;
        int k =2 ;
        int ans = numberOfSubarrays(arr , k ) ; 
        out.println(ans) ;
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
