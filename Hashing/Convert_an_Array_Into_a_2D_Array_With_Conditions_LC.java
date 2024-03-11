
// https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 



class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        
        int max_freq = 0 ; 
        Map< Integer , Integer > map = new HashMap<>() ; 

        for( int num : nums ){
            map.put( num , map.getOrDefault(num , 0 )+1 ) ;
            max_freq = Math.max( max_freq , map.get(num) ) ; 
        }

        List<List<Integer>> ans = new ArrayList<>() ;  
        
        for(int i=1 ; i<=max_freq ; i++ ){
            ans.add(new ArrayList<>());
        }

        for( Map.Entry< Integer , Integer > entry : map.entrySet() ){

            int element = entry.getKey();
            int freq = entry.getValue() ; 

            for(int v=0 ; v<freq ; v++ ){
                ans.get(v).add(element) ; 
            }

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
        int size = in.nextInt(); 
        int nums[] = new int[size] ; 
        for(int i=0 ; i<size ; i++ ){
            nums[i] = in.nextInt();  
        }
        List<List<Integer>> res = sol.findMatrix(nums) ; 
        int res_size = res.size() ; 

        for( int i=0 ; i<res_size ; i++ ){

            for(int j=0 ; j<res.get(i).size() ; j++  )
                    out.print( res.get(i).get(j) + " ") ; 

            out.println("") ; 
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
