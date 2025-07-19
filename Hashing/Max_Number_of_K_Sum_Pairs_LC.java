// https://leetcode.com/problems/max-number-of-k-sum-pairs/
// https://docs.google.com/document/d/10mhea8Ojo3maAkVpYeTKle3sanTz5ESSdXtYPo0p0Fg/edit?tab=t.0

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {
    // public int findNumberOfTriplets( int arr[] ) {

    //     int N = arr.length ; 
    //     int pref[N] ; 


    // }
}


class JavaMain {

    private static FastReader in;
    private static FastWriter out ;
    private static final int MAX = (int) 1e9 ; 

    public static int maxNumberOfKSumPairs( int A[] , int k ) {


        int N = A.length ; 
        int ans = 0 ;
        Map<Integer , Integer > map = new HashMap<>() ; 

        for(int num : A )
            map.put(num , map.getOrDefault(num , 0 )+1  ) ; 
        
        Set<Integer> marked = new HashSet<>() ; 

        for( Map.Entry<Integer , Integer> entry : map.entrySet() ){

            int num = entry.getKey() ; 

            if( !marked.contains(num) ){

                int complement = k - num ; 

                if( map.containsKey(complement) ) {

                    int freq_num = entry.getValue() ; 

                    if( num == complement ){
                        ans += freq_num / 2 ; 
                    }else {

                        int freq_compl = map.get(complement); 
                        ans+= Math.min(freq_num , freq_compl ) ; 
                    }

                    marked.add(num) ; 
                    marked.add(complement) ; 
                }

            }

            
        }

        return ans ;   

    }


    public static void main(String[] args) throws IOException  {
        initialize(); 
        Solution sol = new Solution() ; 
        // String name = in.nextLine() ; 
        int arr[] = { 1,2,3,4 }; 
        int k = 5 ;
        out.println( maxNumberOfKSumPairs(arr , k ) ) ; 
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
