package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ1707 { //그래프의 dfs는 각 정점마다 타고 들어가며 확인하는 듯..?
    static Queue<Integer> queue = new LinkedList<>();

    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static int[] visited;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); //정점개수
            int E = Integer.parseInt(st.nextToken()); //간선개수
            visited = new int[V+1];
            flag = false;

            for(int j=0; j<=V; j++)
                list.add(new ArrayList<>());

            for(int j=0; j<E; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list.get(from).add(to);
                list.get(to).add(from);
            }

            // queue.add(1);
            // bfs();

            for(int j=1; j<=V; j++)
                dfs(i, 0);

           // dfs(1);
            if(flag)
                System.out.println("YES");
        }
    }


    /*
     * 주어진 그래프가 이분 그래프인지 확인하는 것은 어렵지 않다. 
     * 그래프의 꼭짓점들을 깊이 우선 탐색으로 나열한 뒤, ==> 깊이 우선 탐색의 base case 는 무엇일까 ?
     * 각 꼭짓점들을 이웃 꼭짓점들과 다른 색으로 계속해서 칠해 나가면서, 
     * 같은 색깔의 꼭짓점이 서로 연결되어 있는 모순이 발생하는지 여부를 확인하면 된다. 
     * 이 알고리즘은 O(|V|+|E|)이다.



     */

     static void dfs(int x, int color) {
        visited[x] = color;
        int nextColor = 1-color;

        for(int l: list.get(x)) {
            if(visited[l] == 0){
              //  visited[l] = true;
                dfs(l, nextColor);
              //  visited[l] = false;
            } else {
                if(visited[l] == visited[x]){
                    flag = true;
                    System.out.println("NO");
                    return ;
                }
            }
        }
     }
    // static void bfs() {
    //     while(!queue.isEmpty()) {
    //         int out = queue.poll();

    //         for(int l : list.get(out)) { //l.bg랑 
    //             if(!visited[l]) {
    //                 if(l.bg == out.bg) {
    //                     System.out.println("NO " + l.n + " , " + out.n);
    //                     flag = true;
    //                     return ;
    //                 }
    //                 queue.add(new Graph((l.n), l.bg));
    //                 visited[l.n] = true;
    //             }
    //         }
    //     }
    // }
}
