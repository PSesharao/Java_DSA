// https://leetcode.com/problems/find-common-characters/

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {
    public List<String> commonChars(String[] words) {

        int[] min_char_freq_array = new int[26];
        Arrays.fill(min_char_freq_array, 101 );  // as word length <=100 


        for(String word : words ) {

            // for each word find the frequency of every character 
            Map<Character , Integer > freq_map = 
            new HashMap<>() ; 

            for(char ch : word.toCharArray() )
                freq_map.put( ch , freq_map.getOrDefault(ch , 0 ) + 1 ) ; 
            
            for(int i=0 ; i<26 ; i++ ){

                min_char_freq_array[i] = Math.min(min_char_freq_array[i] , 
                 freq_map.getOrDefault( (char) ('a'+ i) , 0 ) ) ; 
            }

        }

        List<String> result = new ArrayList<>() ; 

        for(int i=0 ; i<26 ; i++ ) {

            
            int freq = min_char_freq_array[i] ; 

            if(freq >0 ){
                char ch = (char) ('a' + i ) ; 
                for(int f=1 ; f<=freq ; f++ ){

                    String str = String.valueOf(ch); 
                    result.add(str) ; 
                }
            }

        }

        return result ; 
        
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

        String[] words = {"bella","label","roller"}  ; 
        out.println(sol.commonChars(words)) ;  
        
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
