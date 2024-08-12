// https://docs.google.com/document/d/1BJpAT_0sknZB_IyTKGkHfu-0dLJ0cMfIsenQntoZ3Pk/edit

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Pair {

    private int pref_sum ;
    private int value ;

    public Pair( int pref_sum , int value) {
        this.value = value;
        this.pref_sum = pref_sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return pref_sum == pair.pref_sum && value == pair.value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "pref_sum=" + pref_sum +
                ", value=" + value +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(pref_sum, value);
    }
}

class Solution {
    public int findNumberOfSubarrays(int[] arr ) {

        int n = arr.length ;
        Set<Pair> set = new HashSet<Pair>() ;
        int prefixSum = 0 ;
        int count = 0 ;
        
        for(int i = 0 ; i < n ; i++){

            prefixSum += arr[i] ;   // we need to do this first here 
            // as according to formula we would need to subtract 2*arr[i] 
            // from the prefix sum till arr[i] to check the key

            
            Pair temp = new Pair(prefixSum- 2*arr[i] , arr[i]) ;
            if(set.contains( temp )){
                count ++ ;
            }

            set.add(new Pair(prefixSum, arr[i])) ;
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

        int arr[] = {9 , 3 ,3 ,3 , 9} ;

        out.println(sol.findNumberOfSubarrays(arr)) ;  
        
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
