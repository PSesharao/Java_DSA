// https://docs.google.com/document/d/1OCAb20_tmqR3F1euecjQGxE__0gjdfEvdFeoUf2cO3I/edit?tab=t.0

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {

}

class JavaMain {

    private static FastReader in;
    private static FastWriter out ;


    private static int findNoOfWaysToDivideGivenArray_3_parts( int arr[] ) {

        int N = arr.length ; 
        if(N < 3 )
            return 0 ; 

        int sum = 0 ; 
        for(int i=0 ; i<N ; i++)
            sum += arr[i] ; 

        if(sum%3 !=0 )
            return 0 ; 

        int y = sum / 3 ; 

        Map<Integer , Integer> map = new HashMap<>() ;
        int pref_sum = 0 ;
        int ans = 0 ;
        for(int i=0 ; i<N ; i++){
            pref_sum += arr[i] ; 
            if( pref_sum == 2*y )
                ans += map.getOrDefault(y , 0) ; 
            map.put(pref_sum , map.getOrDefault(y , 0)+1 ) ; 
        }
        return ans ; 

    }


    public static void main(String[] args) throws IOException {
        initialize();  
        int arr[] = {1  , 3 , 0 , 4 ,  0 , 3 , 1} ; 
        int ans = findNoOfWaysToDivideGivenArray_3_parts(arr) ; // ans : 4
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
