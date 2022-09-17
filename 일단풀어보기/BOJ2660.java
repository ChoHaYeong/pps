package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2660 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static int[] depth, candidate;
    static int N, min = Integer.MAX_VALUE, max = 0;
   //static List<Integer> candidate = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //회원 수
        candidate = new int[N+1];

        for(int i=0; i<N+1; i++)
            list.add(new ArrayList<>());

        //int to, from;
        //StringTokenizer st = new StringTokenizer(br.readLine());
        while(true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            if(to == -1 && from == -1) break;
            //i(to = Integer.parseInt(st.nextToken())) != -1 && (from = Integer.parseInt(st.nextToken())) != -1
            list.get(to).add(from);
            list.get(from).add(to);
        }

        for(int i=1; i<N+1; i++) {
            depth = new int[N+1]; //depth배열 초기화
           // min = Integer.MAX_VALUE; //최소임.. 거리값 초기화
            bfs(i);
            candidate[i] = max;

            //System.out.println(candidate[i]);
        }
        int boss = Integer.MAX_VALUE ;
        for(int i =1; i<=N; i++ ){
            boss = Math.min(boss, candidate[i]);
        }
        List<Integer> l = new LinkedList<>();
        for(int i =1; i<=N; i++ )
            if(boss == candidate[i]) l.add(i);

        System.out.println(boss + " " + l.size());
        for(int ll : l)
            System.out.print(ll + " ");
    }

    static void bfs(int x) {
        max = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        while(!queue.isEmpty()) {
            int out = queue.poll();
            for(int l: list.get(out)) {
                if(depth[l] == 0) {
                    queue.add(l);
                    depth[l] = depth[out] + 1;
                    if(l != x)
                        max = Math.max(max, depth[l]);
                }
            }
        }
    }
}
