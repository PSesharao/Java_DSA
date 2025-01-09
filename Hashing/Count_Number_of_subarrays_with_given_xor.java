// https://www.geeksforgeeks.org/count-number-subarrays-given-xor/

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution { 

    public long subarrayXor(int arr[], int k) {
        
        long count = 0 ; 
        int curr_xor = 0  ; 
        Map<Integer , Integer > fmap = new HashMap<>() ; 

        for(int i=0 ; i<arr.length ; i++ ){
            curr_xor = curr_xor ^ arr[i] ; 

            if(curr_xor == k )
                count ++ ; 

            int prev_xor = curr_xor ^ k ;
            if(fmap.containsKey(prev_xor) )
                count += fmap.get(prev_xor) ; 

            fmap.put( curr_xor , fmap.getOrDefault(curr_xor , 0) +1  ) ; 
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
        
        int arr[] = {  4, 2, 2, 6, 4} ;  
        long ans = sol.subarrayXor(arr , 6 ) ;
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
