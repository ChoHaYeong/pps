package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2617 {
    static int N, M, cnt = 0;
    static int[] count;

    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static ArrayList<ArrayList<Integer>> list2 = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = new int[N+1];

        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
            list2.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());

            list.get(light).add(heavy);
            list2.get(heavy).add(light);
        }
        
        for(int i=1; i<=N; i++){
            dfs(1, i);
            dfs2(1, i);
           // System.out.println();
        }
        System.out.println(cnt);
    }

    static void dfs(int curr, int x) {
       // System.out.println(x);
        if(curr == (N/2+1)){
           // System.out.println(curr);
            cnt++;
            return ;
        }
        for(int l : list.get(x)) {
            dfs(curr+1, l);
        }
    }

    static void dfs2(int curr, int x) {
        // System.out.println(x);
         if(curr == (N/2+1)){
            // System.out.println(curr);
             cnt++;
             return ;
         }
         for(int l : list2.get(x)) {
             dfs2(curr+1, l);
         }
     }
}


