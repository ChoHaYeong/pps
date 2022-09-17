package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ6118 {
    static int N, M, max = 0;
    static int[] depth;
    static boolean[] visited;

    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        depth = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<=N; i++)
            list.add(new ArrayList<>());
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            list.get(to).add(from);
            list.get(from).add(to);
        }
        //depth[1] = ;
        bfs( 1);
        depth[1] = 0;
       // int max = 0,
        int num =0, dis = 0; //숨어야하는 헛간까지의 거리
        // for(int i=1; i<=N; i++){
        //     max = Math.max(max, depth[i]);
        // }

        for(int i=1; i<=N; i++){
            if(max <= depth[i]){
                max = depth[i];
                num++;
            }
        }
        for(int i=1; i<=N; i++)
            if(max == depth[i]){
                dis = i;
                break;
            }

        System.out.println(dis + " " + max + " " + num);
    }

    // static void dfs(int curr, int x) {
    //     //depth[x] = curr;
    //     for(int l : list.get(x)) {
    //         if(!visited[l]) {
    //             //System.out.println(depth[l] );
    //             visited[l] = true;
    //             dfs(curr+1, l);
    //             depth[l]++;
    //             visited[l] = false;
                
    //            // System.out.println(depth[l] );
                
    //         }
    //     }
    // }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        //depth[x] = -1;
        while(!queue.isEmpty()) {
            int out = queue.poll();
           // System.out.println(out);
            for(int l : list.get(out)) {
              //  System.out.println("l " + l);
                if(depth[l] == 0 ){
                    queue.add(l);
                    depth[l] = depth[out] + 1;

                    max = Math.max(max, depth[l]);
                }
            }
        }
    }
}
