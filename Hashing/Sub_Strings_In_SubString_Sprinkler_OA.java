// https://www.desiqna.in/15759/sprinklr-oa-sde-1-freshers-2023

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {


    public int noOfSubStringsInString(String str , int l , int r ) {

        char []S = str.toCharArray() ; 
        int n = str.length() ; 
        int prefix[][] = new int[n+1][26] ;  

        for(int i=0 ; i<n ; i++)
            Arrays.fill(prefix[i] , 0 ) ; 

        for(int i=0 ; i<n ; i++){

            int ch = S[i]- 'a' ;
            for(int j=0 ; j<26 ; j++ ){

                if(ch == j)
                    prefix[i+1][j] = 1+prefix[i][j] ;
                else 
                    prefix[i+1][j] = prefix[i][j] ; 
                // prefix[i+1][j] = (ch == j ? 1+prefix[i][j] : prefix[i][j]) ;  
            }
        }

        int ans = 0 ;
        
        for(int j=0 ; j<26 ; j++ ){
            int f = prefix[r][j] - prefix[l-1][j] ; // since 1 based indexing 
            // f will have the frequency of j between range [l ... r]
            ans += (f * (f+1)) /2 ; 
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

        String str = "uxarabbczy" ; 
        out.println(sol.noOfSubStringsInString(str , 3 , 8 )) ;  
        
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
