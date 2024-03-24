// https://www.geeksforgeeks.org/google-interview-experience-for-girl-hackathon-2023/ 

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {

    public int maximizeEqualNumbers(int arr[] , int k , int N ){


        int size = 100005 ; 
        int b[] = new int[size] ; // 10^5 
        Arrays.fill(b , 0 ) ; 

        for(int i=1 ; i<=N ; i++ ){

            int l = arr[i] - k ; 
            int r = arr[i] + k ; 

            b[l] += 1 ; 
            b[r+1] -= 1 ; 
        }

        int ans = 1 ; // The minimum possible answer when the range does not collide

        for( int i=1 ; i< size ; i++ ){
            b[i] += b[i-1] ; 
            ans = Math.max(ans , b[i] ) ; 
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
        int arr[] = {0 , 5 , 8, 10 } ;  // 1 based indexing 
        int N = 3 , k = 2 ; 
        int res = sol.maximizeEqualNumbers(arr , k , N ) ; 
        out.println(res) ; 
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
