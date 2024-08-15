// https://docs.google.com/document/d/1f2VzhDu7z0fxBgn5TcpW0xf0wVyPFePNW_Iezlvk_oI/edit
// https://www.desiqna.in/15926/atlassian-oa-sde-1-freshers-hiring-ctc-75-lac

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {

    public int getMaxScoreOfSubSequence(int[] nums) {
        
        int N = nums.length  ;
        Map<Integer , Integer > map = new HashMap<>() ; 

        int max_score = -1; 
        
        for(int i=0 ; i<N ; i++){

            int k = nums[i] - i ; 
            map.put( k , map.getOrDefault(k , 0) + nums[i]  ) ; 
            
            max_score = Math.max( max_score , map.get(k)) ; 

        }

        return max_score ; 

    }

}

class JavaMain {

    private static FastReader in;
    private static FastWriter out ;


    public static void main(String[] args) throws IOException  {
        initialize(); 
        Solution sol = new Solution() ; 
        int arr[] = {1 , 5 , 3 ,7 ,8  } ;  
        int res = sol.getMaxScoreOfSubSequence(arr ) ; 
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
