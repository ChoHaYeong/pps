package codeplus_2;

import java.io.*;
import java.util.*;

public class BOJ6064 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int idx = 0;
            int remain = 0;
            while(true) {
                int Y = M * idx + x;
                if(idx == 0){
                    remain = (Y-y)%N ;
                }

                if((Y-y)%N == 0){
                    System.out.println(Y);
                    break;
                }
                if(idx !=0 && remain == (Y-y)%N) {
                    System.out.println(-1);
                    break;
                }
                idx += M;

            }
        }

    }
    
}
