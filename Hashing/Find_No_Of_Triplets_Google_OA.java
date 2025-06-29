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

    // 0 based indexing 
    public static int findNumberOfTriplets( int arr[] ){

        int N = arr.length ;  
        if(N == 0 || N== 1 || N== 2)
            return 0 ; 
        int ans = 0 ;
        int prefix[] = new int[N] ;  
        int suffix[] = new int[N] ;  
        Arrays.fill(prefix , 0 ) ; 
        Arrays.fill(suffix , 0 ) ; 

        // A[i] > A[j] -- prefix 
        for(int j=1 ; j<N-1 ; j++ ){
            for(int i=0 ; i<j ; i++ )
                if( arr[i] > arr[j] )
                    prefix[j]++ ; 

        }

        // A[j] < A[k] -- suffix
        for(int j=1 ; j<N-1 ; j++ ){
            for(int k=j+1 ; k<N ; k++)
                if(arr[j] < arr[k])
                    suffix[j]++ ; 
        }

        for(int j=1 ; j<N-1 ; j++ ){
            ans += prefix[j] * suffix[j] ; 
        }

        return ans ; 
    } 

    public static int findNumberOfTriplets( int arr[] )  {
        int N = arr.length-1 ; 
        int pref[] = new int[N+1]; 
        int suff[] = new int[N+1]; 
        int i , j , k , c , count = 0 ; 
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
        j = N-1 ;
        while( j >=1  ) {
            k = N ; 
            c = 0 ; 
            while(k >= j+1 ){
                if(arr[j] < arr[k] )
                    c++ ; 
                k -- ; 
            }
            suff[j] = c ; 
            j -- ; 
        }


        for( i=1 ; i<=N ; i++ ) {
            count += pref[i]*suff[i] ; 
        }

        return count ; 
    }

    public static void main(String[] args) throws IOException  {
        initialize(); 
        Solution sol = new Solution() ; 
        // String name = in.nextLine() ; 
        int arr[] = { 0 ,8, 1 ,2 , 3, 4 , 5 }; // 1 based indexing
        out.println( findNumberOfTriplets(arr) ) ; 
    
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
