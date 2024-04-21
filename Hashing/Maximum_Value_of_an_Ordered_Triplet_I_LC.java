// https://leetcode.com/contest/weekly-contest-365/problems/maximum-value-of-an-ordered-triplet-i/
// https://leetcode.com/contest/weekly-contest-365/problems/maximum-value-of-an-ordered-triplet-ii/


import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {

    int countKDifference(int[] arr, int k) {

        int n = arr.length ; 
        
        Map<Integer , Integer> map = new HashMap<>() ;

        int count = 0 ; 

        for(int i=0 ; i<n ; i++ ){

            int curr = arr[i] ; 
            int complement1 = curr - k ; 
            int complement2 = curr + k ;  

            // If the complement exists , we can form that many pairs 
            // with the current element to complement.

            count += map.getOrDefault(complement1 , 0 ) ;  

            count += map.getOrDefault(complement2 , 0 ) ;  

            int cur_freq = map.getOrDefault(curr , 0 ) ; 
            map.put( curr , cur_freq + 1 ) ; 

        }

        return count ;  
    }

}

class JavaMain {

    private static FastReader in;
    private static FastWriter out ;


    public long maximumTripletValue(int[] nums) {
        
        long ans = 0 ; 
        int N = nums.length ; 
        //long pref[] = new long[N] ; 
        long pref_k_1 ; 
        long max_till_k = Math.max( nums[0] , nums[1] ) ; 
        //pref[1] = nums[0] - nums[1] ; 
        pref_k_1 = nums[0] - nums[1] ;

        for(int k=2 ; k<N ; k++ ){

            ans = Math.max( ans , pref_k_1 * nums[k] ) ;
            pref_k_1 = Math.max( pref_k_1 , max_till_k- nums[k] ) ; 

            max_till_k = Math.max( max_till_k , nums[k] ) ; 

        }

        return ans ; 
    }



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
