package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13023 {
    static ArrayList<ArrayList<Integer>> friend = new ArrayList<ArrayList<Integer>>();
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //사람 수
        M = Integer.parseInt(st.nextToken()); //관계 수
        visited = new boolean[N];

        for(int i=0; i<N; i++)
            friend.add(new ArrayList<>());
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            friend.get(from).add(to);
            friend.get(to).add(from);
        }
        for(int i=0; i<N; i++){

            visited = new boolean[N];
            dfs(0, i);
        }
        System.out.println(0);
    }

    static void dfs(int curr, int x) {
        if(curr == 4){
            System.out.println(1);
            System.exit(0);
        }

        visited[x] = true;
        for(int f: friend.get(x)) {
            //visited[x] = false;
            if(!visited[f]) {
                //visited[f] = true;
                dfs(curr+1, f);
                //visited[f] = false;
           }
        }
        visited[x] = false;
        
    }
}
