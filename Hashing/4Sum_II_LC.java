// https://leetcode.com/problems/4sum-ii/

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        int count = 0 ; 
        // Prepare Map

        Map<Integer , Integer > map = new HashMap<>() ; 

        for(int i=0 ; i<nums3.length ; i++ ){

            for(int j=0 ; j<nums4.length ; j++ ){

                int sum = nums3[i] + nums4[j] ; 
                int freq = map.getOrDefault(sum , 0 ) ;
                map.put(sum , freq +1 ) ;  
            }
        }

        // Loop through first 2 arrays 

        for(int i=0 ; i<nums1.length ; i++ ){

            for(int j=0 ; j<nums2.length ; j++ ){

                int sum = nums1[i] + nums2[j] ; 
                count += map.getOrDefault( -(sum) , 0 ) ; 
            }
        }

        return count ; 

    }
}


class JavaMain {

    private static FastReader in;
    private static FastWriter out ;

    public static void main(String[] args) throws IOException  {
        initialize(); 
        int[] nums1 = {1, 0, -1, 2} ; 
        int[] nums2 = {-1, 0, 1, -2}; 
        int[] nums3 = {0, 0, 1, -1};
        int[] nums4 = {0, 0, 1, -1}; 
        int ans  = fourSumCount( nums1 , nums2 , nums3 , nums4 ) ; // Op : 52
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
