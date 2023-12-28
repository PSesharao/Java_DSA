
// https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {

    int getPairsCount(int[] arr, int n, int k) {
        
        Map<Integer , Integer> map = new HashMap<>() ;

        int count = 0 ; 

        for(int i=0 ; i<n ; i++ ){

            int curr = arr[i] ; 
            int complement = k - curr ; 

            if(map.containsKey(complement)) {

                // If the complement exists , we can form that many pairs 
                // with the current element to complement.

                count += map.get(complement) ; 
            }

            int cur_freq = map.getOrDefault(curr , 0 ) ; 
            map.put( curr , cur_freq + 1 ) ; 

        }

        return count ;  
    }



    int getPairsCount2(int[] arr, int n, int k) {
        
        Map<Integer , Integer> map = new HashMap<>() ;

        int count = 0 ; 

        for(int i=0 ; i<n ; i++ ){

            int curr = arr[i] ; 
            int cur_freq = map.getOrDefault(curr , 0 ) ; 
            map.put( curr , cur_freq + 1 ) ; 

        }

        for(int i=0 ; i<n ; i++ ){
            int curr = arr[i] ; 
            int complement = k - curr ; 

            int cur_freq = map.getOrDefault(curr , 0 ) ; 
            int complement_freq = map.getOrDefault(complement , 0 ) ; 

            if(curr == complement ) {
                count += ((cur_freq)*(cur_freq-1) / 2 ) ; 
            }else {
                count += ( cur_freq * complement_freq ) ; 
            }

            map.remove(curr) ; 
            map.remove(complement) ; 
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
