import java.io.*;
import java.util.*;

public class BOJ1697 {
    static int N, K, C  = 0;
    static int[] visited, parent;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //수빈이가 있는 위치
        K = Integer.parseInt(st.nextToken()); //동생이 있는 위치
        visited = new int[200001];
        parent = new int[200001];
        Arrays.fill(visited, -1);
        if(N == K){
            System.out.println(0);
            return ;
        }
        bfs(N);
        //System.out.println(C);
    }

    static void bfs(int n) {
        queue.add(n);
        visited[n] = 0;

        while(!queue.isEmpty()) {
            int out = queue.poll();
            
            int[] dx = {-1, 1, out};

            for(int i=0; i<3; i++) {
                int next = out + dx[i];

                if(next>=0 && next<=K && visited[next] == -1) {

                    visited[next] = visited[out] + 1;
                    queue.add(next);
                    parent[next] = out;

                    if(next == K) {
                        System.out.println(visited[next]);
                        // Stack<Integer> stack = new Stack<>();
                        // stack.push(K);
                        // int cnt = visited[next];
                        // for(int k=0; k<cnt; k++) {
                        //    //System.out.println(parent[next]);
                        //     stack.push(parent[next]);
                        //     next = parent[next];
                        // }

                        // while(!stack.isEmpty())
                        //     System.out.print(stack.pop() + " ");
                        // System.out.println();
                        // return ;
                    }
                }
            }


        }

        LinkedList<Integer> queue2 = new LinkedList<>();
        queue2.add(K);
        while(queue2.peek() != N) {
            queue2.addFirst(parent[queue2.peek()]);
        }

        for(int q:queue2) {
            System.out.print(q + " ");
        }


    }
}
