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



    private static boolean findIfSwappable(String str1  , String str2  ) {

        Map<Character , Integer > map1 = new HashMap<>() ;
        Map<Character , Integer > map2 = new HashMap<>() ;

        // finding freq of both the strings in maps 

        for(char ch : str1.toCharArray() ){
            
            int f = map1.getOrDefault(ch , 0 ) ;
            map1.put(ch , f+1 ) ;  
        }

        for(char ch : str2.toCharArray() ){
            
            int f = map2.getOrDefault(ch , 0 ) ;
            map2.put(ch , f+1 ) ;  
        }

        // comparing both the maps 

        for(int i=0 ; i<26 ; i++ ){

            char ch = (char) ( 'a' + i )  ; 

            if( map1.get(ch) != map2.get(ch) )
                return false ; 
        }

        return true ;     
    }

    private static String checkTwin(String A  , String B) {

        String A_even = "", B_even = "" , A_odd = "" , B_odd = ""  ; 

        for(int i=0 ; i<A.length() ; i++ ) {

            if( i %2 == 0 )
                A_even += A.charAt(i) ; 
            else  
                A_odd += A.charAt(i) ; 
        }

        for(int i=0 ; i<B.length() ; i++ ) {

            if( i %2 == 0 )
                B_even += B.charAt(i) ; 
            else  
                B_odd += B.charAt(i) ;  
        }

        boolean evenResult = findIfSwappable( A_even , B_even ) ; 
        boolean oddResult = findIfSwappable( A_odd , B_odd ) ; 

        return ( evenResult && oddResult ? "Yes " : "No " )   ;
    } 

    public static void main(String[] args) throws IOException  {
        initialize(); 
        //Solution sol = new Solution() ; 
        String A = "abcd" ; 
        String B = "dcba" ;  // "cdab" ; 
        out.println( checkTwin(A , B ) )  ; 
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
