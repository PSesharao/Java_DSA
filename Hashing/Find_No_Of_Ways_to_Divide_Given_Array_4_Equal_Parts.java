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


    private static int findNoOfWaysToDivideGivenArray_4_parts( int arr[] ) {

        int N = arr.length ; 
        if(N < 4 )
            return 0 ; 

        int sum = 0 ; 
        for(int i=0 ; i<N ; i++)
            sum += arr[i] ; 

        if(sum%4 !=0 )
            return 0 ; 

        int y = sum / 4 ; 

        Map<Integer , Integer> pref_map = new HashMap<>() ;
        int pref_sum = 0 ;
        int pref_count[] = new int[N] ; 
        Arrays.fill(pref_count , 0 ) ; 
        
        for(int i=0 ; i<N ; i++){
            pref_sum += arr[i] ; 
            if( pref_sum == 2*y )
                pref_count[i] = pref_map.getOrDefault(y , 0) ; 
            pref_map.put(pref_sum , pref_map.getOrDefault(y , 0)+1 ) ; 
        }

        Map<Integer , Integer> suf_map = new HashMap<>() ;
        int suf_sum = 0 ;
        int suf_count[] = new int[N] ; 
        Arrays.fill(suf_count , 0 ) ; 

        for(int i=N-1 ; i>=0 ; i--){
            suf_sum += arr[i] ; 
            if( suf_sum == 2*y )
                suf_count[i] = suf_map.getOrDefault(y , 0) ; 
            suf_map.put(suf_sum , suf_map.getOrDefault(y , 0)+1 ) ; 
        }

        int ans = 0 ;
        for(int k=0 ; k<N-1 ;k++ )
            ans += pref_count[k]*suf_count[k+1] ;
        return ans ; 

    }


    public static void main(String[] args) throws IOException {
        initialize();  
        int arr[] = {1 ,0 , 1 , 0 , 1 , 1} ; 
        int ans = findNoOfWaysToDivideGivenArray_4_parts(arr) ; // ans : 4
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
