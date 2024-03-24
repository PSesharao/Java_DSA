// 

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


    public static int[] rangeUpdate(int N) throws IOException {

        int[] b = new int[N+1] ; 

        for(int i=0 ; i<=N ; i++ )
            b[i] = 0 ; 

        int Q = in.nextInt() ;
        int l , r ; 

        for(int q=1 ; q<=Q ; q++ ){
            l = in.nextInt() ; 
            r = in.nextInt() ; 
            b[l] += 1 ; 
            b[r+1] -= 1; 
        }

        for(int i=1 ; i<N ; i++ ){
            b[i] += b[i-1] ; 
        }

        return b ; 

    }

    public static void main(String[] args) throws IOException  {
        initialize(); 
        //Solution sol = new Solution() ; 

        int N = in.nextInt() ; 
        int b[] = rangeUpdate(N) ;  
        for(int i=0 ; i<N ; i++ ){
            out.print( b[i] + " ") ;
        }
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
