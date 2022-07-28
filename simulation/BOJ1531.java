package simulation;

import java.util.*;
import java.io.*;

public class BOJ1531 {

    static int N, M;
    //static boolean[][][] visited;
    static int[][] pic;
    //static int[][][] dist;
    //static int days = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken()); 
        pic = new int[101][101];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int fx = Integer.parseInt(st.nextToken()); 
            int fy = Integer.parseInt(st.nextToken()); 
            int bx = Integer.parseInt(st.nextToken()); 
            int by = Integer.parseInt(st.nextToken()); 
            //21 21 80 80
            int n = 0;
            for(int j=fx; j<=bx; j++) {
                for(int k=fy; k<=by; k++) {
                    pic[j][k] += 1;
                }
            }
        }

        int  count =0 ;

        for(int i=0; i<101; i++) {
            for(int j=0; j<101; j++) {
                if(pic[i][j] > N)
                    count++;

               // System.out.print(pic[i][j] + " ");
            }
            //System.out.println();
        }

        System.out.println(count);
        
    }
    
}
