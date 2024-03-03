// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        
        Set<Integer> set = new HashSet<>() ; 
        int N = A.length ; 
        int C[] = new int[N] ;
        int count = 0 ;  

        for(int i=0 ; i<N ; i++ ){

            if( A[i] == B[i] ){
                count ++ ; 

// Here we do not need to add it to the Set as the arrays are permutations of each other
// and there is no duplicates also.

            }
            else {


                if(set.contains(A[i]) )
                    count ++ ; 

                if(set.contains(B[i]))
                    count ++ ; 

// We need to add here , as in future we may get this element in another array

                set.add(A[i]) ; 
                set.add(B[i]) ; 

            }

            C[i] = count ; 
        }

        return C ; 

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
