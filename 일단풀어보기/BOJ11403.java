package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11403 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int N;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        for(int i=0; i<N; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    list.get(i).add(j);
                    //list.get(j).add(i);
                }

            }
        }

        // for(int i=0; i<N; i++) {
        //     System.out.print(i + " => ");
        //     for(int j=0; j<1; j++) {
        //         System.out.print(list.get(i).get(j) + " ");

        //     }
        //     System.out.println();
        // }

        bfs();
        
    }

    static void bfs() {
        
        
        for(int i=0; i<N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            //visited[i] = true;

            while(!queue.isEmpty()) {
                int out = queue.poll();
               // System.out.print(1 + " ");

                for(int l : list.get(out)) {
                    if(!visited[l]) {
                        queue.add(l);
                        visited[l] = true;
                    }
                }
            }

            for(int j=0; j<N; j++){
                if(visited[j])
                    System.out.print(1 + " ");
                else
                    System.out.print(0 + " ");
            }

            System.out.println();

            Arrays.fill(visited, false);
        }
    }
    
}
