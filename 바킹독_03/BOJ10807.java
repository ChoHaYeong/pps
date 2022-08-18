package 바킹독_03;

import java.io.*;
import java.util.*;

public class BOJ10807 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken()); 
        }

        int v = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=0; i<N; i++) {
          
            if( num[i] == v)
                count++;
          
        }
        System.out.println(count);
    }

    
    
}
