// https://leetcode.com/problems/first-unique-character-in-a-string/

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {
    public int firstUniqChar(String s) {

        Map<Character , Integer > freq = 
        new HashMap<>() ; 

        for( char ch : s.toCharArray() )
            freq.put(ch , freq.getOrDefault(ch , 0 ) + 1 ) ; 

        for(int i=0 ; i< s.length() ; i++ ) {
            char ch = s.charAt(i) ; 
            if( freq.get(ch) == 1 )
                return i ; 
        }
        
        return -1 ; 
    }
}

class JavaMain {

    private static FastReader in;
    private static FastWriter out ;

    public static void main(String[] args) throws IOException  {

        initialize(); 

        Solution sol = new Solution() ; 

        //int size = in.nextInt() ;
        
        // int nums[] = new int[size] ;

 
        out.println(sol.firstUniqChar( "loveleetcode" )) ;  
        
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
