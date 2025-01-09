// https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution{
    
   
    public int longestSubArrayWithSumK(int[] A , int k ) {

        int len = A.length ; 
        int ans = 0 ; 
        int curr_sum = 0 ; 
        Map<Integer , Integer > map = new HashMap<>() ;  
        for(int i=0 ; i<len ; i++){
            curr_sum += A[i] ; 
            if(curr_sum == k ){
                ans = Math.max(ans ,i+1) ; 
            }else if( map.containsKey(curr_sum-k) ){
                int j = map.get(curr_sum-k) ;
                ans = Math.max( ans , i-j ) ; 
            }
            if(!map.containsKey(curr_sum))
                map.put( curr_sum , i ) ; 
        }
        return ans ; 

    }
    
    
}

class JavaMain {

    private static FastReader in;
    private static FastWriter out ;

    public static void main(String[] args) throws IOException  {
        initialize(); 
        Solution sol = new Solution() ; 
        
        int arr[] = {10, 5, 2, 7, 1, 9} ;  
        int k = 15 ; 

        int ans = sol.longestSubArrayWithSumK(arr , k) ;
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
