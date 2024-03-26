// https://www.desiqna.in/16189/backend-engineer-hackerrank-online-test

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
    private final static int SIZE = 1440 ; 

    private static int getMinutes( String timestamp ){
        String parts[] = timestamp.split(":") ; 
        String hours = parts[0] ; 
        String minutes = parts[1]  ;

        int hr = (hours.charAt(1)-'0') + (hours.charAt(0)-'0')*10 ; 
        int min = (minutes.charAt(1)-'0') + (minutes.charAt(0)-'0')*10 ; 

        return hr*60 + min ; 
    }

    private static String getTimeStamp( int minutes ){

        String timestamp = "" ; 
        int hr = minutes / 60 ; 
        int min = minutes % 60 ; 

        if(hr < 9 ){
            timestamp += "0" + String.valueOf(hr) ;

        }else {
            timestamp +=  String.valueOf(hr) ;
        }

        timestamp += ":" ; 

        if(min < 9 ){
            timestamp += "0" + String.valueOf(min) ;

        }else {
            timestamp +=  String.valueOf(min) ;
        }

        return timestamp ; 

    }

    public static String getEarliestMeetTime(int b[] , int k ) throws IOException  {
        //out.println(k) ; 
        //out.println(Arrays.toString(b)) ; 
        int countMin = 0 ;
        
        for(int i=0 ; i<SIZE ; i++ ){

            if(b[i] == 0 )
            {
                countMin ++ ; 
                if(countMin == k ){

                    return getTimeStamp(i-k +1 ) ; 
                    
                }
            }else {
                    countMin = 0 ; 
            }
        }
        return "-1" ; 

    } 

    public static void main(String[] args) throws IOException  {
        initialize(); 
        int N = in.nextInt() ; 
        
        int b[] = new int[SIZE+1] ; 
        Arrays.fill(b , 0 ) ; 
        for(int i=0 ; i<N ; i++ ){

            String startTime = in.nextLine() ; 
            String endTime = in.nextLine() ; 

            int startMin = getMinutes(startTime ) ; 
            int endMin = getMinutes(endTime) ; 

            b[startMin] ++ ;  
            b[endMin+1] -- ; 

        }

        int k = in.nextInt() ; 

        for(int i=1 ; i<SIZE ; i++ )
            b[i] += b[i-1] ; 

        
        String ans = getEarliestMeetTime(b , k ) ; 
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
