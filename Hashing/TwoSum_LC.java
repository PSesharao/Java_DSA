// https://leetcode.com/problems/two-sum/

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {

    public int[] twoSum(int[] nums, int target) {
        
        int ans[] = new int[2] ; 
        Map<Integer , Integer > map = new HashMap<>() ; 

        for(int i=0 ; i<nums.length ; i++ ) {

            int curr = nums[i] ; 
            int remaining = target-curr ; 

            if(map.containsKey(remaining)) {

                int curr_idx = i ; 
                int remaining_idx = map.get(remaining) ; 
                ans[0] = curr_idx ; 
                ans[1] = remaining_idx ; 
                return ans ; 

            }

            map.put(curr , i ) ; 
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
        String name = in.nextLine() ; 
        out.println(name) ; 
        out.println(sol.greetUser(name)) ;  
        out.println("How are you all doing ? ") ; 
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
