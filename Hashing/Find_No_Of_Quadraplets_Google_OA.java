// https://docs.google.com/document/d/1LthiOPD4CvHTu9d0_h_XKJF9U9BYdjYYetnjjAPQLpo/edit

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

    public static int findNumberOfQuadraplets( int arr[] )  {

        int N = arr.length-1 ; 
        int pref[] = new int[N+1]; 
        int suff[] = new int[N+1]; 
        int i , j , k , l,  c , count = 0 ; 
        j = 2 ; 
        pref[1] = 0 ;  

        while( j <= N ) {
            i = 1 ; 
            c = 0 ; 
            while(i <= j-1 ){
                if( arr[i] > arr[j] )
                    c ++ ;

                i++ ;  
            }
            pref[j] = c ; 
            j ++ ; 
        }

        suff[N] = 0 ; 

        k = N-1 ;
        while( k >=1  ) {
            l = N ; 
            c = 0 ; 
            while(l >= k+1 ){
                if(arr[k] > arr[l] )
                    c++ ; 
                l -- ; 
            }
            suff[k] = c ; 
            k -- ; 
        }


        k = 2 ; 
        while( k <= N ){
            j = 1 ; 

            while(j <= k-1 ){
                if(arr[j] < arr[k] )
                    count += pref[j] * suff[k] ; 
                j++ ; 
            }

            k ++ ; 
        }

        return count ; 
    }




    public static void main(String[] args) throws IOException  {
        initialize(); 
        Solution sol = new Solution() ; 
        // String name = in.nextLine() ; 
        int arr[] = { 0 ,5, 2, 8, 4, 6, 1 }; // 1 based indexing
        out.println( findNumberOfQuadraplets(arr) ) ; 
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
