// https://www.desiqna.in/15111/intuit-oa-sde1-2023-may
// https://docs.google.com/document/d/1cg-Z-jGL2HVjCdaxd_aq5GP2JUfuVpWLu-YKx6_nQtY/edit?tab=t.0

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

    private static int countPairs(int A[] , int k ) {
        int ans = 0 ; 
        int len = A.length ; 
        Map<Integer , Integer> map = new HashMap<>() ; 
        for( int i=0 ; i<len ; i++ )
            map.put( A[i] , map.getOrDefault(A[i] , 0)+1 ); 
        Set<Integer> visited = new HashSet<>() ; 

        for( Map.Entry<Integer , Integer> entry : map.entrySet() ) {
            int a = entry.getKey() ; 
            if( !visited.contains(a) ) {
                int b = a + k ; 
                if(map.containsKey(b)) {
                    int freq_a = map.get(a) ; 
                    int freq_b = map.get(b) ; 
                    if( a == b )
                        ans += freq_a/2 ; 
                    else
                        ans += Math.min( freq_a , freq_b ) ; 
                }
                visited.add(a) ; 
                visited.add(b) ; 
            }
        }

        return ans ;
    }

    public static void main(String[] args) throws IOException  {
        initialize(); 
        int arr[] = {1,1,1,2 } ;  
        int k = 1 ;  
        int ans = countPairs( arr , k ) ;
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
