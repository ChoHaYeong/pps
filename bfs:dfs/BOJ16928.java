import java.util.*;
import java.io.*;

public class BOJ16928 {
    // static int[] board = new int[101];
    // static int[] visited = new int[101];
    // static int N, M;

    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st = new StringTokenizer(br.readLine());
    //     N = Integer.parseInt(st.nextToken()); //사다리 수
    //     M = Integer.parseInt(st.nextToken()); //뱀의 수

    //     Arrays.fill(visited, -1);

    //     for(int i=0; i<N+M; i++) {
    //         st = new StringTokenizer(br.readLine());
    //         int start = Integer.parseInt(st.nextToken());
    //         int end = Integer.parseInt(st.nextToken());

    //         board[start] = end;
    //     }

    //     bfs(1);
    //     //System.out.println(min);
    // }

    // static void bfs(int n) {
    //     Queue<Integer> queue = new LinkedList<>();
    //     int[] dx = {1, 2, 3, 4, 5, 6};
    //     queue.add(n);
    //     visited[n] = 0;

    //     while(!queue.isEmpty()) {
    //         int out = queue.poll();

    //         if(out == 100){
    //             System.out.println(visited[out]);
    //             return ;
    //         }

            
    //         //System.out.println(ox + " , " + oy + " -> " + out +  " / " +  (visited[ox][oy] + 1));
    //         for(int i=0; i<6; i++) {
    //             int nx = out+ dx[i];

    //             if(nx < 0 || nx > 100) continue;
    //             if(visited[nx] > -1 ) continue;
    //             if(board[nx] != 0) { //뱀이나 사다리인 경우
    //                 int num = board[nx];

    //                 if(visited[num] == -1) { //뱀이나 사다리로 이동하는 곳을 아직 방문하지 않았다면, 그곳을 큐에 넣는다.
    //                     queue.add(num);
    //                     visited[num] = visited[out] + 1;
    //                 }
    //             }
    //             //그냥 주사위 굴리는 중 
    //             else {
    //                 queue.add(nx);
    //                 visited[nx] = visited[out] + 1;
    //             }

    //         }
    //     }

    // }

    static int N, M, dis;
    static int[] ladder, snake, b, dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        b = new int[101];
        ladder = new int[101];
        snake = new int[101];
        dist = new int[101];
        Arrays.fill(dist, -1);

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ladder[start] = end;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            snake[start] = end;
        }

        bfs(1);
       System.out.println(dist[100]);
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        dist[x] = 0;
        //visited[x] = true;

        while(!queue.isEmpty()) {
            int out = queue.poll();
            // if(out == 100 ){
            //     System.out.println(dist[out]);
            //     return ;
            // }
            //  System.out.println(out + " - " + dist[out]);
            for(int i=1; i<=6; i++) {
                int next = out+i;

                if(ladder[next] != 0) {
                    next = ladder[next];
                }
                else if(snake[next] != 0) {
                    next = snake[next];
                }

               // if(next == 100) return ;
                if(next <= 100 && dist[next] == -1) {
                    // if(ladder[next] != 0) {
                    //     next = ladder[next];
                    // }
                    // else if(snake[next] != 0) {
                    //     next = snake[next];
                    // }

                    // if(dist[next] == -1) {

                        dist[next] = dist[out] + 1;
                        queue.add(next);
                     //   dis = dist[next];
                  //  }
                }
            }
        }
    }
    
}
