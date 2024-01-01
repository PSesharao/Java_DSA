// https://leetcode.com/problems/subarray-sum-equals-k/

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {

    public int subarraySum(int[] nums, int k) {

        int count = 0 ; 
        int cur_sum = 0 ; 
        int N = nums.length ; 

        Map<Integer , Integer > sum_freq_map = 
        new HashMap<>() ; 

        for(int i=0 ; i<N ; i++ ){

            cur_sum += nums[i] ; 

            if(cur_sum == k ) {
                count ++ ; 
            }

            int complement_sum = cur_sum - k ; 

            // This check should be always done , even in case of 
            // cur_sum == k  , as in such case we can look for 0 in initial part 
            // of array , that's why not placing this in else block.

            if( sum_freq_map.containsKey(complement_sum) ){

                int complement_sum_freq = sum_freq_map.get(complement_sum) ; 
                count += complement_sum_freq ; 
            }

            sum_freq_map.put(cur_sum , sum_freq_map.getOrDefault(cur_sum , 0 )+1 ) ; 

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
        
        int arr[] = {1 , 4 , 1 , 3 , 2 , 2 } ;  
        int k = 5 , n = 6 ; 

        int ans = sol.getPairsCount2(arr , n , k) ;
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
