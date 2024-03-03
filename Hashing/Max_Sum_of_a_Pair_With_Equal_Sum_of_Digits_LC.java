
// https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 



class Solution {

    public int maximumSum(int[] nums) {
         
        Map<Integer , Integer > map = new HashMap<>() ; 
        int max_sum = -1 ; 

        int len = nums.length ; 

        for(int i=0 ; i<len ; i++ ){

            int curr = nums[i] ; 
            int sum = getSum(curr) ; 

            if(map.containsKey(sum)) {

                int prev = map.get(sum) ; 

                if(prev + curr > max_sum ) {
                    max_sum = prev + curr ; 
                }

                if(curr > prev ) 
                    map.put( sum , curr ) ;  // updating with the max value  

            }else 
                map.put( sum , curr ) ;
        }

        return max_sum ; 
    }

    private int getSum(int num ) {
        int sum =0 ; 
        while(num >0 ) {

            int digit = num %10 ; 
            sum += digit ;  
            num/=10 ; 
        }
        return sum ; 
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
        out.println("Hello Every one , how are you all doing ? ") ; 
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
