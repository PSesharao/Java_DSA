// https://leetcode.com/problems/longest-consecutive-sequence/
import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution {
    public int longestConsecutive1(int[] nums) {
        
        if(nums.length == 0 )
            return 0 ; 
        
        Arrays.sort(nums) ; 
        int max_len = 1 ;  // At worst there is no consecutive at all
        int curr_len = 1 ; 

        for( int idx=1 ; idx < nums.length ; idx++ ){

            int curr = nums[idx] ; 
            int prev = nums[idx-1] ; 

            if(curr == prev+1 ){   // check if consecutive
                curr_len ++ ; 
            }else if(curr == prev ){   // check if equal 
                continue ; 
            }else {  // check if not consecutive
                max_len = Math.max(curr_len , max_len ) ; 
                curr_len = 1 ; 
            }
    
        }
        max_len = Math.max(curr_len , max_len ) ;  //  To cover for the last element
        return max_len ; 

    }



    public int longestConsecutive(int[] nums) {

        if( nums.length == 0 )
            return 0 ; 
        
        int max_len = 0 ; 
        Set<Integer> set = new HashSet<>() ; 

        for(int num : nums ){
            set.add(num) ; 
        }

        for(int num : nums ){

            // This will decide whether num is starting of the seq or not
            if( set.contains(num-1) ) 
                continue ; 

            else {

                int curr_streak = 1 ; 
                int next = num+1 ; 
                while(set.contains(next)){
                    next ++ ; 
                    curr_streak ++ ; 
                }

                max_len = Math.max(curr_streak , max_len ) ;
            }
        }

        return max_len ; 
    }

}

class JavaMain {

    private static FastReader in;
    private static FastWriter out ;


    public static int overLappingLamps(int N) throws IOException {

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

        int illuminating_point = in.nextInt() ; 
        return b[illuminating_point] ; 

    }

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
