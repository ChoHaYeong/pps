package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ5214 {
    static int N, K, M, min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[] dis;

    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        dis = new int[N+1];
        Arrays.fill(dis, -1);
        for(int i=0; i<=N; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            int[] arr = new int[K+1];

            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=K; j++) {
                // for(int k=0; k<K; k++) {
                //     if(j != k){
                //         list.get(j).add(k);
                //     }
                // }
               arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int j=1; j<=K; j++) {
                for(int k=1; k<=K; k++) {
                    if(j != k){
                        list.get(arr[j]).add(arr[k]);
                    }
                }
              // arr[j] = Integer.parseInt(st.nextToken());
            }
            // st = new StringTokenizer(br.readLine());
            // int first = Integer.parseInt(st.nextToken());
            // int second = Integer.parseInt(st.nextToken());
            // int third = Integer.parseInt(st.nextToken());

            // list.get(first).add(second);
            // list.get(first).add(third);

            // list.get(second).add(first);
            // list.get(second).add(third);

            // list.get(third).add(first);
            // list.get(third).add(second);
        }

        bfs(1);
        if(min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
       // visited[x] = true;
       dis[x] = 0;

        while(!queue.isEmpty()) {
            int out = queue.poll();
            if(out == N) {
                min = Math.min(min, dis[out]+1);
            }

            for(int l : list.get(out)) {
                if(dis[l] == -1) {
                    visited[l] = true;
                    queue.add(l);
                    dis[l] = dis[out] +1;
                }
            }
        }
    }
}
