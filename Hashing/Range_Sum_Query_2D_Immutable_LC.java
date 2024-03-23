// https://leetcode.com/problems/range-sum-query-2d-immutable/

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 



class NumMatrix {
    
    private int[][] area ;  

    public NumMatrix(int[][] matrix) {
        
        int R = matrix.length ; 
        int C = matrix[0].length ; 
        area = new int[R+1][C+1] ; 

        // fill the first col with 0
        for(int r=0 ; r<=R ; r++ ){
            area[r][0] = 0 ; 
        }

        // fill the first row with 0
        for(int c=0 ; c<=C ; c++ ){
            area[0][c] = 0 ; 
        }

        for(int r=1 ; r<=R ; r++ ){
            for(int c=1 ; c<=C ; c++ )
            {
                int top = area[r-1][c] ;
                int left = area[r][c-1] ; 
                int overlap = area[r-1][c-1] ; 
                int curr = matrix[r-1][c-1] ; 
                area[r][c] = top + left - overlap + curr ; 
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {

        int overall = area[row2+1][col2+1] ;
        int top = area[row1][col2+1] ; 
        int left = area[row2+1][col1] ; 
        int diagonal = area[row1][col1] ; 
        return overall - top - left + diagonal ; 
        
    }


}


class JavaMain {

    private static FastReader in;
    private static FastWriter out ;

    public static void main(String[] args) throws IOException  {

        initialize(); 

        Solution sol = new Solution() ; 

        //int size = in.nextInt() ;
        
        // int nums[] = new int[size] ;

        String[] words = {"bella","label","roller"}  ; 
        out.println(sol.commonChars(words)) ;  
        
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
