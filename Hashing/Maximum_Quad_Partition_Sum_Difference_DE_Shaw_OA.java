// https://docs.google.com/document/d/1ddCV9pTFFkvJRascZEU_Nckh3-nzLDet0Hj77KR6s4o/edit?tab=t.0

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 



class JavaMain {

    private static FastReader in;
    private static FastWriter out ;
    private static final int minVal = Integer.MIN_VALUE + 10 ; 
    private static final int maxVal = Integer.MAX_VALUE - 10 ;

    public static int maxQuadPartitionSum( int A[] ) throws IOException  {
        int N = A.length ; 
        int min_p2_p4 = maxVal ; // represents p2 + p4

        int sum = 0 ; 

        for(int num : A){
            sum += num ; 
        }

        int p4[] = new int[N] ;
        

        p4[N-1] = A[N-1] ; // last element is always included
        int suffix_sum = A[N-1] ;

        for(int i=N-2 ; i>=0 ; i--){
            suffix_sum += A[i] ; 
            p4[i] = Math.min( p4[i+1] , suffix_sum ) ; 
            // either consider min of ( continuous 'suffix_sum' or without including current element)
            // in both cases the last element is always included.
            // [ 15 ,-12] in this case , we prefer -12 over 3( 15+(-12))
        }
        // Example 
        //A[] = [3   , -8  , -5 , 2 , 1 ]
        //p4[] =[-10 , -10 , -2 , 1 , 1 ]

        int p2[] = new int[N] ; 
        p2[0] = A[0] ;
        for(int i=1 ; i<N ; i++){
            p2[i] = Math.min( p2[i-1]+A[i] , A[i] ) ; 
            // We are not doing 'prefix_sum' as we do not need to include first element always
        }
        

        // for(int i=0 ; i<N ; i++ ){
        //     if(i==N-1)
        //         min_p2_p4 = Math.min(min_p2_p4 , p2[i] ) ; 
        //     else 
        //         min_p2_p4 = Math.min(min_p2_p4 , p2[i]+p4[i+1] ) ; 
        // }

        // To handle the case where all numbers are positive , otherwise for 
        // [1,2,3,4] , we would get (1+2+3) - (4) = 2 
        for(int i=0 ; i<N ; i++ ){
            int curr_min ;
            if(i==N-1)
                curr_min = Math.min(p2[i] , 0 ) ; 
            else
                curr_min = Math.min(p2[i] , 0 ) + Math.min(p4[i+1] , 0 ) ; 
            min_p2_p4 = Math.min(min_p2_p4 , curr_min ) ; 
        }

        int ans = sum - 2*min_p2_p4 ; // ( p1+p3 ) -( p2+p4 )
        // ( p1+p3 ) +( p2+p4 ) = sum
        //  ( p1+p3 ) = sum - ( p2+p4 )
        // ( p1+p3 ) -( p2+p4 ) = sum - ( p2+p4 ) - (p2+p4)
        // => sum - 2*min_p2_p4
        return ans ;   
    }


    public static void main(String[] args) throws IOException  {
        initialize();
        //int arr[] = { -3, 4, -5, 2, 6, -5}; // 19
        //int arr[] = { -4 , 1 , -1}; // 16
        int arr[] = {1,2,3,4} ; 
        // 10 we have put entire sum into p1/p3 , and remaining all parts are empty
        out.println( maxQuadPartitionSum(arr) ) ; 
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
