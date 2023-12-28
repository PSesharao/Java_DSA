
// https://practice.geeksforgeeks.org/problems/max-distance-between-same-elements/1

import java.io.*;
import java.util.*;
import java.util.function.* ; 
import java.util.concurrent.* ; 
import java.util.stream.* ; 


class Solution
{
    int maxDistance(int arr[], int n){
         
         Map<Integer , Integer > map = new HashMap<>() ; 

         int max_dis = 0 ; 

         for(int i=0 ; i<n ; i++ ){

            if(map.containsKey( arr[i] ) ) {

                int prev_pos = map.get(arr[i]) ; 
                int curr_dis = i - prev_pos ; 
                max_dis = Math.max(max_dis , curr_dis ) ; 

            }else // we should keep this statement in the else block only ,
            // otherwise we would end up overriding with the latest values.
                map.put( arr[i] , i ) ; 

         }

         return max_dis ; 
    }
}

class JavaMain {

    private static FastReader in;
    private static FastWriter out ;

    public static void main(String[] args) throws IOException  {
        initialize(); 
        Solution sol = new Solution() ; 
        String name = in.nextLine() ; 
        out.println(name) ; 
        out.println(sol.greetUser(name)) ;  
        out.println("Hello Every one , how are you all doing ? ") ; 
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
