package 일단풀어보기;

import java.io.*;
import java.util.*;

public class BOJ11725 {

    static ArrayList<ArrayList<Integer>> list;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new int[N+1];
        
        list = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=N+1; i++) {
            list.add(new ArrayList<Integer>());
        }

        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs(1);

        for(int i=2; i<visited.length; i++)
            System.out.println(visited[i]);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = start;
        
        while(!queue.isEmpty()) {
            int out = queue.poll(); // 1이 나옴
            for(int l : list.get(out)) { //out : 1 , l : 6
                if(visited[l] == 0){
                    queue.add(l);
                    visited[l] = out;
                }
            }

        }
    }
    
}
