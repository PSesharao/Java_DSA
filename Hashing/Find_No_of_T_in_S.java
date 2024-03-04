
// https://leetcode.com/discuss/interview-question/3114099/AMAZON-OA-(INTERN-2024)

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 



class Solution {

    public int findNumberOfOccurences(String S , String T ) {
        Map<Character , Integer> freq_s = new HashMap<>() ; 
        Map<Character , Integer> freq_t = new HashMap<>() ; 

        for(char ch : S.toCharArray()) {
            freq_s.put(ch , freq_s.getOrDefault(ch , 0 )+1 ) ; 
        }

        for(char ch : T.toCharArray()) {
            freq_t.put(ch , freq_t.getOrDefault(ch , 0 )+1 ) ; 
        }

        int inf = Integer.MAX_VALUE ; 
        int ans = inf ; 

        for(char ch : T.toCharArray()) { 

            int t_freq = freq_t.get(ch ) ; 
            int s_freq = freq_s.get(ch ) ; 

            ans = Math.min( ans , (s_freq / t_freq )) ; 
        }

        if(ans == inf ) 
            return -1 ; 

        return ans ; 
    }
  
}

class JavaMain {

    private static FastReader in;
    private static FastWriter out ;

    public static void main(String[] args) throws IOException  {
        initialize(); 
        Solution sol = new Solution() ; 
        String S = in.nextLine() ; 
        String T = in.nextLine() ;  
        out.println(sol.findNumberOfOccurences( S , T )) ;  
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
