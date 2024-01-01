// https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/

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
