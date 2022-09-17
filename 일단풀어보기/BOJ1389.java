package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1389 {
    static int N, M;
    static int[] dist, b;

    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        b = new int[N+1];
        for(int i=0; i<=N; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            list.get(end).add(start);
        }


        int min = Integer.MAX_VALUE;

        for(int i=1; i<=N; i++){
            dist = new int[N+1];
            bfs(i);
            int sum = 0;
            for(int j=1; j<=N; j++)
                sum += dist[j];
            b[i] = sum;
            min = Math.min(min, b[i]);
        }

        for(int i=1; i<=N; i++){
            if(min == b[i]){
                System.out.println(i);
                break;
            }
        }
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        dist[x] = 1;

        while(!queue.isEmpty()) {
            int out= queue.poll();
            for(int l : list.get(out)) {
                if(dist[l] == 0){
                    queue.add(l);

                    dist[l] = dist[out] + 1;
                }
            }
        }
    }
}
