import java.util.*;
import java.io.*;

public class BOJ13913 {
    static int N, K;

    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        visited = new boolean[100001];
        dist = new int[100001];

        bfs(N);
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        int[] arr = new int[1000001];
        queue.add(x);
        visited[x] = true;

        while(!queue.isEmpty()) {
            int out = queue.poll();

            // if(out == K){
            //     System.out.println(dist[out]);
            //     return ;
            // }

            int[] move = {-1, 1, out};
            for(int i=0; i<3; i++) {
                int next = out + move[i];

                if(next < 0 || next>100000) continue;
                else if(visited[next]) continue;
                else {
                    queue.add(next);
                    visited[next] = true;

                    if(dist[next] != 0)
                        dist[next] = Math.min(dist[next], dist[out]+1);
                       else 
                        dist[next] = dist[out] + 1;       

                    arr[dist[next]] = next;
                    System.out.println("idx: " + dist[next] + " 의 값 : " + arr[dist[next]]);

                    if(K == next){
                        System.out.println(dist[next]);
                        for(int idx=0; idx<dist[next]; idx++)
                            System.out.println(arr[idx]);
                        return ;
                    }

                   // System.out.println(dist[next] + " / " + next + " 그리고 " + dist[out] + " / " + out);      
                   /**
                    * 
                    이동 경로는 parent 배열을 사용합니다.

                    현재 위치 A 에서 다음 경로로 가는 방법은 3개여서 저장하기가 애매합니다.

                    그런데 현재 위치 A 로 이동했던 출발지는 1개입니다.

                    따라서 parent 배열에는 이전 경로를 저장한 뒤, 최종 도착지인 K 부터 N 까지 다시 거슬러 올라가면 됩니다.
                     ㅇ*/    
                }
            }
        }
    }
}
