// https://leetcode.com/problems/first-completely-painted-row-or-column/

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        
        Map<Integer , Integer> index_map = new HashMap<>() ; 

        int INF = Integer.MAX_VALUE ; 
        int ans = INF ; 

        for(int i=0 ; i<arr.length ; i++ ){
            index_map.put(arr[i] , i ) ; 
        }

        int R = mat.length ; 
        int C = mat[0].length ; 

        // check for each row
        for(int r=0 ; r< R ; r++ ){
            int max_row_idx = -1 ; 

            for(int j=0 ; j< C ; j++ ){
                max_row_idx = Math.max(max_row_idx , index_map.get(mat[r][j]) ) ; 
            }

            ans = Math.min(ans , max_row_idx ) ; 
        }

        // check for each column 
        for(int j=0 ; j<C ; j++ ){
            int max_col_idx = -1 ;

            for(int r=0 ; r<R ; r++ ){
                max_col_idx = Math.max(max_col_idx , index_map.get(mat[r][j]) ) ; 
            }

            ans = Math.min(ans , max_col_idx ) ;  
        }


        return ans ; 

    }
}

class JavaMain {

    private static FastReader in;
    private static FastWriter out ;

    public static void main(String[] args) throws IOException  {
        initialize(); 
        Solution sol = new Solution() ; 
        String name = in.nextLine() ; 
        out.println(name) ; 
        out.println(sol.greetUser(name)) ;  
        out.println("How are you all doing ? ") ; 
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
