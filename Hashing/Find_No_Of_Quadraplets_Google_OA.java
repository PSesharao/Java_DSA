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

    // 0 - based indexing
    public static int findNumberOfQuadruplets( int arr[] ){

        int N = arr.length ;  
        if(N == 0 || N == 1 || N == 2 || N == 3)
            return 0 ; 
        int ans = 0 ;
        int prefix[] = new int[N] ;  
        int suffix[] = new int[N] ;  
        Arrays.fill(prefix , 0 ) ; 
        Arrays.fill(suffix , 0 ) ; 

        // A[i] > A[j] < A[k] >A[l]

        // A[i] > A[j] -- prefix 
        for(int j=1 ; j<N-2 ; j++ ){
            for(int i=0 ; i<j ; i++ )
                if( arr[i] > arr[j] )
                    prefix[j]++ ; 

        }

        // A[k] >A[l] -- suffix
        for(int k=2 ; k<N-1 ; k++ ){
            for(int l=k+1 ; l<N ; l++)
                if(arr[k] > arr[l])
                    suffix[k]++ ; 
        }

        // check for A[j] < A[k]
        for(int j=1 ; j<N-2 ; j++ ){
            for(int k=j+1 ; k<N-1 ; k++ )
                if(arr[j] < arr[k])
                    ans += prefix[j] * suffix[k] ; 
        }

        return ans ; 

    } 

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
