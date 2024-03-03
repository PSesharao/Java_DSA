// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {

    public int longestPalindrome(String[] words) {

        boolean odd_appeared = false ; 
        int lengthOfPalindrome = 0 ; 
        
        Map<String , Integer > fmap = new HashMap<>() ; 

        for(String word : words )
            fmap.put( word , fmap.getOrDefault(word , 0 )+1 ) ; 
        
        for(String word : words ) {

            if(word.charAt(0) != word.charAt(1) ){   //  distinct characters like "ab"

                String rev =  ""+ word.charAt(1) + word.charAt(0) ; 
                
                int wordFreq = fmap.getOrDefault(word,0) ; 
                int revFreq = fmap.getOrDefault(rev,0) ; 

                lengthOfPalindrome += 4*(Math.min(wordFreq , revFreq )) ; 
                // mutiplying with 4 , as there is reverse words also
                fmap.remove(word) ; 
                fmap.remove(rev) ; 

            }else{  // same characters "aa"

                int wordFreq = fmap.getOrDefault(word,0) ; 

                if(wordFreq %2 == 0 )  // even 
                    lengthOfPalindrome += 2*wordFreq ;  // mutiplying with 2 as it is same word

                else {  // odd
                    if(!odd_appeared) {
                        lengthOfPalindrome += 2*wordFreq ; // taking only one odd
                        odd_appeared = true ; 
                    }else 
                        lengthOfPalindrome += 2*(wordFreq - 1) ; // taking remaining as even
                }

                fmap.remove(word) ; 
            } 


        }

        return lengthOfPalindrome ;  

    }



    public int longestPalindrome(String[] words) {

        boolean odd_appeared = false ; 
        int lengthOfPalindrome = 0 ; 
        
        Map<String , Integer > fmap = new ConcurrentHashMap<>() ; 

        for(String word : words )
            fmap.put( word , fmap.getOrDefault(word , 0 )+1 ) ; 
        
        for(Map.Entry<String , Integer > entry : fmap.entrySet() ) {

            String word = entry.getKey() ; 

            if(word.charAt(0) != word.charAt(1) ){   //  distinct characters like "ab"

                String rev =  ""+ word.charAt(1) + word.charAt(0) ; 
                
                int wordFreq = fmap.getOrDefault(word,0) ; 
                int revFreq = fmap.getOrDefault(rev,0) ; 

                lengthOfPalindrome += 4*(Math.min(wordFreq , revFreq )) ; 
                // mutiplying with 4 , as there is reverse words also
                fmap.remove(word) ; 
                fmap.remove(rev) ; 

            }else{  // same characters "aa"

                int wordFreq = fmap.getOrDefault(word,0) ; 

                if(wordFreq %2 == 0 )  // even 
                    lengthOfPalindrome += 2*wordFreq ;  // mutiplying with 2 as it is same word

                else {  // odd
                    if(!odd_appeared) {
                        lengthOfPalindrome += 2*wordFreq ; // taking only one odd
                        odd_appeared = true ; 
                    }else 
                        lengthOfPalindrome += 2*(wordFreq - 1) ; // taking remaining as even
                }

                fmap.remove(word) ; 
            } 


        }

        return lengthOfPalindrome ;  

    }
}

class JavaMain {

    private static FastReader in;
    private static FastWriter out ;

    public static void main(String[] args) throws IOException  {
        initialize(); 
        Solution sol = new Solution() ; 
        
        int arr[] = {1 , 4 , 1 , 3 , 2 , 2 } ;  
        int k = 5 , n = 6 ; 

        int ans = sol.getPairsCount2(arr , n , k) ;
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
