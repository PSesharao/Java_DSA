// https://docs.google.com/document/d/1_d1CH0HblrFYUgtAPq5FYsNvXo1YD0XsUyZ6OTVHb80/edit

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {

    int countNumberOfMountains( int[] arr ) {

        int n = arr.length ; 
        
        int pref[] = new int[n] ; 

        int suf[] = new int[n] ; 

        pref[0] = suf[n-1] = 1 ;   

        for(int i=1; i<n ; i++ ){

            if( arr[i] > arr[i-1] )
                pref[i] = pref[i-1] + 1; 
            else 
                pref[i] = 1 ; 

        }

        for(int i=n-2 ; i>=0 ; i-- ){

            if(arr[i] > arr[i+1])
                suf[i] = suf[i+1] + 1 ; 
            else 
                suf[i] = 1 ; 
        }

        int count = 0 ; 
        for(int i=0; i<n ; i++ ){
            // We do not need to check for the condition if mountains len>=3 
            // because if len =3 then pref[i] = suf[i] = 2 , and for all other cases 
            // where len < 3 will be taken care by default as pref[i] = suf[i] = 1
            count += ( pref[i]-1 ) * ( suf[i]-1 ) ;

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
        
        int arr[] = {1 , 2 , 4 , 2 , 1 } ;  
        

        int ans = sol.countNumberOfMountains(arr) ;
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
