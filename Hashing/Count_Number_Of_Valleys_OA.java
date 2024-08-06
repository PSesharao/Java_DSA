// https://docs.google.com/document/d/120oGP2t3hupMV6YjObO66lsGMRGkSq89LOlVa1Eh534/edit

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {

    int countNumberOfValleys( int[] arr ) {

        int n = arr.length ; 
        
        int left[] = new int[n] ;  // left to right 

        int right[] = new int[n] ; // right to left

        left[0] = right[n-1] = 1 ;   

        // left to right strictly decreasing 

        for(int i=1; i<n ; i++ ){

            if( arr[i] < arr[i-1] )
                left[i] = left[i-1] + 1; 
            else 
                left[i] = 1 ; 

        }

        // right to left strictly decreasing 

        for(int i=n-2 ; i>=0 ; i-- ){

            if(arr[i] < arr[i+1])
                right[i] = right[i+1] + 1 ; 
            else 
                right[i] = 1 ; 
        }

        int count = 0 ; 
        for(int i=0; i<n ; i++ ){

            count += ( left[i]-1 ) * ( right[i]-1 ) ;

        }
       

        return count ;  
    }


    boolean checkIfValley( int L , int R , int arr[] ) {

        int idx_small = L ; 

        for(int i=L ; i<=R ; i++ ){

            if(arr[i] < arr[idx_small] )
                idx_small = i ; 


        }

        
        // Valley should be of V shape
        if( (R - idx_small < 1 ) || (idx_small - L < 1) )
             return false  ; 

        // check for the left part
        for(int l=idx_small ; l>=L+1 ; l-- ) {

             
            if( !(arr[l-1] > arr[l]) )
                return false ; 
        }

        // check for the right part
        for(int r = idx_small ; r<R-1 ; r++ ){

            if( !(arr[r] < arr[r+1]) )
                return false ; 
        }

        return true ; 
    }

    int countNumberOfValleys_BF( int arr[] )  {
        
        int n = arr.length ; 
        int count = 0 ; 

        for(int l=0 ; l<n ; l++ ){

            for(int r=l+1 ; r<n ; r++ ){

                    if( ((r-l)>=2 ) && (checkIfValley( l , r , arr ) ) )
                        count ++ ; 
            }
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
        
        int arr[] = {  5 , 4 , 3 , 6 , 7 } ;  
        int ans = sol.countNumberOfValleys(arr) ;
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
