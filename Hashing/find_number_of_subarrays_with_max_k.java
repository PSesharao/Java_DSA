// https://docs.google.com/document/d/1y_bVXSrRa0ezXBx9cC6foeXDMyE-nTGV_XGJf-tSeN4/edit?tab=t.0

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
    private static final int minVal = Integer.MIN_VALUE + 10 ; 
    private static final int maxVal = Integer.MAX_VALUE - 10 ;

    private static int[] getNextSameOrGreaterElements(int[] arr) {
        int N = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[N];

        // Iterate through the array from right to left
        for (int i = N - 1; i >= 0; i--) {
            // Pop indices from the stack whose values are strictly less than the current element
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }

            // If stack is not empty, check for next same or next greater element
            if (!stack.isEmpty()) {
                // Check if the element at the top of the stack is the same as the current element
                if (arr[i] == arr[stack.peek()]) {
                    result[i] = stack.peek();
                } else {
                    // The element at the top of the stack is the next greater element
                    result[i] = stack.peek();
                }
            } else {
                // No next same or next greater element exists
                result[i] = -1;
            }

            // Push the current element's index onto the stack
            stack.push(i);
        }
        return result;
    }

    private static int[] getPreviousGreaterElements(int[] arr) {
        int N = arr.length;
        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();

        // Iterate through the array from left to right
        for (int i = 0; i < N; i++) {
            // While the stack is not empty and the current element is greater than or equal to the top of the stack, pop from the stack
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }

            // If the stack is empty, there is no greater element to the left
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                // The top of the stack is the previous greater element
                result[i] = stack.peek();
            }

            // Push the current element index onto the stack
            stack.push(i);
        }

        return result;
    }

    private static int findNumberOfSubarrays( int[] arr , int k ) {
        int N = arr.length ; 
        int ans = 0 ;
        Stack<Integer> stack = new Stack<>() ; 
        int next_max[] = getNextSameOrGreaterElements(arr) ; 
        int prev_max[] = getPreviousGreaterElements(arr);
        for(int i=0 ; i<N ; i++){
            if( arr[i] == k ){
                int left_max_ind = prev_max[i] ; 
                int right_max_ind = next_max[i] ; 
                int left_len=0 , right_len=0 ;
                if(left_max_ind != -1 )
                    left_len = i - left_max_ind-1 ;
                if(right_max_ind !=-1 )
                    right_len = right_max_ind - i-1 ;
                ans += ( left_len * right_len ) + (left_len + right_len ) + 1 ;
            }
        }
        return ans ; 
    }

    public static void main(String[] args) throws IOException {
        initialize();  
        int arr[] = {8, 2, 1 , 3, 4, 5 , 1 , 10  } ;
        int k =3 ;
        int ans = findNumberOfSubarrays(arr , k ) ; 
        out.println(ans) ;
        close() ; 
    }

    
    private static void initialize() throws IOException , FileNotFoundException {
        in = new FastReader();
        out = new FastWriter();
    }

    private static void close() throws IOException  {
        in.close();
        out.close();
    }
}
