package 일단풀어보기;

import java.io.*;
import java.util.*;

public class BOJ2644 {
    static ArrayList< ArrayList<Integer> > family;
    static int[] dist;
    static int p1, p2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //전체 인원수
        dist = new int[n+1];
        Arrays.fill(dist, -1);

        family = new ArrayList< ArrayList<Integer> >();

        for(int i=0; i<n+1; i++)
            family.add(new ArrayList<Integer>());

        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken()); //촌수 구해야하는 첫번째 사람
        p2 = Integer.parseInt(st.nextToken()); //촌수 구해야하는 첫번째 사람

        int m = Integer.parseInt(br.readLine()); 

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            family.get(parent).add(child);
            family.get(child).add(parent);
        }

        bfs(p1);
    }

    static void bfs(int start) {
        boolean flag = false;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        while(!queue.isEmpty()) {
            int out = queue.poll(); //
            //System.out.println(out);
            if(out == p2) {
                System.out.println(dist[out]);
                flag = true;
                return ;
            }
            for(int l : family.get(out)) { //out : 
                if(dist[l] == -1) { 
                    queue.add(l);
                    dist[l] = dist[out] + 1;
                }
            }
        }

        if(!flag)
            System.out.println(-1);
        return ;
    }
    
}
