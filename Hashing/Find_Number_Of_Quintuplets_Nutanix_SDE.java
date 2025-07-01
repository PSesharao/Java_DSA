// https://docs.google.com/document/d/1kBBhraTmmds4ntp3qr7DXcDETn0YGSSIrrpz5nmIN4E/edit?tab=t.0

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

    private static int findNumberOfQuintuplets( int A[] , int B[] , int C[]
        , int D[] , int E[] ) {

        int N = A.length ; 
        if(N == 0)
            return 0 ; 

        Map<Integer , Integer> map = new HashMap<>() ; 

        for(int m=0 ;m<N ; m++)
            map.put(E[m] , map.getOrDefault(E[m] , 0)+1 ) ;

        int count = 0 ; 
        for(int i=0 ; i<N ; i++ ){
            for(int j=0 ; j<N ; j++)
                for(int k=0 ; k<N ; k++)
                    for(int l=0 ; l<N ; l++)
                    {
                        int sum = A[i] + B[j] + C[k] + D[l] ;
                        count += map.getOrDefault(-1*sum , 0) ;
                    }
        }
        return count ; 
    }

    // Meet in the middle algorithm 
    private static int findNumberOfQuintuplets_1( int A[] , int B[] , int C[]
        , int D[] , int E[] ) {

        int N = A.length ; 
        if(N == 0)
            return 0 ; 

        Map<Integer , Integer> map = new HashMap<>() ; 
        int count = 0 ; 

        // for last 2 elements 
        for(int l=0 ; l<N ; l++)
            for(int m=0 ;m<N ; m++){
                int sum = D[l] + E[m] ;
                map.put(sum , map.getOrDefault(sum , 0)+1 ) ;
        }

        // for first 3 elements
        for(int i=0 ; i<N ; i++ ){
            for(int j=0 ; j<N ; j++)
                for(int k=0 ; k<N ; k++)
                    {
                        int sum = A[i] + B[j] + C[k] ;
                        count += map.getOrDefault(-1*sum , 0) ;
                    }
        }
        return count ; 

    }

    public static void main(String[] args) throws IOException  {
        initialize(); 
        Solution sol = new Solution() ; 
        // String name = in.nextLine() ; 
        int A[] = {1, 0} ;
        int B[] = {1, 0} ;
        int C[] = {1, 0} ;
        int D[] = {1, 0} ;
        int E[] = {-4, -1} ;
        int ans = findNumberOfQuintuplets_1(A , B , C , D , E ) ;
        out.println( ans ) ; // op : 5
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
