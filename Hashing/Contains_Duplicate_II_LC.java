// https://leetcode.com/problems/contains-duplicate-ii/ 

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {
    public boolean 
    containsNearbyDuplicate(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>() ; 

        for(int curr_idx = 0 ; curr_idx < nums.length ; curr_idx++){

			if( map.containsKey(nums[curr_idx]) ) {

				int prev_idx = map.get(nums[curr_idx]) ;

				if( (curr_idx - prev_idx) <=k  ){
					return true ; 
				}

			}

			map.put(nums[curr_idx] , curr_idx ) ; 
		}

		return false ; 

    }
}

class JavaMain {

    private static FastReader in;
    private static FastWriter out ;

    public static void main(String[] args) throws IOException  {

        initialize(); 

        Solution sol = new Solution() ; 

        int size = in.nextInt() ;
        
        int nums[] = new int[size] ;

        for(int i=0 ; i<size  ; i++ ) {
        	nums[i] = in.nextInt() ; 
        }
 
        out.println(sol.containsNearbyDuplicate( nums , 3 )) ;  
        
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
