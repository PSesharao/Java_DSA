// https://docs.google.com/document/d/1ndmwNjcfyY3kTTou4-olNLki34aBg6xpgBXgxkz_PWk/edit?tab=t.0

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

    public static int numberOfPairs( int A[] , int k ) {
        int N = A.length ; 
        int ans = 0 ;
        Map<Integer , Integer> map = new HashMap<>() ;
        for(int i=0 ; i<N ; i++){
            int val = A[i]%k ; 
            ans += map.getOrDefault( k-val , 0 ) ;
            map.put( val , map.getOrDefault(val , 0)+1 );
        }
        return ans ;   
    }


    public static void main(String[] args) throws IOException  {
        initialize(); 
        Solution sol = new Solution() ; 
        // String name = in.nextLine() ; 
        int arr[] = { 5,2,3,1, 1 }; 
        int k = 3 ;
        out.println( numberOfPairs(arr , k ) ) ; // 4 
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
