// https://docs.google.com/document/d/1Vo7ClwGzUrNtg-J895Gpt5pSkF8C5qxU_MEBw3SrXco/edit?tab=t.0

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


    private static int[] sumOfMatchingCharacters( String arr[] ) {

        int N = arr.length ; 
        int lenS = 10001 ; // avg length of string in the array.
        int mat[][] = new int[26][lenS] ; 
        int ans[] = new int[N] ; 

        for( int i=0 ; i<26 ; i++ )
            Arrays.fill( mat[i] , 0 ) ; 

        for( int i=N-1 ; i>=0 ; i-- ){
            int count = 0 ; 
            String S = arr[i] ;
            for( int j=0 ; j<S.length() ; j++ ){
                char ch = S.charAt(j) ;
                count += mat[ch-'a'][j] ;
                mat[ch-'a'][j] += 1 ;  
            }
            ans[i] = count ;  
        }

        return ans ; 
    }


    public static void main(String[] args) throws IOException {
        initialize();  
        String arr[] = {"bbz" , "zaz" , "aaa" , "zaa" , "zzz"} ;
        int ans[] = sumOfMatchingCharacters(arr) ; // [2, 5, 2, 1, 0]
        out.println(Arrays.toString(ans)) ;
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
