// https://docs.google.com/document/d/1enINelZDWXi3ZLSLH5jbN-zXCzcWnrXFQ0RRUhJl6PY/edit

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {
    
    public static final int INF = (int) 1e9; 
    public int shortestSubArrayCount(int arr[] , int k ) {

        int min_length = INF ; 
        int N = arr.length ;
        System.out.println(N) ;
        int sum = 0 ;
        Map<Integer , Integer> map = new HashMap<>() ; 

        for(int i=0 ; i < N ; i ++ ){

            sum+= arr[i] ; 

            if(sum == k ) {
                min_length = Math.min( min_length , i+1 ) ; 
            }

            if( map.containsKey(sum - k ) ){
                int prev = map.get(sum - k ) ; 
                min_length = Math.min( min_length , i-prev ) ;
            }

            map.put(sum , i ) ; 
        }
        
        if( min_length == INF )
            return -1 ; 
        
        // Sliding window 
        int window_len = min_length ; 

        int l , r , count , s; 
        l=r=count= s= 0 ; 

        while(r < N) {

            s+= arr[r] ;

            if( r-l +1 < window_len )
                r++ ; 

            else if(r-l +1 == window_len) {

                if(s == k ) count ++ ; 
                // sliding the frame by 1 unit to the left 
                s-= arr[l] ; 
                l++ ; 
                r++ ; 
                // This shall give the count of inclusive sets 
                // like for 5 ,10, 5 , will get ans as 2 [{5,10} , {10,5}]
            }

        }

        return count ; 
    }
}

class JavaMain {

    private static FastReader in;
    private static FastWriter out ; 

    public static void main(String[] args) throws IOException {
        initialize(); 
        int arr[] = {5 ,10, 5 ,2,7,1,9,8,7} ; 
        int k = 15 ;
        Solution sol = new Solution() ; 
        int ans = sol.shortestSubArrayCount(arr , k) ; 
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
